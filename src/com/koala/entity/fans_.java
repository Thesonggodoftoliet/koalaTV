package com.koala.entity;
/*
 * @Author_Marting.Lee
 * @Date_2019/12/26
 * @Description_fans_+主播ID  表示该主播的粉丝
 */

/**
  *模型本身代表一个粉丝，fans_(hostid)代表这个主播的粉丝.
  *@author Marting.Lee
  *date 2019/12/26
  **/
public class fans_ {
    private int userid;
    private int hostid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getHostid() {
        return hostid;
    }

    public void setHostid(int hostid) {
        this.hostid = hostid;
    }
}
