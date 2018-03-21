package com.milan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    //增加天数
    public static String addDay(int day){
        return "";
    }
    public static String getDataByUtime(String data){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(data)*1000;
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    /*
   * 将时间转换为时间戳
   */
    public static String getUTimeByData(String unixTime) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(unixTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long ts = date.getTime()/1000;
        res = String.valueOf(ts);
        return res;
    }
    //获取当前时间戳
    public static long getCurrentUtime(){
        return  System.currentTimeMillis()/1000;
    }
}
