package com.koala.entity;

import java.util.Objects;

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
    private int isLive;
    private int isForbidden;
    private long forbidend;

    public int getIsLive() {
        return isLive;
    }

    public void setIsLive(int isLive) {
        this.isLive = isLive;
    }

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

    public int getIsForbidden() {
        return isForbidden;
    }

    public void setIsForbidden(int isForbidden) {
        this.isForbidden = isForbidden;
    }

    public long getForbidend() {
        return forbidend;
    }

    public void setForbidend(long forbidend) {
        this.forbidend = forbidend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        room_tb roomTb = (room_tb) o;
        return roomid == roomTb.roomid &&
                hostid == roomTb.hostid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomid, hostid);
    }
}
