package com.ssmtest.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 96195 on 2018/6/24.
 */
public class Tools {
    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }



    public static String getMD5Str(String origStr) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("md5");

            byte[] buf = md.digest(origStr.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            String str2 = encoder.encode(buf);
            return str2;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return  null;
        }

    }
}
