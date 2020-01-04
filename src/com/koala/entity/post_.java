package com.koala.entity;

/**
  *模型本身代表一条回复，post_(hostid barid)代表这个帖子.
  *@author Marting.Lee
  *date 2019/12/26
  **/
public class post_ {
    private int hostid;//属于哪个话圈
    private int barid;//属于哪个帖子
    private int postid;//该回复的ID
    private int userid;
    private String posttime;
    private String content;

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBarid() {
        return barid;
    }

    public void setBarid(int barid) {
        this.barid = barid;
    }

    public int getHostid() {
        return hostid;
    }

    public void setHostid(int hostid) {
        this.hostid = hostid;
    }
}
