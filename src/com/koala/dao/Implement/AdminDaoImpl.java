package com.koala.dao.Implement;
/*
 * @Author_KevinMarkVine
 * @Date_2019/12/26
 * @Description_AdminDaoImpl
 */



public class AdminDaoImpl implements AdminDao {
	@Override
	//list的语句是在后面+id，普通的就是=？
	public List<admin_tb> getAdminByUserId(int userid) {
		String sql = "select * from admin_tb where userid = " + userid;
        return JdbcUtils.getList(admin_tb.class,sql);
 	}

	@Override
	public List<admin_tb> getAdminByRoomId(int roomid) {
		String sql = "select * from admin_tb where roomid = " + roomid;
        return JdbcUtils.getList(admin_tb.class,sql);
	}

	//对象就是用函数获取private的值，普通的就是直接写值就行
	@Override
	public admin_tb addAdmin(admin_tb admin) {
		String sql = "insert into admin_tb values(?,?)";
        int tag = JdbcUtils.executeSQL(sql,admin.getUserid(),admin.getRoomid());
        if (tag == 0)return null;
        else
            return admin;
	}

	@Override
	public boolean deleteAdmin(admin_tb admin) {
		String sql = "delete from admin_tb where userid = ?" ;
        int tag = JdbcUtils.executeSQL(sql,admin.getUserid());
        if (tag == 0)return false;
        else return true;
	}
}