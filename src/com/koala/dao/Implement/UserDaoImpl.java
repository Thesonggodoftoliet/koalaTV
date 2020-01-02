package com.koala.dao.Implement;

import com.koala.dao.UserDao;
import com.koala.entity.user_tb;
import com.koala.utils.JdbcUtils;

import java.util.List;
/**
  *对用户的增删查改.
  *@author Marting.Lee
  *date 2019/12/27
  **/
public class UserDaoImpl implements UserDao {
    /**
      *获取某个账户信息.
      * @param userid int
      * @return com.koala.entity.user_tb
      **/
    @Override
    public user_tb getUserById(int userid) {
        String sql = "select * from user_tb where userid = ?";
        return (user_tb) JdbcUtils.getObjectById(user_tb.class,sql,userid);
    }

    /**
      *通过电话获取某个账户.
      * @param phone String
      * @return com.koala.entity.user_tb
      **/
    @Override
    public user_tb getUserByPhone(String phone) {
        String sql = "select * from user_tb where phone = ?";
        return (user_tb) JdbcUtils.getObjectById(user_tb.class,sql,phone);
    }

    /**
      *获取最后一个用户.
      * @return com.koala.entity.user_tb
      **/
    @Override
    public user_tb getLastUser() {
        String sql = "select * from user_tb order by userid desc limit 0,1";
        return (user_tb)JdbcUtils.getObject(user_tb.class,sql);
    }

    /**
      *添加用户.
      * @param user com.koala.entity.user_tb
      * @return com.koala.entity.user_tb
      **/
    @Override
    public user_tb addUser(user_tb user) {
        String sql = "insert into user_tb values(?,?,?,?,?,?,?,?,?,?,?,?)";
        int tag = JdbcUtils.executeSQL(sql,user.getUserid(),user.getPhone(),user.getUserpassword(),user.getIsAudience(),user.getIsYoutuber(),user.getIsAdmin(),user.getIsBarhost(),user.getIsForbidden(),user.getNickname(),user.getGender(),user.getIcon(),user.getFollow());
        if (tag == 0)return null;
        else
            return user;
    }

    /**
      *获取所有的用户.
      * @return java.util.List(com.koala.entity.user_tb)
      **/
    @Override
    public List<user_tb> getAllUser() {
        String sql = "select * from user_tb";
        return JdbcUtils.getList(user_tb.class,sql);
    }

    /**
      *获取所有的主播.
      * @return java.util.List(com.koala.entity.user_tb)
      **/
    @Override
    public List<user_tb> getAllHost() {
        String sql = "select * from user_tb where isYoutuber = 1";
        return JdbcUtils.getList(user_tb.class,sql);
    }

    /**
      *获取所有被封禁账号.
      * @return java.util.List(com.koala.entity.user_tb)
      **/
    @Override
    public List<user_tb> getAllForbidden() {
        String sql = "select * from user_tb where isForbidden = 1";
        return JdbcUtils.getList(user_tb.class,sql);
    }

    /**
      *获取用户总数.
      * @return int
      **/

    @Override
    public int getNumOfUser() {
        String sql = "select * from user_tb";
        return JdbcUtils.getListCount(sql);
    }

    /**
      *修改个人信息.
      * @param user com.koala.entity.user_tb
      * @return boolean
      **/
    @Override
    public boolean updateUserById(user_tb user) {
        String sql = "update user_tb set phone =?, userpassword = ?, isAudience = ?, isYoutuber = ?,isAdmin=?,isBarhost=?,isForbidden=?,nickname=?,gender=?,icon=?,follow=? where userid = ?";
        int tag = JdbcUtils.executeSQL(sql,user.getPhone(),user.getUserpassword(),user.getIsAudience(),user.getIsYoutuber(),user.getIsAdmin(),user.getIsBarhost(),user.getIsForbidden(),user.getNickname(),user.getGender(),user.getIcon(),user.getFollow(),user.getUserid());
        if (tag == 0)return false;
        else return true;
    }

    /**
      *删除用户.
      * @param id int
      * @return boolean
      **/
    @Override
    public boolean deleteUserById(int id) {
        String sql = "delete from user_tb where userid = ?";
        int tag = JdbcUtils.executeSQL(sql,id);
        if (tag == 0)return false;
        else return true;
    }
}
