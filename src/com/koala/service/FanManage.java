package com.koala.service;

import com.koala.entity.fans_;

/**
 * 粉丝管理.
 * @author Marting.Lee
 * 2019/12/29
 */
public interface FanManage {
    int addFan(fans_ fan);
    int getNumOfFan(int hostid);
    int isFollow(int userid,int hostid);
}
