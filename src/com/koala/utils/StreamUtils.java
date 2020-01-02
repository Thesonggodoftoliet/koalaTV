package com.koala.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: koalaTV
 * @description: 推流的RTMP和密匙的生成工具类
 * @author: liu yan
 * @create: 2020-01-02 10:47
 */
public class StreamUtils {
    private String streamid;
    private String txTime;
    private int liveHomeNumber;
    private String txSecret;
    private String bizid;
    public StreamUtils(){
        super();
    }
    public StreamUtils(int userid){
        this.liveHomeNumber = userid;

        Date curTime = new Date();
        //2.获取当前的时间
        Calendar nextTime = Calendar.getInstance();
        nextTime.setTime(curTime);   // date to calendar
        nextTime.add(Calendar.DAY_OF_MONTH,1); // +24hours
        curTime = nextTime.getTime(); // calender to date
        DateFormat nextTime2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String txDate_1 = nextTime2.format(curTime); // date to string
        //3.时间转换成秒
        Long unixTime = 0L;
        try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            unixTime = df.parse(txDate_1).getTime()/1000;
        } catch (ParseException e){
            System.out.println("pe");
        }
        //4.16位编码时间
        this.txTime = Integer.toHexString(unixTime.intValue()).toUpperCase();


        /* streamid*/

        this.bizid = "33772";
        streamid = ""+this.liveHomeNumber;

        /* txSecret 10.27*/
        String key = "13179ca020260c31035b5db823000740"; //
        this.txSecret = MD5(key+streamid+txTime);

    }

    protected static String MD5(String str) {

        MessageDigest md5 = null;
        try {

            md5 = MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] bs = md5.digest(str.getBytes());
        StringBuilder sb = new StringBuilder(40);
        for(byte x:bs) {
            if((x & 0xff)>>4 == 0) {
                sb.append("0").append(Integer.toHexString(x & 0xff));
            } else {
                sb.append(Integer.toHexString(x & 0xff));
            }
        }
        return sb.toString();
    }


    public String getSecretKey() {
        String SECRETKEY = this.streamid+"?bizid="+bizid+"&txSecret="+txSecret+"&txTime="+txTime;
        return SECRETKEY;
    }

    public String getStreamId() {
        return this.streamid;
    }

    public String getRtmp() {
        String PLAYURLR = "rtmp://"+this.bizid+".livepush.myqcloud.com/live/";
        return PLAYURLR;
    }


}
