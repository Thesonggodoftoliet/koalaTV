package com.koala.dao;

import com.koala.entity.fans_;

import java.util.List;

/**
 * 对某个主播的粉丝进行管理.
 * @author Marting.Lee
 * 2019/12/27
 */
public interface Fans_Dao {
    List<fans_> getAllFan(int hostid);
    fans_ addFan(fans_ fans);
    int getNumOfFan(int hostid);
    boolean createTable(int hostid);
    boolean deleteFan(fans_ fans);
    boolean deleteFans(int hostid);
}
