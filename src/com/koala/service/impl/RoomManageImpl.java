package com.koala.service.impl;

import com.koala.dao.Implement.RoomDaoImpl;
import com.koala.dao.RoomDao;
import com.koala.entity.room_tb;
import com.koala.service.RoomManage;

/**
 * 直播间管理.
 * @author Marting.Lee
 * 2019/12/29
 */
public class RoomManageImpl implements RoomManage {
    private RoomDao roomDao= new RoomDaoImpl();

    /**
      *添加直播间.
      * @param room com.koala.entity.room_tb
      * @return int
      **/
    @Override
    public int addRoom(room_tb room) {
        room.setRoomid(room.getHostid());
        if (roomDao.addRoom(room)!=null)
            return 1;
        else
            return 0;
    }
}
