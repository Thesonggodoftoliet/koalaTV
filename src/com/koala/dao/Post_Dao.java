package com.koala.dao;

import com.koala.entity.post_;

import java.util.List;

/**
 * 对回复进行增删查改.
 * @author Marting.Lee
 * 2019/12/27
 */
public interface Post_Dao {
    List<post_> getAllReply(int barid);
    post_ getReplyById(post_ post);
    post_ getLastReply(int barid);
    post_ addReply(post_ post);
    int numOfReply(int barid);
    boolean updateReply(post_ post);
    boolean deleteReply(post_ post);
    boolean deletePost(int barid);
}
