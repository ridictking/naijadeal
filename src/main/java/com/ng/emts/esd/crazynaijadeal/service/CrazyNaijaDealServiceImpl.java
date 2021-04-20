package com.ng.emts.esd.crazynaijadeal.service;

import com.ng.emts.esd.crazynaijadeal.exceptions.BadRequestException;
import com.ng.emts.esd.crazynaijadeal.model.request.*;
import com.ng.emts.esd.crazynaijadeal.model.request.besrequest.*;
import com.ng.emts.esd.crazynaijadeal.model.request.cbsrequest.changeappendant.ChangeAppendantProductResponseData;
import com.ng.emts.esd.crazynaijadeal.model.request.cbsrequest.changeappendant.ChangeAppendantRequestData;
import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.*;
import com.ng.emts.esd.crazynaijadeal.model.response.besresponse.CreateSupplementaryOfferingModificationOrderResponseData;
import com.ng.emts.esd.crazynaijadeal.repo.CrazyCodeRepo;
import com.ng.emts.esd.crazynaijadeal.repo.CrazyNaijaRequestLogRepo;
import com.ng.emts.esd.crazynaijadeal.util.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Service
public class CrazyNaijaDealServiceImpl implements CrazyNaijaDealService {
    private static final String SMS_100_MESSAGE = "";
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final String SERVICE_ID = "CHRISTMAS-OFFER";

    private final SmsClient smsClient;
    private final RechargeService rechargeService;
    private final CrazyNaijaRequestLogRepo crazyNaijaRequestLogRepo;
    private final GiftCodeService giftCodeService;
    private final CrazyCodeRepo crazyCodeRepo;
    private final Config config;
    private int crazyIndex;
    private int giftAccessCodeIndex;
    private LocalDate LAUNCH_DATE;
    private LocalDate END_DATE;
    private int accessCodeExpiry;
    private int crazyCodeExpiry;
    private final CbsBesClientService cbsBesClientService;
    private final ValueConfigService valueConfigService;
    private Map<String,String> configs = new HashMap<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
    private static final String appAppender = "CRAZY_NAIJA_DEAL_";
    private List<GiftAccessCode> accessCodes;


    @Autowired
    public CrazyNaijaDealServiceImpl(SmsClient smsClient, RechargeService rechargeService, CrazyNaijaRequestLogRepo crazyNaijaRequestLogRepo, GiftCodeService giftCodeService, CrazyCodeRepo crazyCodeRepo, Config config, CbsBesClientService cbsBesClientService, ValueConfigService valueConfigService) {
        this.smsClient = smsClient;
        this.rechargeService = rechargeService;
        this.crazyNaijaRequestLogRepo = crazyNaijaRequestLogRepo;
        this.giftCodeService = giftCodeService;
        this.crazyCodeRepo = crazyCodeRepo;
        this.config = config;
        this.cbsBesClientService = cbsBesClientService;
        this.valueConfigService = valueConfigService;
        this.crazyIndex = 0;
        this.giftAccessCodeIndex = 0;
        this.accessCodes = giftCodeService.getAccessCodes();
        setDefault();
    }

    public void setDefault(){
        List<ValueConfig> valueConfigs = valueConfigService.valueConfigs();
        configs = new HashMap<>();
        for (ValueConfig vc : valueConfigs) {
            configs.put(vc.getConfigName(),vc.getConfigValue());
        }
        LAUNCH_DATE = LocalDate.parse(configs.get(appAppender+"LAUNCH_DATE"), formatter);
        END_DATE = LocalDate.parse(configs.get(appAppender+"END_DATE"), formatter);
        accessCodeExpiry = Integer.parseInt(configs.get(appAppender+"ACCESS_CODE_EXPIRY"));
        crazyCodeExpiry = Integer.parseInt(configs.get(appAppender+"CRAZY_CODE_EXPIRY"));
        logger.info("END Date: " + END_DATE);
        logger.info("LAUNCH Date: " + LAUNCH_DATE);
        logger.info("ACCESS CODE EXPIRY " + accessCodeExpiry);
        logger.info("CRAZY CODE EXPIRY: " + crazyCodeExpiry);
    }

    @Override
    public List<GiftAccessCode> doCrazyCodeAssign() {
        giftCodeService.doCrazyCodeAssign();
        List<GiftAccessCode> giftAccessCodes = giftCodeService.getAccessCodes().stream().filter(x -> x.getCrazyGiftCode() != null).collect(Collectors.toList());
        return giftAccessCodes;
    }

    private String sendSms(SmsRequest request){
        if(StringUtils.hasText(request.getMsisdn())){
            return smsClient.sendSms1(request).getBody();
        }else {
            throw new BadRequestException("Recipient Msisdn cannot be absent");
        }
    }

    @Override
    public void redeemCode(IPCCRequestBody request, CrazyNaijaRequestLog crazyNaijaRequestLog){
        //check if code exist
        logger.info("Incoming request: " + request.getRequestString());
        String requestString[] = request.getRequestString().replaceAll("\\W"," ").split(" ");
        String giftCode = requestString[2];
        if(LocalDate.now().isAfter(END_DATE)){
            updateRequestLog(crazyNaijaRequestLog);
            sendSms(buildSmsRequest(Config.stripMsisdn(request.getMsisdn()),"Sorry, the Crazy Naija Deal Campaign has ended"));
            throw new BadRequestException("Crazy Naija Deal Campaign has ended");
        }
        GiftAccessCode codeDetails = giftCodeService.getCodeDetails(giftCode);
        if(codeDetails == null){
            sendSms(buildSmsRequest(Config.stripMsisdn(request.getMsisdn()),"Sorry, the access code used is invalid. Please check and try again."));
            updateRequestLog(crazyNaijaRequestLog);
            throw new BadRequestException("Invalid Access code");
        }
        //check if code is used
        if(codeDetails.isUsed()){
            sendSms(buildSmsRequest(Config.stripMsisdn(request.getMsisdn()),"Sorry, this Crazy Naija Deal Campaign access code has already been used."));
            updateRequestLog(crazyNaijaRequestLog);
            throw new BadRequestException("Used Access code");
        }
        if(codeDetails.isExpired()){
            sendSms(buildSmsRequest(Config.stripMsisdn(request.getMsisdn()),"Sorry, the access code used has expired."));
            updateRequestLog(crazyNaijaRequestLog);
            throw new BadRequestException("Expired Access code");
        }
        if(!Config.stripMsisdn(request.getMsisdn()).equalsIgnoreCase(Config.stripMsisdn(codeDetails.getMsisdn()))){
            sendSms(buildSmsRequest(Config.stripMsisdn(request.getMsisdn()),"Dear customer, you are not eligible to use this code. Please call 200 for more info. "));
            updateRequestLog(crazyNaijaRequestLog);
            throw new BadRequestException("Dear customer, you are not eligible to use this code. Please call 200 for more info.");
        }
        //call cbs
        ChangeAppendantRequestData requestData = buildChangeAppendantOperation(request, "2021030701");
        logger.info("CBS request data " + requestData);
        ChangeAppendantProductResponseData cbsResponse = callCBS(requestData);
        logger.info("CBS request data " + cbsResponse);
        if(cbsResponse.getDescription().equalsIgnoreCase("Operation successful!")) {
            String successA  = "Congratulations! You have been gifted free 30MB and 60MB " +
                    "locked data valid till dd/mm/yyyy. Buy data worth N50 to N100 to unlock " +
                    "30MB or N200 and above to unlock 60MB within the next "+accessCodeExpiry+" days";
            String successB = "Congratulations! You have just won a right to buy XYZ item " +
                    "(eg iPhone 12 at N9000) for just Nxx. Kindly click this link " + codeDetails.getUrl() + " and " +
                    "apply the Crazy discount Code "+ giftCode+" to purchase the item. " +
                    "Keep recharging to win again." ;
            codeDetails.setCbsTransactionReference(requestData.getEffectiveDate());
            if (StringUtils.hasText(codeDetails.getCrazyGiftCode())) {
                sendSms(buildSmsRequest(Config.stripMsisdn(request.getMsisdn()), successB));
                Optional<CrazyCode> byCrazyCode = crazyCodeRepo.findByCrazyCode(codeDetails.getCrazyGiftCode());
                byCrazyCode.map(x -> byCrazyCode.get()).ifPresent(crazyCode -> {
                    crazyCode.setCbsTransactionId(requestData.getEffectiveDate());
                    crazyCode.setMsisdn(request.getMsisdn());
                    crazyCodeRepo.save(crazyCode);
                });
            }
            giftCodeService.updateGiftAccessCodeUsedStatus(codeDetails);
            updateRequestLog(crazyNaijaRequestLog);
            callBES(request,"2021030701");
        }
    }

    private void updateRequestLog(CrazyNaijaRequestLog crazyNaijaRequestLog) {
        crazyNaijaRequestLog.setRequestOutTime(LocalDateTime.now());
        crazyNaijaRequestLogRepo.save(crazyNaijaRequestLog);
    }

    @Override
    @Scheduled(cron = "0 15 * * * *")
    public void doGiftingOfAccessCodes(){
        doSevenHundredSms();
        logger.info("################### - Doing Gifting of access codes - ###########################");
        List<Recharge1000> requests = rechargeService.getAll();
        if (!requests.isEmpty()) {
            for(Recharge1000 x : requests){
                if (giftAccessCodeIndex < accessCodes.size()) {
                    disburseGift(accessCodes, x);
                }else{
                    giftAccessCodeIndex = 0;
                    accessCodes = giftCodeService.getAccessCodes();
                    if(accessCodes.isEmpty()){
                        return;
                    }else{
                        disburseGift(accessCodes, x);
                    }
                }
            }
        }
    }

    private void disburseGift(List<GiftAccessCode> accessCodes, Recharge1000 x) {
        doGiftTransaction(accessCodes, x);
        giftAccessCodeIndex++;
    }

    private void doGiftTransaction(List<GiftAccessCode> giftAccessCodes, Recharge1000 x) {
        GiftAccessCode giftAccessCode = giftAccessCodes.get(giftAccessCodeIndex);
            String giftCode = giftAccessCode.getGiftCode();
            logger.info("Sending Gift access code Message to MSISDN -- " + x.getMsisdn());
        String s = sendSms(buildSmsRequest(Config.stripMsisdn(x.getMsisdn()),String.format(
                    "Congratulations! You have been gifted with this unique " +
                            "access code *177*"+giftCode+"# valid till %s" +
                            " Dial the access code redeem your gift. Thank you. ",
                    LocalDate.now().plusDays(accessCodeExpiry))));
            logger.info("############ SMS service feedback --- " + s +" ##################");
            giftAccessCode.setMsisdn(x.getMsisdn());
            giftCodeService.updateGiftAccessCode(giftAccessCode,accessCodeExpiry);
    }


    @Override
    public void doSevenHundredSms(){
        List<Recharge700> recharge700 = rechargeService.getRecharge700();
        recharge700.forEach(x -> {
            logger.info("#####################--SENDING ENCOURAGEMENT MESSAGE TO " + x.getMsisdn());
            String p = sendSms(buildSmsRequest(x.getMsisdn(),String.format(
                    "You are almost there! Recharge %s more to enjoy the Crazy Naija offer",200- x.getCardvalue())));
        });
    }

    @Override
    @Scheduled(cron = "0 5 0 * * *")
    public void reAssignCrazy() {
        //get list of crazy codes
        List<GiftAccessCode> expiredAccessCodes = giftCodeService.getUnusedGiftAccessCodesAfterXDays();
        List<GiftAccessCode> giftAccessCodes = giftCodeService
                                                    .getUnAssignedAccessCode()
                                                        .stream()
                                                            .filter(x -> {
                                                                if(x.getGiftCodeExpiry() != null){
                                                                    return LocalDate.from(x.getGiftCodeExpiry()).isAfter(LocalDate.now()) || x.getGiftCodeExpiry() == null;
                                                                }else{
                                                                    return x.getGiftCodeExpiry() == null;
                                                                }
                                                            })
                                                                .collect(Collectors.toList());
        int i = 0;
        while(i < expiredAccessCodes.size()){
            GiftAccessCode expiredCode = expiredAccessCodes.get(i);
            sendSms(buildSmsRequest(Config.stripMsisdn(expiredCode.getMsisdn()),"Your granted access code has now expired"));
            if (expiredCode.getCrazyGiftCode() != null) {
                giftAccessCodes.get(i).setCrazyGiftCode(expiredCode.getCrazyGiftCode());
            }
            giftCodeService.expireGiftAccessCode(expiredCode);
            i++;
        }
    }


    @Scheduled(cron = "0 0 8 * * *")
    public void sendReminderAfterXDays() {
        List<GiftAccessCode> assignedUnUsed = giftCodeService.getAssignedAccessCodes();
        //List<GiftAccessCode> collect = unUsed.stream().filter(x -> x.getStartDate() != null).collect(Collectors.toList());
        sendReminder(assignedUnUsed,1);
        //sendReminder(assignedUnUsed,accessCodeExpiry/2);
        //sendReminder(unUsed,4);
        //sendReminder(unUsed,1);
    }


    public void sendReminder(List<GiftAccessCode> accessCodes, int days) {
        List<GiftAccessCode> unUsedAfterXDays = giftCodeService.getUnusedGiftAccessCodesAfterXDays(accessCodes, days);
        if (!unUsedAfterXDays.isEmpty()) {
            unUsedAfterXDays.forEach(x -> {
                logger.info("Doing reminder for msisdn "+ x.getMsisdn());
                String format = "";
                format = "MSISDN, don’t miss on this opportunity! You have %s crazy discount codes waiting for you to redeem. Keep recharging to win again.";
                sendSms(buildSmsRequest(x.getMsisdn(),String.format(format,x.getGiftCode())));
//
//                if(days == 1){
//                    format = "MSISDN, don’t miss on this opportunity! You have %s crazy discount codes waiting for you to redeem. Keep recharging to win again.";
//                    sendSms(buildSmsRequest(x.getMsisdn(),String.format(format,x.getGiftCode())));
//
//                }else{
//                    format = "Your access code to redeem the data and crazy discount " +
//                            "will expire on %s. Dial the code before expiry. T" +
//                            "he unique code is *177*%s#";
//                    sendSms(buildSmsRequest(x.getMsisdn(),String.format(format,LocalDate.from(x.getGiftCodeExpiry()),x.getGiftCode())));
//                }
            });
        }
    }




    private SmsRequest buildSmsRequest(String msisdn, String message){
        SmsRequest request = new SmsRequest();
        request.setCorrelationId(Config.generateUUID());
        request.setMsgType("0");
        request.setServiceid(SERVICE_ID);
        request.setMsisdn(Config.stripMsisdn(msisdn));
        request.setShortCode(2692);
        request.setMsg(message);
        return request;
    }
    private CrazyNaijaDealRequest buildBlackFridayLog(Recharge1000 recharge1000, String response, String coupon){
        return  new CrazyNaijaDealRequest(
                Config.generateTransactionReference(recharge1000.getMsisdn()),
                recharge1000.getMsisdn(),
                LocalDateTime.now(),
                recharge1000.getCardvalue(),
                response,
                coupon,
                recharge1000.getSubcosid(),
                recharge1000.getCnt(),
                recharge1000.getHr());
    }
    // For UAT purpose

    private ChangeAppendantProductResponseData callCBS(ChangeAppendantRequestData requestData_A) {
        ChangeAppendantProductResponseData cbsResponse_A = cbsBesClientService.changeAppendantProductResponseData(requestData_A);
        logger.info("Response from CBS " + cbsResponse_A.toString());
        return cbsResponse_A;
    }

    private void callBES(IPCCRequestBody request, String offeringCode) {
        CreateSupplementaryOfferingModificationOrderRequestData requestData = buildBesData(request, offeringCode);
        CreateSupplementaryOfferingModificationOrderResponseData besResponse = cbsBesClientService.createSupplementaryOfferingModificationOrderv2(requestData);
        logger.info("Response from BES " + besResponse.toString());
    }


    private CreateSupplementaryOfferingModificationOrderRequestData buildBesData(IPCCRequestBody request, String offeringCode) {
        CreateSupplementaryOfferingModificationOrderRequestData csomoRequestData = new CreateSupplementaryOfferingModificationOrderRequestData();
        csomoRequestData.setReason("createSupplementaryOfferingModificationOrder");
        csomoRequestData.setAppName("CRAZY-NIJA-DEAL");

        OrderData orderData = new OrderData();
        BusinessOwnershipData businessOwnership = new BusinessOwnershipData();
        businessOwnership.setBeId("101");
        businessOwnership.setBeCode(null);
        orderData.setBusiOwnership(businessOwnership);
        orderData.setBusinessFee(null);
        orderData.setContactPersonInfo(null);
        orderData.setInvoiceInfo(null);
        OrderBasicInfoData orderBasicInfo = new OrderBasicInfoData();
        orderData.setOrderBasicInfo(orderBasicInfo);
        orderData.setPaymentInfo(null);

        ArrayList<OrderItemData> orderItemArrayData = new ArrayList<>();
        OrderItemData theOrderItemData = new OrderItemData();
        theOrderItemData.setBusinessAction("2");
        theOrderItemData.setProperty(null);
        theOrderItemData.setId(null);
        ApplyObjectData applyObject = new ApplyObjectData("S", null, Config.stripMsisdn(request.getMsisdn()));
        theOrderItemData.setApplyObject(applyObject);
        ArrayList<OfferingData> offeringDataArray = new ArrayList<>();
        OfferingData theOfferingData = new OfferingData(String.valueOf(offeringCode), null, "A");
        theOfferingData.setAction("A");

        ArrayList<OfferingCharacteristicsData> offeringxtrcsArray = new ArrayList<>();

        theOfferingData.setOfferingCharacteristics(offeringxtrcsArray);

        offeringDataArray.add(theOfferingData);
        theOrderItemData.setOffering(offeringDataArray);
        orderItemArrayData.add(theOrderItemData);
        orderData.setOrderItem(orderItemArrayData);
        csomoRequestData.setOrder(orderData);
        logger.info("BES Request Data "+csomoRequestData.toString());
        return csomoRequestData;
    }

    private ChangeAppendantRequestData buildChangeAppendantOperation(IPCCRequestBody requestBody, String offeringCode){
        String transId = Long.toString(System.currentTimeMillis()) + Integer.toString(Math.abs(new Random().nextInt(99999)));
        ChangeAppendantRequestData requestData = new ChangeAppendantRequestData();
        requestData.setAppName("CRAZY_NAIJA_DEAL");
        requestData.setOperationType(1);
        requestData.setMsisdn(Config.stripMsisdn(requestBody.getMsisdn()));
        requestData.setProductStatus("0");
        requestData.setProductId(new String[]{offeringCode});
        requestData.setTxnId(transId);
        requestData.setEffectiveDate(Config.cbsTimestampToString(requestBody.getSubscriptionDate()));
        requestData.setGraceDays(accessCodeExpiry);

        return  requestData;
    }

}
