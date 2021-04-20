package com.ng.emts.esd.crazynaijadeal.api;

import com.ng.emts.esd.crazynaijadeal.model.request.IPCCRequestBody;
import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.CrazyNaijaRequestLog;
import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.GiftAccessCode;
import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.ValueConfig;
import com.ng.emts.esd.crazynaijadeal.repo.CrazyNaijaRequestLogRepo;
import com.ng.emts.esd.crazynaijadeal.service.CrazyNaijaDealService;
import com.ng.emts.esd.crazynaijadeal.service.GiftCodeService;
import com.ng.emts.esd.crazynaijadeal.service.ValueConfigService;
import com.ng.emts.esd.crazynaijadeal.util.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CrazyNaijaDealController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final CrazyNaijaDealService crazyNaijaDealService;
    private final CrazyNaijaRequestLogRepo crazyNaijaRequestLogRepo;
    private final ValueConfigService valueConfigService;
    private final GiftCodeService giftCodeService;

    @Autowired
    public CrazyNaijaDealController(CrazyNaijaDealService crazyNaijaDealService, CrazyNaijaRequestLogRepo crazyNaijaRequestLogRepo, ValueConfigService valueConfigService, GiftCodeService giftCodeService) {
        this.crazyNaijaDealService = crazyNaijaDealService;
        this.crazyNaijaRequestLogRepo = crazyNaijaRequestLogRepo;
        this.valueConfigService = valueConfigService;
        this.giftCodeService = giftCodeService;
    }

    @PostMapping(
            value = "/apply",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {"application/json", "application/xml", "application/text"})
    public void redeem(@RequestParam Map<String, String> ussdRequestMap) {
        IPCCRequestBody requestBody = new IPCCRequestBody();
        String message = ussdRequestMap.get("message");
        requestBody.setRequestString(message);
        String msisdn = ussdRequestMap.get("msisdn");
        requestBody.setMsisdn(msisdn);
        String shortCode = ussdRequestMap.get("shortCode");
        requestBody.setShortCode(shortCode);
        requestBody.setServiceId(ussdRequestMap.get("service"));
        requestBody.setVasId(ussdRequestMap.get("vasid"));
        requestBody.setSubscriptionDate(Config.setSubscriptionDate());

        logger.info("############### INCOMING REQUEST ####################");
        logger.info(requestBody.toString());
        LocalDateTime requestInTime = LocalDateTime.now();
        CrazyNaijaRequestLog crazyNaijaRequestLog = new CrazyNaijaRequestLog(msisdn, message, shortCode, requestInTime, null);
        crazyNaijaRequestLogRepo.save(crazyNaijaRequestLog);
        crazyNaijaDealService.redeemCode(requestBody, crazyNaijaRequestLog);
    }

    @PostMapping("/add-config")
    public ResponseEntity<List<ValueConfig>> addConfig(@RequestBody ValueConfig config){
        if(config != null){
            valueConfigService.addConfig(config);
            crazyNaijaDealService.setDefault();
            return new ResponseEntity<>(valueConfigService.valueConfigs(), HttpStatus.CREATED);
        }
        return null;
    }
    @GetMapping("/referesh")
    public ResponseEntity<List<ValueConfig>> refresh(){
        crazyNaijaDealService.setDefault();
        return new ResponseEntity<>(valueConfigService.valueConfigs(), HttpStatus.OK);
    }


    @GetMapping("/assign-crazy-code")
    public ResponseEntity<List<GiftAccessCode>> doCrazyCodeAssign(){
        List<GiftAccessCode> giftAccessCodes = crazyNaijaDealService.doCrazyCodeAssign();
        return new ResponseEntity<>(giftAccessCodes,HttpStatus.CREATED);
    }
    @GetMapping("/generate-codes/{limit}")
    public ResponseEntity<List<GiftAccessCode>> dooCrazyCodeAssign(@PathVariable int limit){
        List<GiftAccessCode> giftAccessCodes = giftCodeService.generateGiftCode(limit);
        return new ResponseEntity<>(giftAccessCodes,HttpStatus.CREATED);
    }
    @GetMapping("/send-code")
    public void dooCrazyCodeAssign(){
        crazyNaijaDealService.doGiftingOfAccessCodes();
    }

    @GetMapping("/reassign-crazy")
    public void dooCrazyCodeReAssign(){
        crazyNaijaDealService.reAssignCrazy();
    }

    @GetMapping("/getUnusedExpired/{days}")
    public ResponseEntity<List<GiftAccessCode>> getUnusedExpired(@RequestParam int days){
        List<GiftAccessCode> expiredUnusedGiftAccessCodes = giftCodeService.getUnusedGiftAccessCodesAfterXDays(days);
        return new ResponseEntity<>(expiredUnusedGiftAccessCodes,HttpStatus.OK);
    }

    @GetMapping("/getUnusedExpired")
    public ResponseEntity<List<GiftAccessCode>> getUnusedExpiredTwo(){
        List<GiftAccessCode> expiredUnusedGiftAccessCodes = giftCodeService.getUnusedGiftAccessCodesAfterXDays();
        return new ResponseEntity<>(expiredUnusedGiftAccessCodes,HttpStatus.OK);
    }
}
