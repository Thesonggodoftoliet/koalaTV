package com.koala.service.impl;

import com.koala.dao.Fans_Dao;
import com.koala.dao.Implement.Fans_DaoImpl;
import com.koala.dao.Implement.UserDaoImpl;
import com.koala.dao.UserDao;
import com.koala.entity.*;
import com.koala.service.UserManage;
import com.koala.utils.JwtUtils;
import com.koala.utils.PraseUtils;

import java.util.List;

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
      * @param user com.koala.entity.user_tb
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
            if (user.getIcon().isEmpty())
                user.setIcon("默认头像.jpg");//默认头像
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
        if (user.getIcon()!=null&&!user.getIcon().isEmpty() && !user.getIcon().equals(sqluser.getIcon()))
            sqluser.setIcon(user.getIcon());
        if (user.getGender()!=0 && user.getGender()!=sqluser.getGender())
            sqluser.setGender(user.getGender());
        if (user.getNickname()!=null&&!user.getNickname().isEmpty()&& !user.getNickname().equals(sqluser.getNickname()))
            sqluser.setNickname(user.getNickname());
        if(userDao.updateUserById(sqluser))
            return 1;
        else
            return 0;
    }

    /**
      *修改需要手机验证的信息.
      * @param user com.koala.entity.user_tb
     * @param choice int
      * @return int
      **/
    @Override
    public int modifyKeyInfo(user_tb user, int choice) {
        user_tb sqluser;
        if (choice == 1) {
            sqluser = userDao.getUserById(user.getUserid());
            sqluser.setPhone(user.getPhone());
            if (userDao.updateUserById(sqluser))
                return 1;
            else return 0;
        }
        else {
            sqluser = userDao.getUserByPhone(user.getPhone());
            sqluser.setUserpassword(user.getUserpassword());
            if (userDao.updateUserById(sqluser))
                return 1;
            else
                return 0;
        }
    }

    /**
      *申请成为主播.
      * @param user com.koala.entity.user_tb
      * @return int
      **/
    @Override
    public int applyForBar(user_tb user, bar_tb bar, room_tb room) {
        room.setRoomid(user.getUserid());
        bar.setAdminid(user.getUserid());
        user_tb sqluser = userDao.getUserById(user.getUserid());
        if (room.getCoverpic().isEmpty())
            room.setCoverpic("默认封面.jpg");
        if (sqluser.getIsYoutuber() == 1)
            return -1;
        else {
            user.setIsBarhost(1);
            user.setIsYoutuber(1);

            if (userDao.applyYoutuber(user, bar, room))
                return 1;
            else
                return 0;
        }
    }

    /**
      *关注主播.
      * @param user com.koala.entity.user_tb
      * @return int
      **/
    @Override
    public int followYoutuber(user_tb user) {
        user_tb sqluser = userDao.getUserById(user.getUserid());
      //  Fans_Dao fans_dao = new Fans_DaoImpl();
        List<Integer> id = PraseUtils.sToi(sqluser.getFollow());

        if (id !=null && id.contains(Integer.parseInt(user.getFollow())))//已经关注了这个主播
            return -1;

        //注入粉丝表
        fans_ fans = new fans_();
        fans.setHostid(Integer.parseInt(user.getFollow()));
        fans.setUserid(user.getUserid());

        //修改个人的表
        String follow = sqluser.getFollow();
        String str = user.getFollow();
        sqluser.setFollow(PraseUtils.addStr(follow,str));

        if (userDao.followYoutuber(sqluser,fans))
            return 1;
        else
            return 0;
    }

    /**
      *验证管理员账户.
      * @param programmerTb  com.koala.entity.programmer_tb
      * @return int
      **/
    @Override
    public int checkIdentity(programmer_tb programmerTb) {
        programmer_tb sql = userDao.getProgrammer(programmerTb);
        if (sql.getUserpassword().equals(programmerTb.getUserpassword()))
            return 1;
        return 0;
    }


    /**
      *取消关注.
      * @param userid int
     * @param follow int
      * @return boolean
      **/
    @Override
    public boolean concelFollow(int userid, int follow) {
        user_tb sqluser = userDao.getUserById(userid);
        String f = sqluser.getFollow();
        int tag = f.indexOf(""+follow);
        Fans_Dao fans_dao = new Fans_DaoImpl();

        //从个人信息表删除
        if (tag == 0)
            f=f.substring(2);
        else if (tag == f.length()-2)
            f=f.substring(0,f.length()-2);
        else {
            String begin = f.substring(0,tag);
            String end = f.substring(tag+2);
            f= begin+end;
        }
        if (f.isEmpty())
            f = ",";
        sqluser.setFollow(f);

        //从粉丝表删除
        fans_ fans = new fans_();
        fans.setUserid(sqluser.getUserid());
        fans.setHostid(follow);

        return userDao.concelFollow(sqluser,fans);
    }
}
