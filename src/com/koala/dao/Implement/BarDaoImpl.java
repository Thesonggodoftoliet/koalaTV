package com.koala.dao.Implement;
/*
 * @Author_KevinMarkVine
 * @Date_2019/12/26
 * @Description_BarDaoImpl
 */

public class BarDaoImpl implements BarDao {
	@Override
	public List<bar_tb> getAllBar() {
		String sql = "select * from bar_tb";
        return JdbcUtils.getList(bar_tb.class,sql);
	}

	@Override
	public bar_tb addBar(bar_tb bar) {
		String sql = "insert into bar_tb values(?,?,?,?)";
        int tag = JdbcUtils.executeSQL(sql,bar.getHostid(),bar.getAdminid(),bar.getBarname(),bar.getCoverpic());
        if (tag == 0)return null;
        else
            return bar;
	}

	@Override
	public boolean updateBarByHostId(bar_tb bar) {
		String sql = "update bar_tb set hostid =?, admin = ?, barname = ?, coverpic = ?";
        int tag = JdbcUtils.executeSQL(sql, bar.getHostid(), bar.getAdminid(), bar.getBarname(), bar.getCoverpic());
        if (tag == 0)return false;
        else return true;
	}

	@Override
	public boolean deleteBarByHostId(int hostid) {
		String sql = "delete from bar_tb where hostid = ?";
        int tag = JdbcUtils.executeSQL(sql,hostid);
        if (tag == 0)return false;
        else return true;
	}
}