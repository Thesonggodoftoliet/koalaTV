package com.koala.dao.Implement;

import com.koala.dao.UserDao;
import com.koala.entity.*;
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
        String sql = "select * from user_tb where phone = '"+phone+"'";
        return (user_tb) JdbcUtils.getObject(user_tb.class,sql);
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
        String sql = "insert into user_tb values(?,'"+user.getPhone()+"','"+user.getUserpassword()+"',"+user.getIsAudience()+","+user.getIsYoutuber()+","+user.getIsAdmin()+","+user.getIsBarhost()+","+user.getIsForbidden()+",'"+user.getNickname()+"',"+user.getGender()+",'"+user.getIcon()+"','"+user.getFollow()+"')";
        System.out.println("addUser "+sql);
        int tag = JdbcUtils.executeSQL(sql,user.getUserid());
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
        String sql = "update user_tb set phone ='"+user.getPhone()+"', userpassword = '"+user.getUserpassword()+"', isAudience = ?, isYoutuber = ?,isAdmin=?,isBarhost=?,isForbidden=?,nickname='"+user.getNickname()+"',gender=?,icon='"+user.getIcon()+"',follow='"+user.getFollow()+"' where userid = ?";
        int tag = JdbcUtils.executeSQL(sql,user.getIsAudience(),user.getIsYoutuber(),user.getIsAdmin(),user.getIsBarhost(),user.getIsForbidden(),user.getGender(),user.getUserid());
        if (tag == 0)return false;
        else return true;
    }

    /**
      *申请成为主播.
      * @param user com.koala.entity.user_tb
      * @return boolean
      **/
    @Override
    public boolean applyYoutuber(user_tb user, bar_tb bar, room_tb room) {
        String sql1 = "update user_tb set isYoutuber="+user.getIsYoutuber()+",isBarhost="+user.getIsBarhost()+" where userid="+user.getUserid();
        String sql2 = "create table if not exists fans_"+user.getUserid()+
                "(userid int unsigned," +
                "hostid int unsigned," +
                "primary key(userid)" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        String sql3 = "insert into bar_tb values("+bar.getHostid()+","+bar.getAdminid()+",'"+bar.getBarname()+"','"+bar.getCoverpic()+"');";
        String sql4 ="create table bar_"+bar.getHostid()+"(hostid int unsigned,"+
                "barid int unsigned," +
                "title varchar(20)," +
                "replynum int," +
                "lastreplytime varchar(60)," +
                "userid int unsigned," +
                "posttime varchar(60)," +
                "content varchar(255)," +
                "pic varchar(255)," +
                "primary key(barid)" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        String sql5 = "insert into room_tb values("+room.getRoomid()+","+ room.getHostid()+",'"+ room.getTitle()+"','"+ room.getCategory()+"','"+ room.getCoverpic()+"',"+room.getIsLive()+","+room.getIsForbidden()+","+room.getForbidend()+",'')";
        return JdbcUtils.executeTran(sql1,sql2,sql3,sql4,sql5);
    }

    /**
      *关注主播不迷路.
      * @param user com.koala.entity.user_tb
     * @param fans com.koala.entity.fans_
      * @return boolean
      **/
    @Override
    public boolean followYoutuber(user_tb user, fans_ fans) {
        String sql1 = "update user_tb set follow = '"+user.getFollow()+"' where userid="+user.getUserid();
        String sql2 = "insert into fans_"+fans.getHostid()+" values("+fans.getUserid()+","+fans.getHostid()+")";
        return JdbcUtils.executeTran(sql1,sql2);
    }

    /**
      *取消关注.
      * @param user com.koala.entity.user_tb
     * @param fans com.koala.entity.fans_
      * @return boolean
      **/
    @Override
    public boolean concelFollow(user_tb user, fans_ fans) {
        String sql1 = "update user_tb set follow = '"+user.getFollow()+"' where userid="+user.getUserid();
        String sql2 = "delete from fans_"+fans.getHostid()+" where userid ="+fans.getUserid();
        return JdbcUtils.executeTran(sql1,sql2);
    }

    /**
      *获取管理员账户信息.
      * @param programmerTb com.koala.entity.programmer_tb
      * @return com.koala.entity.programmer_tb
      **/
    @Override
    public programmer_tb getProgrammer(programmer_tb programmerTb) {
        String sql = "select * from programmer_tb where useraccount ="+programmerTb.getUseraccount();
        return (programmer_tb) JdbcUtils.getObject(programmer_tb.class,sql);
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
