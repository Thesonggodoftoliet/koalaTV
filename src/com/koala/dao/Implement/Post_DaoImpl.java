package com.koala.dao.Implement;

import com.koala.dao.Post_Dao;
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
    public List<post_> getAllReply(int barid) {
        String sql = "select * from post_"+barid;
        return JdbcUtils.getList(post_.class,sql);
    }

    /**
      *获取某条回复.
      * @param post com.koala.entity.post_
      * @return com.koala.entity.post_
      **/
    @Override
    public post_ getReplyById(post_ post) {
        String sql = "select * from post_"+post.getBarid()+" where postid = ?";
        return (post_)JdbcUtils.getObjectById(post_.class,sql,post.getPostid());
    }

    /**
      *获取最后一个回复.
      * @param barid int
      * @return com.koala.entity.post_
      **/
    @Override
    public post_ getLastReply(int barid) {
        String sql = "select * from post_"+barid+" oder by postid desc limit 0,1";
        return (post_)JdbcUtils.getObject(post_.class,sql);
    }

    /**
      *添加回复.
      * @param post com.koala.entity.post_
      * @return com.koala.entity.post_
      **/
    @Override
    public post_ addReply(post_ post) {
        String sql = "insert into post_? values(?,?,?,?,?,?)";
        int tag = JdbcUtils.executeSQL(sql,post.getBarid(),post.getPostid(),post.getUserid(),post.getPosttime(),post.getContent(),post.getPic());
        if (tag == 0)return null;
        else return post;
    }

    /**
      *获取回复的总数.
      * @param barid int
      * @return int
      **/
    @Override
    public int numOfReply(int barid) {
        String sql = "select * from post_"+barid;
        return JdbcUtils.getListCount(sql);
    }

    /**
      *编辑回复.
      * @param post com.koala.entity.post_
      * @return boolean
      **/
    @Override
    public boolean updateReply(post_ post) {
        String sql = "update post_? set posttime=?,content=?,pic=? where postid=?";
        int tag = JdbcUtils.executeSQL(sql,post.getBarid(),post.getPosttime(),post.getContent(),post.getPic(),post.getPostid());
        if (tag == 0)return false;
        else return true;
    }

    /**
      *删除某条回复.
      * @param post com.koala.entity.post_
      * @return boolean
      **/
    @Override
    public boolean deleteReply(post_ post) {
        String sql = "delete from post_? where postid = ?";
        int tag = JdbcUtils.executeSQL(sql,post.getBarid(),post.getPostid());
        if (tag == 0)return false;
        else return true;
    }

    /**
      *删除整个帖子.
      * @param barid int
      * @return boolean
      **/
    @Override
    public boolean deletePost(int barid) {
        String sql = "drop table post_"+barid;
        int tag = JdbcUtils.executeSQL(sql);
        if (tag == 0)return false;
        else return true;
    }
}
