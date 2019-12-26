package com.koala.entity;
/*
 * @Author_Marting.Lee
 * @Date_2019/12/26
 * @Description_admin_tb  房管信息
 * UserId 指用户的id  roomID是指房间号
 * 一一对应
 */

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
