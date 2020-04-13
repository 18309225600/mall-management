package com.lhf.mall.management.util;

import java.security.MessageDigest;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/3/9
 **/
public class SecurityUtils {
    /**
     * md5加密
     * @param originStr 原串
     * @return
     */
    public static String md5(String originStr) {
        String md5str = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] input = originStr.getBytes();
            byte[] buff  = md.digest(input);
            md5str = ToHex(buff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str;
    }

    private static String ToHex(byte[] arr) {
        StringBuilder md5str = new StringBuilder();
        int digital;
        for (byte anArr : arr) {
            digital = anArr;
            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toLowerCase();
    }
}
