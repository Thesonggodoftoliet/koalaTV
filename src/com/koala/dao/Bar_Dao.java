package com.koala.dao;

import com.koala.entity.bar_;

import java.util.List;

/**
  *对帖子进行增删查改.
  *@author Marting.Lee
  *date 2019/12/27
  **/
public interface Bar_Dao {
    List<bar_> getAllPost(int hostid);
    bar_ getPostById(bar_ bar);
    bar_ getLastPost(int hostid);
    bar_ addPost(bar_ bar);
    int getNumOfPost(int hostid);
    boolean updatePost(bar_ bar);
    boolean deletePost(bar_  bar);
    boolean deleteBar(int hostid);
}
