package com.koala.dao.Implement;

import com.koala.dao.AdminDao;
import com.koala.entity.admin_tb;
import com.koala.utils.JdbcUtils;

import java.util.List;

/**
  *对管理员的增删查改.
  *@author Marting.Lee
  *date 2019/12/26
  **/
public class AdminDaoImpl implements AdminDao {

	/**
	  *通过管理员的userid查找管理的所有房间.
	  *@param userid int
	  *@return java.util.List(com.koala.entity.admin_tb)
	  **/

	@Override
	public List<admin_tb> getAdminByUserId(int userid) {
		String sql = "select * from admin_tb where userid = " + userid;
        return JdbcUtils.getList(admin_tb.class,sql);
 	}
 	
	/**
	  *通过对直播间的roomid查找所有的管理.
	  * @param roomid int
	  * @return java.util.List(com.koala.entity.admin_tb)
	  **/
	@Override
	public List<admin_tb> getAdminByRoomId(int roomid) {
		String sql = "select * from admin_tb where roomid = " + roomid;
        return JdbcUtils.getList(admin_tb.class,sql);
	}

	/**
	  *添加某个房间的房管.
	  * @param admin com.koala.entity.admin_tb
	  * @return com.koala.entity.admin_tb
	  **/
	@Override
	public admin_tb addAdmin(admin_tb admin) {
		String sql = "insert into admin_tb values(?,?)";
        int tag = JdbcUtils.executeSQL(sql,admin.getUserid(),admin.getRoomid());
        if (tag == 0)return null;
        else
            return admin;
	}

	/**
	  *删除某个直播间的某个房管.
	  * @param admin com.koala.entity.admin_tb
	  * @return boolean
	  **/
	@Override
	public boolean deleteAdmin(admin_tb admin) {
		String sql = "delete from admin_tb where userid = ? and roomid = ?" ;
		int tag = JdbcUtils.executeSQL(sql,admin.getUserid(),admin.getRoomid());
		if (tag == 0)return false;
		else return true;
	}

	/**
	  *删除某个人的房管信息.
	  * @param userid int
	  * @return boolean
	  **/
	@Override
	public boolean deleteAdminByUser(int userid) {
		String sql = "delete from admin_tb where userid = ?";
		int tag = JdbcUtils.executeSQL(sql,userid);
		if (tag == 0)return false;
		else return  true;
	}

	/**
	  *删除某个直播间的所有房管.
	  * @param roomid int 
	  * @return boolean
	  **/
	@Override
	public boolean deleteAdminByRoom(int roomid) {
		String sql = "delete from admin_tb where roomid = ?";
		int tag = JdbcUtils.executeSQL(sql,roomid);
		if (tag == 0)return false;
		else return true;
	}

}