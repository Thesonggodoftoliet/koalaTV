package com.koala.entity;

/**
  *模型本身代表一个用户的权限，r_(roomid)代表这个直播间的封禁信息.
  *@author Marting.Lee
  *date 2019/12/26
  **/
public class r_ {
    private int userid;
    private int roomid;
    private int limits;// 1 封号 2 禁言  3 普通人4 房管 5 房主

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getLimits() {
        return limits;
    }

    public void setLimits(int limits) {
        this.limits = limits;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }
}
