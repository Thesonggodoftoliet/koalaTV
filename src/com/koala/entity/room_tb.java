package com.koala.entity;
/*
 * @Author_Marting.Lee
 * @Date_2019/12/26
 * @Description_room_tb
 */
/**
  *一个直播间的信息.
  *@author Marting.Lee
  *date 2019/12/26
  **/
public class room_tb {
    private int roomid;//房间号
    private int hostid;//主播号
    private String title;//直播标题
    private String category;//直播分类
    private String coverpic;//直播封面

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public int getHostid() {
        return hostid;
    }

    public void setHostid(int hostid) {
        this.hostid = hostid;
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
