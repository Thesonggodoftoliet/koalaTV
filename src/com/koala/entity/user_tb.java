package com.koala.entity;

/**
  *用户所有的信息.
  *@author Marting.Lee
  *date 2019/12/26
  **/
public class user_tb {
    private int userid;//用户ID自增
    private String phone;
    private String userpassword;
    private int isAudience; // 0 否  1 是 下同
    private int isYoutuber;
    private int isAdmin;
    private int isBarhost;
    private int isForbidden;
    private String nickname;
    private int gender;// 1 男  2 女
    private String icon;
    private String follow;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public int getIsAudience() {
        return isAudience;
    }

    public void setIsAudience(int isAudience) {
        this.isAudience = isAudience;
    }

    public int getIsYoutuber() {
        return isYoutuber;
    }

    public void setIsYoutuber(int isYoutuber) {
        this.isYoutuber = isYoutuber;
    }

    public int getIsBarhost() {
        return isBarhost;
    }

    public void setIsBarhost(int isBarhost) {
        this.isBarhost = isBarhost;
    }

    public int getIsForbidden() {
        return isForbidden;
    }

    public void setIsForbidden(int isForbidden) {
        this.isForbidden = isForbidden;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
