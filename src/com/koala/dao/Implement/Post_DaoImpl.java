package com.koala.dao.Implement;

import com.koala.dao.Post_Dao;
import com.koala.entity.bar_;
import com.koala.entity.post_;
import com.koala.utils.JdbcUtils;

import java.util.List;

/**
 * 对某个帖子的增删查改.
 * @author Marting.Lee
 * 2019/12/27
 */
public class Post_DaoImpl implements Post_Dao {
    /**
      *获取某个帖子的所有回复.
      * @param barid int
      * @return java.util.List(com.koala.entity.post_)
      **/
    @Override
    public List<post_> getAllReply(int hostid,int barid) {
        String sql = "select * from post_"+hostid+barid+" order by posttime desc";
        return JdbcUtils.getList(post_.class,sql);
    }

    /**
      *获取某条回复.
      * @param post com.koala.entity.post_
      * @return com.koala.entity.post_
      **/
    @Override
    public post_ getReplyById(post_ post) {
        String sql = "select * from post_"+post.getHostid()+post.getBarid()+" where postid = ?";
        return (post_)JdbcUtils.getObjectById(post_.class,sql,post.getPostid());
    }

    /**
      *获取最后一个回复.
      * @param barid int
      * @return com.koala.entity.post_
      **/
    @Override
    public post_ getLastReply(int hostid,int barid) {
        String sql = "select * from post_"+hostid+barid+" order by postid desc limit 0,1";
        return (post_)JdbcUtils.getObject(post_.class,sql);
    }

    /**
      *添加回复.
      * @param post com.koala.entity.post_
      * @return com.koala.entity.post_
      **/
    @Override
    public post_ addReply(post_ post,int num) {
        String sql = "insert into post_"+post.getHostid()+post.getBarid()+" values("+post.getHostid()+","+post.getBarid()+","+post.getPostid()+","+post.getUserid()+",'"+post.getPosttime()+"','"+post.getContent()+"')";
        String sql1 = "update bar_"+post.getHostid()+" set lastreplytime='"+post.getPosttime()+"',replynum="+num+" where barid="+post.getBarid();
        if (JdbcUtils.executeTran(sql,sql1))
            return post;
        else
            return null;
    }

    /**
      *获取发帖数.
      * @param hostid int
      * @return int
      **/
    @Override
    public int numOfPost(int hostid) {
        String sql = "select * from post_"+hostid;
        return JdbcUtils.getListCount(sql);
    }

    /**
      *获取回复的总数.
      * @param barid int
      * @return int
      **/
    @Override
    public int numOfReply(int hostid,int barid) {
        String sql = "select * from post_"+hostid+barid;
        return JdbcUtils.getListCount(sql);
    }

    /**
      *添加回复表.
      * @param barid int
      * @return boolean 
      **/
    @Override
    public boolean createTable(int barid,int hostid) {
        String sql = "create table if not exists post_" + hostid + barid +
                "(hostid int unsigned,"+
                "barid int unsigned," +
                "postid int unsigned," +
                "userid int unsigned," +
                "posttime varchar(60)," +
                "content varchar(255)," +
                "pic varchar(255)," +
                "primary key(postid)" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        JdbcUtils.executeSQL(sql);
        return true;
    }

    /**
      *编辑回复.
      * @param post com.koala.entity.post_
      * @return boolean
      **/
    @Override
    public boolean updateReply(post_ post) {
        String sql = "update post_"+post.getHostid()+post.getBarid()+ " set posttime='"+post.getPosttime()+"','"+post.getContent()+"' where postid="+post.getPostid();
        String sql1 = "update bar_"+post.getHostid()+" set lastreplytime='"+post.getPosttime()+"' where barid="+post.getBarid();

        if (JdbcUtils.executeTran(sql,sql1))
            return true;
        else
            return false;
    }

    /**
      *删除某条回复.
      * @param post com.koala.entity.post_
      * @return boolean
      **/
    @Override
    public boolean deleteReply(post_ post) {
        String sql = "delete from post_"+post.getHostid()+post.getBarid()+" where postid = ?";
        int tag = JdbcUtils.executeSQL(sql,post.getPostid());
        if (tag == 0)return false;
        else return true;
    }

    /**
      *删除整个帖子.
      * @param bar com.koala.entity.bar_
      * @return boolean
      **/
    @Override
    public boolean deletePost(bar_ bar) {
        String sql = "drop table post_"+bar.getHostid()+bar.getBarid();
        String sql1 = "delete from bar_"+bar.getHostid()+" where barid="+bar.getBarid();
        return JdbcUtils.executeTran(sql,sql1);
    }
}
