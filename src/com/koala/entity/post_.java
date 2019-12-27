package com.koala.entity;

/**
  *模型本身代表一条回复，post_(barid)代表这个帖子.
  *@author Marting.Lee
  *date 2019/12/26
  **/
public class post_ {
    private int barid;//属于哪个帖子
    private int postid;//该回复的ID
    private int userid;
    private String posttime;
    private String content;
    private String pic;

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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
