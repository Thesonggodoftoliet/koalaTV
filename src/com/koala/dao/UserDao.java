package com.koala.dao;

import com.koala.entity.bar_tb;
import com.koala.entity.fans_;
import com.koala.entity.room_tb;
import com.koala.entity.user_tb;

import java.util.List;

/**
  *对用户的增删查改.
  *@author Marting.Lee
  *date 2019/12/27
  **/
public interface UserDao {
    user_tb getUserById(int userid);
    user_tb getUserByPhone(String phone);
    user_tb getLastUser();
    user_tb addUser(user_tb user);
    List<user_tb> getAllUser();
    List<user_tb> getAllHost();
    List<user_tb> getAllForbidden();
    int getNumOfUser();
    boolean updateUserById(user_tb user);
    boolean applyYoutuber(user_tb user, bar_tb bar, room_tb room);
    boolean followYoutuber(user_tb user, fans_ fans);
    boolean concelFollow(user_tb user, fans_ fans);
    boolean deleteUserById(int id);
}
