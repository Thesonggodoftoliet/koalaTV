package com.koala.dao.Implement;

import com.koala.dao.ProgrammerDao;
import com.koala.entity.programmer_tb;
import com.koala.utils.JdbcUtils;
/**
 *只获取超级管理员的信息.
 *@author Marting.Lee
 *date 2019/12/27
 **/
public class ProgrammerDaoImpl implements ProgrammerDao {
	/**
	  *根据用户Id获取超级管理员.
	  * @param userid int
	  * @return com.koala.entity.programmer_tb
	  **/
	@Override
	public programmer_tb getProgrammerById(int userid) {
		String sql = "select * from programmer_tb where useraccount = ?";
        return (programmer_tb) JdbcUtils.getObjectById(programmer_tb.class,sql,userid);
	}
}