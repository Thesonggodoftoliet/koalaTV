package com.koala.dao.Implement;
/*
 * @Author_Marting.Lee
 * @Date_2019/12/26
 * @Description_UserDaoImpl
 */

import com.koala.dao.UserDao;
import com.koala.entity.user_tb;
import com.koala.utils.JdbcUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public user_tb getUserById(int userid) {
        String sql = "select * from user_tb where userid = ?";
        return (user_tb) JdbcUtils.getObjectById(user_tb.class,sql,userid);
    }

    @Override
    public user_tb getUserByPhone(String phone) {
        String sql = "select * from user_tb where phone = ?";
        return (user_tb) JdbcUtils.getObjectById(user_tb.class,sql,phone);
    }

    @Override
    public user_tb addUser(user_tb user) {
        String sql = "insert into user_tb values(?,?,?,?,?,?,?,?,?,?,?,?)";
        int tag = JdbcUtils.executeSQL(sql,user.getUserid(),user.getPhone(),user.getUserpasswrod(),user.getIsAudience(),user.getIsYoutuber(),user.getIsAdmin(),user.getIsBarhost(),user.getIsForbidden(),user.getNickname(),user.getGender(),user.getIcon(),user.getFollow());
        if (tag == 0)return null;
        else
            return user;
    }

    @Override
    public List<user_tb> getAllUser() {
        String sql = "select * from user_tb";
        return JdbcUtils.getList(user_tb.class,sql);
    }

    @Override
    public int getNumOfUser() {
        String sql = "select * from user_tb";
        return JdbcUtils.getListCount(sql);
    }

    @Override
    public boolean updateUserById(user_tb user) {
        String sql = "update user_tb set phone =?, userpassword = ?, isAudience = ?, isYoutuber = ?,isAdmin=?,isBarhost=?,isForbidden=?,nickname=?,gender=?,icon=?,follow=?";
        int tag = JdbcUtils.executeSQL(sql,user.getPhone(),user.getUserpasswrod(),user.getIsAudience(),user.getIsYoutuber(),user.getIsAdmin(),user.getIsBarhost(),user.getIsForbidden(),user.getNickname(),user.getGender(),user.getIcon(),user.getFollow());
        if (tag == 0)return false;
        else return true;
    }

    @Override
    public boolean deleteUserById(int id) {
        String sql = "delete from user_tb where userid = ?";
        int tag = JdbcUtils.executeSQL(sql,id);
        if (tag == 0)return false;
        else return true;
    }
}
