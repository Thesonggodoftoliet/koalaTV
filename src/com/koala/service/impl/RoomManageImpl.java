package com.koala.service.impl;

import com.koala.dao.Implement.RoomDaoImpl;
import com.koala.dao.RoomDao;
import com.koala.entity.current_live;
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

    /**
      *开启直播.
      * @param userid int
     * @param title
      * @return java.lang.String
      **/
    @Override
    public String onLiving(int userid, String title) {
        room_tb roomTb;
        current_live currentLive = new current_live();
        roomTb = roomDao.getRoomByUserId(userid);
        if (title == null){
            currentLive.setTitle(roomTb.getTitle());
        }
        else {
            roomTb.setTitle(title);
            currentLive.setTitle(title);
        }
        roomTb.setIsLive(1);

        return null;
    }
}
