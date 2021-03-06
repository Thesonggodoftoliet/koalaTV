package com.koala.entity;
/**
  *模型本身代表一个帖子，bar_(hostid)代表这个主播的话圈.
  *@author Marting.Lee
  *date 2019/12/26
  **/
public class bar_ {
    private int hostid;//属于哪个主播
    private int barid;//该贴的ID
    private String title;
    private int replynum;
    private String lastreplytime;//最后回复时间
    private int userid;//发帖人
    private String posttime;//发帖时间
    private String content;
    private String pic;

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

    public int getReplynum() {
        return replynum;
    }

    public void setReplynum(int replynum) {
        this.replynum = replynum;
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

    public int getHostid() {
        return hostid;
    }

    public void setHostid(int hostid) {
        this.hostid = hostid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
