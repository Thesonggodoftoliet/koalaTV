package com.koala.entity;
/*
 * @Author_Marting.Lee
 * @Date_2019/12/26
 * @Description_room_tb
 */

public class room_tb {
    private int roomid;//房间号
    private int userid;//主播号
    private String title;//直播标题
    private String category;//直播分类
    private String coverpic;//直播封面

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCoverpic() {
        return coverpic;
    }

    public void setCoverpic(String coverpic) {
        this.coverpic = coverpic;
    }
}