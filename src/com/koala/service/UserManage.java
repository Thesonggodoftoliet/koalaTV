package com.koala.service;

import com.koala.entity.*;

import java.util.List;

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
    int applyForBar(user_tb user, bar_tb bar, room_tb room);
    int followYoutuber(user_tb user);
    int checkIdentity(programmer_tb programmerTb);

    boolean concelFollow(int userid,int follow);
}
