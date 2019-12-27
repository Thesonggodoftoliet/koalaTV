package com.koala.dao;

import com.koala.entity.programmer_tb;
/**
  *只获取超级管理员的信息.
  *@author Marting.Lee
  *date 2019/12/27
  **/
public interface ProgrammerDao {
    programmer_tb getProgrammerById(int userid);
}
