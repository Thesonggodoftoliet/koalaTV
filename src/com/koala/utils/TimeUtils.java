package com.koala.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于生成时间.
 * @author Marting.Lee
 * 2019/12/29
 */
public class TimeUtils {

    /**
      *生成时间串.
      * @return java.lang.String
      **/
    public static String dateToStr(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(date);
        return dateString;
    }


    /**
      *生成几分钟前的时间串.
      * @param minute int
      * @return java.lang.String
      **/
    public static String dateToStr(int minute){
        Date date = new Date();
        Date old = new Date(date.getTime()-minute*60*1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(old);
    }

    /**
      *生成UTC标准时间.
      * @param day int
      * @return java.lang.String
      **/
    public static String dateToStrD(int day){
        Date date = new Date();
        Date resume = new Date(date.getTime()+day*24*60*60*1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return simpleDateFormat.format(resume);
    }
}
