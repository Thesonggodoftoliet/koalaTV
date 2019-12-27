package com.koala.dao.Implement;

import com.koala.dao.Fans_Dao;
import com.koala.entity.fans_;
import com.koala.utils.JdbcUtils;

import java.util.List;

/**
 * 对某个主播的粉丝进行管理.
 * @author Marting.Lee
 * 2019/12/27
 */
public class Fans_DaoImpl implements Fans_Dao {
    /**
      *获取某位主播的所有粉丝.
      * @param hostid int
      * @return java.util.List(com.koala.entity.fans_)
      **/
    @Override
    public List<fans_> getAllFan(int hostid) {
        String sql = "select * from fans_"+hostid;
        return JdbcUtils.getList(fans_.class,sql);
    }

    /**
      *添加粉丝.
      * @param fans com.koala.entity.fans_
      * @return com.koala.entity.fans_
      **/
    @Override
    public fans_ addFan(fans_ fans) {
        String sql = "insert into fans_"+fans.getHostid()+" values(?,?)";
        int tag = JdbcUtils.executeSQL(sql,fans.getUserid(),fans.getHostid());
        if (tag == 0)return null;
        else return fans;
    }

    /**
      *取消关注.
      * @param fans com.koala.entity.fans_
      * @return boolean
      **/
    @Override
    public boolean deleteFan(fans_ fans) {
        String sql = "delete from fans_"+fans.getHostid()+" where userid = ?";
        int tag = JdbcUtils.executeSQL(sql,fans.getUserid());
        if (tag == 0)return false;
        else return true;
    }

    /**
      *删除主播所有粉丝.
      * @param hostid int
      * @return boolean
      **/
    @Override
    public boolean deleteFans(int hostid) {
        String sql = "drop table fans_"+hostid;
        int tag = JdbcUtils.executeSQL(sql);
        if (tag == 0)return false;
        else return true;
    }
}
