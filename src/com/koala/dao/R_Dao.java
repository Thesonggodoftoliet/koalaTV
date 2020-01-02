package com.koala.dao;

import com.koala.entity.r_;

import java.util.List;

/**
 * 对直播间权限管理.
 * @author Marting.Lee
 * 2019/12/27
 */
public interface R_Dao {
    List<r_> getAll(int roomid);
    r_ addR(r_ r);
    boolean createR(int roomid);
    boolean updateR(r_ r);
    boolean deleteR(r_ r);
    boolean deleteR(int roomid);
}
