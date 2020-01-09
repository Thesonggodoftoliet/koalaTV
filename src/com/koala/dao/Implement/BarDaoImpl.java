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
	  *添加一个话圈，并为话圈创建帖子表.
	  * @param bar com.koala.entity.bar_tb
	  * @return com.koala.entity.bar_tb
	  **/
	@Override
	public bar_tb addBar(bar_tb bar) {
		String sql1 = "insert into bar_tb values("+bar.getHostid()+","+bar.getAdminid()+",'"+bar.getBarname()+"','"+bar.getCoverpic()+"');";
		String sql2 ="create table bar_"+bar.getHostid()+"(hostid int unsigned,"+
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
		if (JdbcUtils.executeTran(sql1,sql2))
			return bar;
		else
			return null;
	}

	/**
	  *修改话圈的封面信息等.
	  * @param bar com.koala.entity.bar_tb
	  * @return boolean
	  **/
	@Override
	public boolean updateBarByHostId(bar_tb bar) {
		String sql = "update bar_tb set  barname = '"+ bar.getBarname()+"', coverpic ='"+ bar.getCoverpic()+"' where hostid=?";
        int tag = JdbcUtils.executeSQL(sql, bar.getAdminid(),bar.getHostid());
        if (tag == 0)return false;
        else return true;
	}

	/**
	  *更换话圈主持人.
	  * @param bar com.koala.entity.bar_tb
	  * @return boolean
	  **/
	@Override
	public boolean changeAdmin(bar_tb bar) {
		String sql1 = "update bar_tb set adminid ="+bar.getAdminid()+" where hostid="+bar.getHostid();
		String sql2 = "update user_tb set isBarhost = 1 where userid="+bar.getHostid();
		return JdbcUtils.executeTran(sql1,sql2);
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