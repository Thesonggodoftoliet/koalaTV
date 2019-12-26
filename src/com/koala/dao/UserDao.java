package com.koala.dao;
/*
 * @Author_Marting.Lee
 * @Date_2019/12/26
 * @Description_UserDao
 * 可以对用户进行增删查改
 */

import com.koala.entity.user_tb;

import java.util.List;

public interface UserDao {
    user_tb getUserById(int userid);

    user_tb getUserByPhone(String phone);

    user_tb addUser(user_tb user);

    List<user_tb> getAllUser();

    int getNumOfUser();

    boolean updateUserById(user_tb user);

    boolean deleteUserById(int id);
}
