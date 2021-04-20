package com.ng.emts.esd.crazynaijadeal.service;

import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.CrazyCode;
import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.GiftAccessCode;
import com.ng.emts.esd.crazynaijadeal.repo.CrazyCodeRepo;
import com.ng.emts.esd.crazynaijadeal.repo.GiftAccessCodeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GiftCodeService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CrazyCodeRepo crazyCodeRepo;
    private final GiftAccessCodeRepo giftAccessCodeRepo;

    @Autowired
    public GiftCodeService(CrazyCodeRepo crazyCodeRepo, GiftAccessCodeRepo giftAccessCodeRepo) {
        this.crazyCodeRepo = crazyCodeRepo;
        this.giftAccessCodeRepo = giftAccessCodeRepo;
    }
     public List<GiftAccessCode> getAccessCodes(){
         List<GiftAccessCode> all = giftAccessCodeRepo.findByUsedFalseAndMsisdnIsNull();
         return all;
     }
     public List<GiftAccessCode> getAssignedAccessCodes(){
         List<GiftAccessCode> all = giftAccessCodeRepo.findByMsisdnIsNotNullAndUsedFalse();
         return all;
     }

     public void updateGiftAccessCode(GiftAccessCode giftAccessCode, int accessCodeExpiry){
        logger.info("##################--- Updating Coupon Status for "+giftAccessCode.getGiftCode()+" ----------############");
        giftAccessCode.setStartDate(LocalDateTime.now());
        giftAccessCode.setGiftCodeExpiry(giftAccessCode.getStartDate().plusDays(accessCodeExpiry));
        giftAccessCodeRepo.save(giftAccessCode);
     }

     public void expireGiftAccessCode(GiftAccessCode accessCode){
        accessCode.setExpired(true);
        giftAccessCodeRepo.save(accessCode);
     }

    public List<GiftAccessCode> getUnusedGiftAccessCodesAfterXDays(List<GiftAccessCode> accessCodes, int days) {
        return accessCodes.stream().filter(x -> {
            LocalDateTime startDate = x.getStartDate();
            LocalDate start = LocalDate.from(startDate);
            return start.plusDays(days).equals(LocalDate.now());
        }).collect(Collectors.toList());
    }
    public List<GiftAccessCode> getUnusedGiftAccessCodesAfterXDays(int days) {
        List<GiftAccessCode> accessCodes = giftAccessCodeRepo.findAll();
        return accessCodes.stream().filter(x -> x.getStartDate() !=null).filter(x -> {
            LocalDateTime startDate = x.getStartDate();
            LocalDate start = LocalDate.from(startDate);
            return start.plusDays(days).isAfter(LocalDate.now());
        }).collect(Collectors.toList());
    }


    public List<GiftAccessCode> getUnAssignedAccessCode(){
        return giftAccessCodeRepo.findByMsisdnIsNullAndCrazyGiftCodeIsNull();
    }
    public List<GiftAccessCode> getUnusedGiftAccessCodesAfterXDays(){
        List<GiftAccessCode> byUsedFalseAndExpiredTrue = giftAccessCodeRepo.findByUsedFalseAndExpiredFalseAndMsisdnIsNotNull();
        Predicate<GiftAccessCode> giftAccessCodePredicate = x -> LocalDate.from(x.getGiftCodeExpiry()).isBefore(LocalDate.now());
        return byUsedFalseAndExpiredTrue.stream().filter(giftAccessCodePredicate).collect(Collectors.toList());
    }

     public void updateGiftAccessCodeUsedStatus(GiftAccessCode giftAccessCode){
        logger.info("##################--- Updating Coupon Status for "+giftAccessCode.getGiftCode()+" ----------############");
        giftAccessCode.setDateUsed(LocalDateTime.now());
        giftAccessCode.setUsed(true);
        giftAccessCodeRepo.save(giftAccessCode);
     }

     public GiftAccessCode getCodeDetails(String code){
         Optional<GiftAccessCode> giftCode = giftAccessCodeRepo.findByGiftCode(code);
         return giftCode.orElse(null);
     }

    public List<GiftAccessCode> generateGiftCode(int limit){
        return Stream.generate(Math::random)
                .map(g -> Math.round(g * 10000000))
                .distinct()
                .limit(limit)
                .map(x -> {
                    GiftAccessCode giftAccessCode = new GiftAccessCode(String.valueOf(x), "A");
                    giftAccessCodeRepo.save(giftAccessCode);
                    return giftAccessCode;
                })
                .collect(Collectors.toList());
    }
    private void assignCrazyCode(List<CrazyCode> crazyCodes, List<GiftAccessCode> giftCodes){
        for (CrazyCode entry: crazyCodes) {
            Optional<GiftAccessCode> anyGiftAccessCode = giftCodes.stream().filter(x -> x.getCrazyGiftCode() == null).findAny();
            if(anyGiftAccessCode.isPresent()){
                GiftAccessCode giftAccessCode = anyGiftAccessCode.get();
                giftAccessCode.setCrazyGiftCode(entry.getCrazyCode());
                giftAccessCode.setUrl(entry.getUrl());
                giftAccessCodeRepo.save(giftAccessCode);
            }
        }
    }
    public void doCrazyCodeAssign(){
        List<CrazyCode> crazyCodes = crazyCodeRepo.findAll();
        List<GiftAccessCode> giftAccessCodes = getUnAssignedAccessCode();
        assignCrazyCode(crazyCodes,giftAccessCodes);
    }
}
