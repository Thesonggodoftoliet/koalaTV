package com.koala.dao;
/*
 * @Author_Marting.Lee
 * @Date_2019/12/26
 * @Description_AdminDao
 */

import com.koala.entity.admin_tb;

import java.util.List;

public interface AdminDao {
    List<admin_tb> getAdminByUserId(int userid);
    List<admin_tb> getAdminByRoomId(int roomid);
    admin_tb addAdmin(admin_tb admin);
    boolean deleteAdmin(admin_tb admin);
}
