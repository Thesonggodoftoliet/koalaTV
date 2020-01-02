package com.koala.dao.Implement;

import com.koala.dao.BarDao;
import com.koala.entity.bar_tb;
import com.koala.utils.JdbcUtils;
import java.util.List;

/**
 *对话圈信息进行增删查改.
 *@author Marting.Lee
 *date 2019/12/27
 **/
public class BarDaoImpl implements BarDao {
	/**
	  *获取单个话圈.
	  * @param hostid int
	  * @return com.koala.entity.bar_tb
	  **/
	@Override
	public bar_tb getBarByHostId(int hostid) {
		String sql = "select * from bar_tb where hostid = ?";
		return (bar_tb)JdbcUtils.getObjectById(bar_tb.class,sql,hostid);
	}

	/**
	  *获取所有的话圈.
	  * @return java.util.List(com.koala.entity.bar_tb)
	  **/
	@Override
	public List<bar_tb> getAllBar() {
		String sql = "select * from bar_tb";
        return JdbcUtils.getList(bar_tb.class,sql);
	}

	/**
	  *添加一个话圈.
	  * @param bar com.koala.entity.bar_tb
	  * @return com.koala.entity.bar_tb
	  **/
	@Override
	public bar_tb addBar(bar_tb bar) {
		String sql = "insert into bar_tb values(?,?,?,?)";
        int tag = JdbcUtils.executeSQL(sql,bar.getHostid(),bar.getAdminid(),bar.getBarname(),bar.getCoverpic());
        if (tag == 0)return null;
        else
            return bar;
	}

	/**
	  *修改话圈的封面信息等.
	  * @param bar com.koala.entity.bar_tb
	  * @return boolean
	  **/
	@Override
	public boolean updateBarByHostId(bar_tb bar) {
		String sql = "update bar_tb set  admin = ?, barname = ?, coverpic = ? where hostid=?";
        int tag = JdbcUtils.executeSQL(sql, bar.getAdminid(), bar.getBarname(), bar.getCoverpic(),bar.getHostid());
        if (tag == 0)return false;
        else return true;
	}

	/**
	  *删除某个话圈.
	  * @param hostid int
	  * @return boolean
	  **/
	@Override
	public boolean deleteBarByHostId(int hostid) {
		String sql = "delete from bar_tb where hostid = ?";
        int tag = JdbcUtils.executeSQL(sql,hostid);
        if (tag == 0)return false;
        else return true;
	}
}