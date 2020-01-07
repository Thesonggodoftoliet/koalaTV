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
        String sql = "select * from bar_"+hostid+" order by lastreplytime desc";
        return JdbcUtils.getList(bar_.class,sql);
    }

    /**
      *根据时间降序获取帖子.
      * @param hostid int
      * @return java.util.List(com.koala.entity.bar_)
      **/
    @Override
    public List<bar_> getLatestPosts(int hostid,int index) {
        String sql = "select * from bar_"+hostid+" order by lastreplytime desc limit 0,"+index;
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
      *获取一个最新的帖子.
      * @param hostid int
      * @return com.koala.entity.bar_
      **/
    @Override
    public bar_ getLatestPost(int hostid,int index) {
        String sql = "select * from bar_"+hostid+" order by lastreplytime desc,barid desc limit "+index+","+1;
        System.out.println("sql "+sql);
        return (bar_)JdbcUtils.getObject(bar_.class,sql);
    }

    /**
      *获取最后一个帖子.
      * @param hostid int
      * @return com.koala.entity.bar_ 
      **/
    @Override
    public bar_ getLastPost(int hostid) {
        String sql = "select * from bar_"+hostid+" order by barid desc limit 0,1";
        return (bar_)JdbcUtils.getObject(bar_.class,sql);
    }

    /**
      *发表一个新帖子.
      * @param bar com.koala.entity.bar_
      * @return com.koala.entity.bar_
      **/
    @Override
    public bar_ addPost(bar_ bar) {
        String sql = "insert into bar_"+bar.getHostid()+" values("+bar.getHostid()+","+bar.getBarid()+",'"+bar.getTitle()+"',"+bar.getReplynum()+",'"+bar.getLastreplytime()+"',"+bar.getUserid()+",'"+bar.getPosttime()+"','"+bar.getContent()+"','"+bar.getPic()+"')";
        System.out.println(sql);
        String sql1 = "create table if not exists post_" + bar.getHostid() + bar.getBarid() +
                "(hostid int unsigned,"+
                "barid int unsigned," +
                "postid int unsigned," +
                "userid int unsigned," +
                "posttime varchar(60)," +
                "content varchar(255)," +
                "primary key(postid)" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        if (JdbcUtils.executeTran(sql,sql1))return bar;
        else
            return null;
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
      *创建一个新的微博表.
      * @param hostid int
      * @return boolean
      **/
    /*@Override
    public boolean createTable(int hostid) {
        String sql = "create table bar_"+hostid+"(hostid int unsigned,"+
                "barid int unsigned," +
                "title varchar(20)," +
                "replynum int," +
                "lastreplytime varchar(60)," +
                "userid int unsigned," +
                "posttime varchar(60)," +
                "content varchar(255)," +
                "pic varchar(255)," +
                "primary key(barid)" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        JdbcUtils.executeSQL(sql);

        return true;
    }*/

    /**
      *修改帖子.
      * @param bar com.koala.entity.bar_
      * @return boolean
      **/

    @Override
    public boolean updatePost(bar_ bar) {
        String sql = "update bar_"+bar.getHostid()+" set title='"+bar.getTitle()+"',replynum = ?,lastreplytime='"+bar.getLastreplytime()+"',content='"+bar.getContent()+"',pic='"+bar.getPic()+"' where barid=?";
        int tag = JdbcUtils.executeSQL(sql,bar.getReplynum(),bar.getBarid());
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
