package com.koala.service.impl;

import com.koala.dao.BarDao;
import com.koala.dao.Bar_Dao;
import com.koala.dao.Implement.BarDaoImpl;
import com.koala.dao.Implement.Bar_DaoImpl;
import com.koala.entity.bar_tb;
import com.koala.service.BarManage;

/**
 * 对话圈进行管理.
 * @author Marting.Lee
 * 2019/12/29
 */
public class BarManageImpl implements BarManage {
    private BarDao barDao = new BarDaoImpl();
    private Bar_Dao bar_dao = new Bar_DaoImpl();
    /**
      *增加话圈.
      * @param bar com.koala.entity.bar_tb
      * @return int
      **/
    @Override
    public int addBar(bar_tb bar) {
        bar.setAdminid(bar.getHostid());
        if (barDao.addBar(bar) != null && bar_dao.createTable(bar.getHostid()))
            return 1;
        else
            return 0;
    }
}
