package com.koala.dao;

import com.koala.entity.bar_tb;

import java.util.List;
/**
  *对话圈信息进行增删查改.
  *@author Marting.Lee
  *date 2019/12/27
  **/
public interface BarDao {
    bar_tb getBarByHostId(int hostid);
    List<bar_tb> getAllBar();
    bar_tb addBar(bar_tb bar);
    boolean updateBarByHostId(bar_tb bar);
    boolean deleteBarByHostId(int hostid);
}
