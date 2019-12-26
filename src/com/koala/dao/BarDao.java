package com.koala.dao;
/*
 * @Author_Marting.Lee
 * @Date_2019/12/26
 * @Description_BarDao
 */

import com.koala.entity.bar_tb;

import java.util.List;

public interface BarDao {
    List<bar_tb> getAllBar();
    bar_tb addBar(bar_tb bar);
    boolean updateBarByHostId(bar_tb bar);
    boolean deleteBarByHostId(int hostid);
}
