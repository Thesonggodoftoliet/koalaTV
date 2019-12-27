package com.koala.dao;

import com.koala.entity.admin_tb;

import java.util.List;
/**
  *对管理员的增删查改.
  *@author Marting.Lee
  *date 2019/12/26
  **/
public interface AdminDao {
    List<admin_tb> getAdminByUserId(int userid);
    List<admin_tb> getAdminByRoomId(int roomid);
    admin_tb addAdmin(admin_tb admin);
    boolean deleteAdmin(admin_tb admin);
    boolean deleteAdminByUser(int userid);
    boolean deleteAdminByRoom(int roomid);
}
