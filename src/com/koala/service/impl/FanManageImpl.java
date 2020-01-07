package com.koala.service.impl;

import com.koala.dao.Fans_Dao;
import com.koala.dao.Implement.Fans_DaoImpl;
import com.koala.entity.fans_;
import com.koala.service.FanManage;

import java.util.List;

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

    /**
      *获取主播总粉丝数.
      * @param hostid int
      * @return int
      **/
    @Override
    public int getNumOfFan(int hostid) {
        return fans_dao.getNumOfFan(hostid);
    }


    /**
      *判断是否关注了主播.
      * @param userid int
     * @param hostid int
      * @return int
      **/
    @Override
    public int isFollow(int userid, int hostid) {
        List<fans_> all = fans_dao.getAllFan(hostid);
        fans_ fans = new fans_();
        fans.setHostid(hostid);
        fans.setUserid(userid);
        System.out.println("fansuserid"+fans.getUserid());
        for(int i=0;i<all.size();i++){
            System.out.println("all["+i+"].hostid="+all.get(i).getHostid()+"   userid="+all.get(i).getUserid());
        }
        if (all == null)
            return -1;//没有关注
        else {
            int flag = -1;
            for(int i=0;i<all.size();i++){
                if(all.get(i).getHostid()==fans.getHostid() && all.get(i).getUserid()==fans.getUserid()){
                    flag = 1;
                    break;
                }
            }
            return  flag;
        }
    }
}
