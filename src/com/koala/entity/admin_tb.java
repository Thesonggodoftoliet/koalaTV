package com.koala.entity;

/**
  *描述每个房间的房管，user指房管，room指直播间
  *@author Marting.Lee
  *date 2019/12/26
  **/
public class admin_tb {
    private int userid;
    private int roomid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }
}
