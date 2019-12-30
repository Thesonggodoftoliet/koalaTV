package com.koala.service;

import com.koala.entity.user_tb;

/**
 * 有关用户的服务.
 * @author Marting.Lee
 * 2019/12/28
 */
public interface UserManage {
    user_tb getUser(String phone);
    user_tb getUserById(int userid);
    String authUser(user_tb user);
    String addUser(user_tb user);
    int modifyUser(user_tb user);
    int modifyKeyInfo(user_tb user,int choice);//1 是修改手机号 2是修改密码
    int applyForBar(user_tb user);
    int followYoutuber(user_tb user);
}
