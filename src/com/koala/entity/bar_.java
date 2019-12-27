package com.koala.entity;
/**
  *模型本身代表一个帖子，bar_(hostid)代表这个主播的话圈.
  *@author Marting.Lee
  *date 2019/12/26
  **/
public class bar_ {
    private int hostid;
    private int barid;
    private String title;
    private int barnum;
    private String lastreplytime;//最后回复时间
    private int userid;//发帖人
    private String posttime;//发帖时间
    private int lastreply;//最后回复人

    public int getBarid() {
        return barid;
    }

    public void setBarid(int barid) {
        this.barid = barid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBarnum() {
        return barnum;
    }

    public void setBarnum(int barnum) {
        this.barnum = barnum;
    }

    public String getLastreplytime() {
        return lastreplytime;
    }

    public void setLastreplytime(String lastreplytime) {
        this.lastreplytime = lastreplytime;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }

    public int getLastreply() {
        return lastreply;
    }

    public void setLastreply(int lastreply) {
        this.lastreply = lastreply;
    }
}
