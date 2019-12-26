package com.koala.dao.Implement;
/*
 * @Author_KevinMarkVine
 * @Date_2019/12/26
 * @Description_rogrammerDaoImpl
 */

public class ProgrammerDaoImpl implements ProgrammerDao {
	@Override
	public programmer_tb getProgrammerById(int userid) {
		String sql = "select * from programmer_tb where useraccount = ?";
        return (programmer_tb) JdbcUtils.getObjectById(programmer_tb.class,sql,userid);
	}
}