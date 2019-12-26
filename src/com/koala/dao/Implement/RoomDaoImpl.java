package com.koala.dao.Implement;
/*
 * @Author_KevinMarkVine
 * @Date_2019/12/26
 * @Description_RoomDaoImpl
 */



public class RoomDaoImpl implements RoomDao {
	@Override
	public room_tb getRoomByRoomId(int roomid) {
		String sql = "select * from room_tb where roomid = ?";
        return (room_tb) JdbcUtils.getObjectById(room_tb.class,sql,roomid);
	}

	@Override
	public room_tb getRoomByUserId(int userid) {
		String sql = "select * from room_tb where userid = ?";
        return (room_tb) JdbcUtils.getObjectById(room_tb.class,sql,userid);

	}
	//这个函数需要重新写，K.M.Vine——19:40
	@Override
	public List<room_tb> getAllRoom(String exasql) {
		String sql = "select * from room_tb";
        return JdbcUtils.getList(room_tb.class,sql);
	}

	@Override
	public room_tb addRoom(room_tb room) {
		String sql = "insert into room_tb values(?,?,?,?,?)";
        int tag = JdbcUtils.executeSQL(sql,room.getRoomid(), room.getUserid(), room.getTitle(), room.getCategory(), room.getCoverpic());
        if (tag == 0)return null;
        else
            return room;
	}

	@Override
	public boolean updateRoom(room_tb room) {
		String sql = "update room_tb set roomid = ?, userid = ?, title = ?, category = ?, coverpic = ?";
        int tag = JdbcUtils.executeSQL(sql, room.getRoomid(), room.getUserid(), room.getTitle(), room.getCategory(), room.getCoverpic());
        if (tag == 0)return false;
        else return true;
	}

	@Override
	public int getNumOfRoom() {
		String sql = "select * from room_tb";
        return JdbcUtils.getListCount(sql);
	}
//删房间是主播号和房间号都行，我就直接用了主播号
	@Override
	public boolean deleteRoom(int userid) {
		String sql = "delete from room_tb where userid = ?";
        int tag = JdbcUtils.executeSQL(sql,userid);
        if (tag == 0)return false;
        else return true;
	}
}























