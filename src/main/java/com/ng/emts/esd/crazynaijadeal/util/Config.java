package com.ng.emts.esd.crazynaijadeal.util;

import com.ng.emts.esd.crazynaijadeal.exceptions.BadRequestException;
import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.CrazyCode;
import com.ng.emts.esd.crazynaijadeal.model.request.dataobjects.GiftAccessCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Config {
    @Value("${smpp.api.sendSmsUrl}")
    private String smsUrl;
    @Value("${smpp.api.sendSmsUrl1}")
    private String smsUrl1;
    @Value("${black.friday.url}")
    private String blackFridayUrl;
//    @Value("${sms.regular}")
//    private String regularSMS;
//    @Value("${sms.crazy}")
//    private String crazySMS;
//    @Value("${sms.sms700}")
//    private String sms700;


    public String getSmsUrl() {
        return smsUrl;
    }

    public void setSmsUrl(String smsUrl) {
        this.smsUrl = smsUrl;
    }

    public String getSmsUrl1() {
        return smsUrl1;
    }

    public void setSmsUrl1(String smsUrl1) {
        this.smsUrl1 = smsUrl1;
    }

    public String getBlackFridayUrl() {
        return blackFridayUrl;
    }

    public void setBlackFridayUrl(String blackFridayUrl) {
        this.blackFridayUrl = blackFridayUrl;
    }

    //    public String getRegularSMS() {
//        return regularSMS;
//    }
//
//    public void setRegularSMS(String regularSMS) {
//        this.regularSMS = regularSMS;
//    }
//
//    public String getCrazySMS() {
//        return crazySMS;
//    }
//
//    public void setCrazySMS(String crazySMS) {
//        this.crazySMS = crazySMS;
//    }
//
//    public String getSms700() {
//        return sms700;
//    }
//
//    public void setSms700(String sms700) {
//        this.sms700 = sms700;
//    }

    public static String generateTransactionReference(String paymentVendor, String paymentReference) throws NoSuchAlgorithmException {
        String transactionReference = paymentVendor + "|" + paymentReference + "|" + System.currentTimeMillis();
        return HashUtil.getMD5Hash(transactionReference.getBytes());
    }

    public static String generateTransactionReference(String msisdn){
        String transactionReference = msisdn + "|" + System.currentTimeMillis();
        try {
            return HashUtil.getMD5Hash(transactionReference.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new BadRequestException(e.getMessage());
        }
    }

    public static String generateTransactionReference2(String paymentVendor, String paymentReference) throws NoSuchAlgorithmException {
        return paymentVendor + "|" + paymentReference + "|" + System.currentTimeMillis();
    }

    public static UUID generateUUID(){
        return UUID.randomUUID();
    }
    public static LocalDateTime getPresentDate(){
        return LocalDateTime.now();
    }

    public static String stripMsisdn(String msisdn) {
        if (msisdn.startsWith("+234")) {
            msisdn = msisdn.substring(4);
        } else if (msisdn.startsWith("234")) {
            msisdn = msisdn.substring(3);
        } else if (msisdn.startsWith("0")) {
            msisdn = msisdn.substring(1);
        }
        return msisdn;
    }
    public static String cbsTimestampToString(Timestamp txDate) {
        Date date = new Date(txDate.getTime());
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(date);
    }
    public static Timestamp addDaysToTimestamp(Timestamp ts, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(ts);
        cal.add(Calendar.DAY_OF_WEEK, days);
        return new Timestamp(cal.getTime().getTime());
    }
    public static Timestamp setSubscriptionDate() {
        Calendar today = Calendar.getInstance();
        return (new Timestamp(today.getTimeInMillis()));
    }

}
