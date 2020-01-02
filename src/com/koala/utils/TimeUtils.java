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
}
