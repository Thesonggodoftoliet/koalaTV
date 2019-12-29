package com.koala.service.impl;

import com.koala.dao.Implement.UserDaoImpl;
import com.koala.dao.UserDao;
import com.koala.entity.user_tb;
import com.koala.service.UserManage;
import com.koala.utils.JwtUtils;

/**
 * 有关用户的服务.
 * @author Marting.Lee
 * 2019/12/28
 */
public class UserManageImpl implements UserManage {
    private UserDao userDao;

    public UserManageImpl() {
        this.userDao = new UserDaoImpl();
    }

    /**
      *通过电话获取用户.
      * @param phone String
      * @return com.koala.entity.user_tb
      **/
    @Override
    public user_tb getUser(String phone) {
        return userDao.getUserByPhone(phone);
    }

    /**
      *通过用户ID获取用户.
      * @param userid int
      * @return com.koala.entity.user_tb
      **/
    @Override
    public user_tb getUserById(int userid) {
        return userDao.getUserById(userid);
    }

    /**
      *登陆验证.
      * @param user
      * @return java.lang.String
      **/
    @Override
    public String authUser(user_tb user) {
        user_tb sqluser = userDao.getUserByPhone(user.getPhone());
        if (sqluser == null)
            return null;//无此用户
        if (sqluser.getUserpassword().equals(user.getUserpassword())){//匹配成功，创建Token
            String token = JwtUtils.createToken(sqluser.getUserid());
            return token;
        }
        return "wrong";//密码错误
    }

    /**
      *账号注册.
      * @param user com.koala.entity.user_tb
      * @return java.lang.String
      **/
    @Override
    public String addUser(user_tb user) {
        if (userDao.getUserByPhone(user.getPhone()) !=null)
            return null;//手机号已被注册
        else{
            if (user.getIcon() == null)
                user.setIcon("默认路径");//默认头像
            user_tb sqluser = userDao.getLastUser();
            if (sqluser == null)
                user.setUserid(1);
            else
                user.setUserid(sqluser.getUserid()+1);
            user.setIsAudience(1);
            user = userDao.addUser(user);
            if (user == null)
                return "wrong";
            else {
                String token = JwtUtils.createToken(user.getUserid());
                return token;
            }
        }
    }

    /**
      *修改个人信息头像、性别、昵称.
      * @param user com.koala.entity.user_tb
      * @return int
      **/
    @Override
    public int modifyUser(user_tb user) {
        user_tb sqluser = userDao.getUserById(user.getUserid());
        if (user.getIcon()!= null && !user.getIcon().equals(sqluser.getIcon()))
            sqluser.setIcon(user.getIcon());
        if (user.getGender()!=0 && user.getGender()!=sqluser.getGender())
            sqluser.setGender(user.getGender());
        if (user.getNickname()!=null && !user.getNickname().equals(sqluser.getNickname()))
            sqluser.setNickname(user.getNickname());
        if(userDao.updateUserById(sqluser))
            return 1;
        else
            return 0;
    }
}