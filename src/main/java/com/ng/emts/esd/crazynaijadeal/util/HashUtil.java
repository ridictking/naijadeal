package com.ng.emts.esd.crazynaijadeal.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    public static String getMD5Hash(byte[] data) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] shaData = md.digest(data);
        return getHexString(shaData);
    }

    public static String getSha(byte[] data) throws  NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA_512");
        byte[] shaData = md.digest(data);
        return getHexString(shaData);
    }
    private static String getHexString(byte[] b) {
        StringBuilder result = new StringBuilder();
        for (byte value : b) {
            result.append(Integer.toString((value & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

}
