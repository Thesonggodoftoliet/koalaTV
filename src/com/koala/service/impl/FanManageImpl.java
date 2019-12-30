package com.koala.service.impl;

import com.koala.dao.Fans_Dao;
import com.koala.dao.Implement.Fans_DaoImpl;
import com.koala.entity.fans_;
import com.koala.service.FanManage;

/**
 * 粉丝管理.
 * @author Marting.Lee
 * 2019/12/29
 */
public class FanManageImpl implements FanManage {
    private Fans_Dao fans_dao= new Fans_DaoImpl();

    /**
      *增加粉丝.
      * @param fan com.koala.entity.fans_
      * @return int
      **/
    @Override
    public int addFan(fans_ fan) {
        fans_dao.createTable(fan.getHostid());
        return 1;
    }
}
