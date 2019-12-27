package com.koala.dao.Implement;

import com.koala.dao.Bar_Dao;
import com.koala.entity.bar_;
import com.koala.utils.JdbcUtils;

import java.util.List;

/**
 *对帖子进行增删查改.
 *@author Marting.Lee
 *date 2019/12/27
 **/
public class Bar_DaoImpl implements Bar_Dao {
    /**
      *获取这个host的所有帖子.
      * @param hostid int
      * @return java.util.List(com.koala.entity.bar_)
      **/
    @Override
    public List<bar_> getAllPost(int hostid) {
        String sql = "select * from bar_"+hostid;
        return JdbcUtils.getList(bar_.class,sql);
    }

    /**
      *获取单个帖子.
      * @param bar com.koala.entity.bar_
      * @return com.koala.entity.bar_
      **/
    @Override
    public bar_ getPostById(bar_ bar) {
        String sql = "select * from bar_"+bar.getHostid()+" where barid = ?";
        return (bar_)JdbcUtils.getObjectById(bar_.class,sql,bar.getBarid());
    }

    /**
      *发表一个新帖子.
      * @param bar com.koala.entity.bar_
      * @return com.koala.entity.bar_
      **/
    @Override
    public bar_ addPost(bar_ bar) {
        String sql = "insert into bar_"+bar.getHostid()+" values(?,?,?,?,?,?,?,?)";
        int tag = JdbcUtils.executeSQL(sql,bar.getHostid(),bar.getBarid(),bar.getTitle(),bar.getReplynum(),bar.getLastreplytime(),bar.getUserid(),bar.getPosttime(),bar.getLastreply());
        if (tag ==0)return null;
        else return bar;
    }

    /**
      *获取帖子总数.
      * @param hostid int
      * @return int
      **/
    @Override
    public int getNumOfPost(int hostid) {
        String sql = "select * from bar_"+hostid;
        return JdbcUtils.getListCount(sql);
    }

    /**
      *修改帖子.
      * @param bar com.koala.entity.bar_
      * @return boolean
      **/
    @Override
    public boolean updatePost(bar_ bar) {
        String sql = "update bar_"+bar.getHostid()+" set title=?,replynum = ?,lastreplytime=?,lastreply=? where barid=?";
        int tag = JdbcUtils.executeSQL(sql,bar.getTitle(),bar.getReplynum(),bar.getLastreplytime(),bar.getLastreply(),bar.getBarid());
        if (tag == 0)return false;
        else return true;
    }

    /**
      *删除某个帖子.
      * @param bar com.koala.entity.bar_
      * @return boolean
      **/
    @Override
    public boolean deletePost(bar_ bar) {
        String sql = "delete from bar_"+bar.getHostid()+" where barid = ?";
        int tag  = JdbcUtils.executeSQL(sql,bar.getBarid());
        return false;
    }

    /**
      *删除整个话圈.
      * @param hostid int
      * @return boolean
      **/
    @Override
    public boolean deleteBar(int hostid) {
        String sql = "drop table bar_?";
        int tag = JdbcUtils.executeSQL(sql,hostid);
        if (tag == 0)return false;
        else return true;
    }
}
