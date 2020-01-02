package com.koala.dao.Implement;

import com.koala.dao.R_Dao;
import com.koala.entity.r_;
import com.koala.utils.JdbcUtils;

import java.util.List;

/**
 * 对房间封禁信息管理.
 * @author Marting.Lee
 * 2019/12/27
 */
public class R_DaoImpl implements R_Dao {
    /**
      *获取某个房间的封禁信息.
      * @param roomid int
      * @return java.util.List(com.koala.entity.r_)
      **/
    @Override
    public List<r_> getAll(int roomid) {
        String sql = "select * from r_"+roomid;
        return JdbcUtils.getList(r_.class,sql);
    }

    /**
      *添加封禁信息.
      * @param r com.koala.entity.r_
      * @return com.koala.entity.r_
      **/
    @Override
    public r_ addR(r_ r) {
        String sql = "insert into r_? values(?,?,?)";
        int tag = JdbcUtils.executeSQL(sql,r.getUserid(),r.getRoomid(),r.getLimits());
        if (tag == 0)return null;
        else return r;
    }

    /**
      *创建某个主播的房间封禁信息.
      * @param roomid int
      * @return boolean
      **/
    @Override
    public boolean createR(int roomid) {
        String sql = "create table if not exists r_"+roomid+
                "（userid int unsigned," +
                "  roomid int unsigned," +
                "  limits int unsigned,#(0封号 1禁言 2普通 3管理 4房主)" +
                "  primary key(userid)" +
                " )ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        JdbcUtils.executeSQL(sql);
        return true;
    }

    /**
      *更新封禁信息.
      * @param r com.koala.entity.r_
      * @return boolean
      **/
    @Override
    public boolean updateR(r_ r) {
        String sql = "update r_? set limits = ? where userid=?";
        int tag  = JdbcUtils.executeSQL(sql,r.getRoomid(),r.getLimits(),r.getUserid());
        if (tag == 0)return false;
        else return true;
    }

    /**
      *删除某个房间某个人的信息.
      * @param r com.koala.entity.r_
      * @return boolean
      **/
    @Override
    public boolean deleteR(r_ r) {
        String sql = "delete from r_? where userid = ?";
        int tag = JdbcUtils.executeSQL(sql,r.getRoomid(),r.getUserid());
        if (tag == 0)return false;
        else return true;
    }

    /**
      *删除整个房间的用户信息.
      * @param roomid int
      * @return boolean
      **/
    @Override
    public boolean deleteR(int roomid) {
        String sql = "drop table r_?";
        int tag = JdbcUtils.executeSQL(sql,roomid);
        if (tag == 0)return false;
        else return true;
    }
}
