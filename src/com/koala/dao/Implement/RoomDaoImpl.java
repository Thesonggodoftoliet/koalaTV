package com.koala.dao.Implement;

import com.koala.dao.RoomDao;
import com.koala.entity.current_live;
import com.koala.entity.room_tb;
import com.koala.utils.JdbcUtils;

import java.util.List;
/**
 *对直播间进行增删查改.
 *@author Marting.Lee
 *date 2019/12/27
 **/

public class RoomDaoImpl implements RoomDao {
	/**
	  *通过直播间号查找直播间.
	  * @param roomid int
	  * @return com.koala.entity.room_tb 
	  **/
	@Override
	public room_tb getRoomByRoomId(int roomid) {
		String sql = "select * from room_tb where roomid = ?";
        return (room_tb) JdbcUtils.getObjectById(room_tb.class,sql,roomid);
	}

	/**
	  *通过主播号查找直播间.
	  * @param hostid int
	  * @return com.koala.entity.room_tb
	  **/
	@Override
	public room_tb getRoomByUserId(int hostid) {
		String sql = "select * from room_tb where hostid = ?";
        return (room_tb) JdbcUtils.getObjectById(room_tb.class,sql,hostid);
	}

	/**
	  *获取最后一个直播间.
	  * @return com.koala.entity.room_tb
	  **/
	@Override
	public room_tb getLastRoom() {
		String sql = "select * from room_tb order by roomid desc limit 0,1";
		return (room_tb)JdbcUtils.getObject(room_tb.class,sql);
	}

	/**
	  *获取所有直播间.
	  * @return java.util.List(com.koala.entity.room_tb)
	  **/
	@Override
	public List<room_tb> getAllRoom() {
		//模糊搜索不在此处实现
		String sql = "select * from room_tb";
        return JdbcUtils.getList(room_tb.class,sql);
	}

	/**
	  *根据类别查找.
	  * @param keyword String
	  * @return java.util.List(com.koala.entity.room_tb)
	  **/
	@Override
	public List<room_tb> getRoomsByCa(String keyword) {
		String sql = "select * from room_tb where category= '"+keyword+"'";
		return JdbcUtils.getList(room_tb.class,sql);
	}


	/**
	  *获取所有正在直播的直播间.
	  * @return java.util.List(com.koala.entity.room_tb)
	  **/
	/*
	@Override
	public List<room_tb> getAllLivingRoom() {
		String sql = "select * from room_tb where isLive = 1";
		return JdbcUtils.getList(room_tb.class,sql);
	}*/

	/**
	  *增加直播间.
	  * @param room com.koala.entity.room_tb
	  * @return com.koala.entity.room_tb
	  **/
	@Override
	public room_tb addRoom(room_tb room) {
		String sql = "insert into room_tb values(?,?,'"+room.getTitle()+"','"+room.getCategory()+"','"+room.getCoverpic()+"',?,?,?,'"+room.getReason()+"')";
        int tag = JdbcUtils.executeSQL(sql,room.getRoomid(), room.getHostid(),room.getIsLive(),room.getIsForbidden(),room.getForbidend());
        if (tag == 0)return null;
        else
            return room;
	}

	/**
	  *修改直播间的信息.
	  * @param room com.koala.entity.room_tb
	  * @return boolean
	  **/
	@Override
	public boolean updateRoom(room_tb room, current_live live) {
		String sql = "update room_tb set title ='"+room.getTitle()+"', category ='"+room.getCategory()+"', coverpic ='"+room.getCoverpic()+"',isLive ="+room.getIsLive()+"  where roomid="+room.getRoomid();
        String sql1 = "insert into current_live values("+live.getRoomid()+",'"+live.getRtmp()+"','"+live.getTitle()+"','"+live.getSecretkey()+"',"+live.getStreamId()+")";
		return JdbcUtils.executeTran(sql,sql1);
	}

	/**
	  *封禁直播间.
	  * @param room com.koala.entity.room_tb
	  * @return boolean
	  **/
	@Override
	public boolean shutRoom(room_tb room) {
		String sql = "update room_tb set isforbidden = ?,forbidend = ?,reason='"+room.getReason()+"' where roomid=?";
		int tag = JdbcUtils.executeSQL(sql,room.getIsForbidden(),room.getForbidend(),room.getRoomid());
		if (tag == 1) return true;
		else return false;
	}

	/**
	  *获取直播间总数.
	  * @return int
	  **/
	@Override
	public int getNumOfRoom() {
		String sql = "select * from room_tb";
        return JdbcUtils.getListCount(sql);
	}

	/**
	  *删除该直播间.
	  * @param userid int
	  * @return boolean
	  **/
	@Override
	public boolean deleteRoom(int userid) {
		String sql = "delete from room_tb where userid = ?";
        int tag = JdbcUtils.executeSQL(sql,userid);
        if (tag == 0)return false;
        else return true;
	}
}























