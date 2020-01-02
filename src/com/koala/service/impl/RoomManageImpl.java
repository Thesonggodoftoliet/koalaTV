package com.koala.service.impl;

import com.koala.dao.Current_liveDao;
import com.koala.dao.Implement.Current_liveDaoImpl;
import com.koala.dao.Implement.RoomDaoImpl;
import com.koala.dao.Implement.UserDaoImpl;
import com.koala.dao.RoomDao;
import com.koala.dao.UserDao;
import com.koala.entity.current_live;
import com.koala.entity.room_tb;
import com.koala.entity.user_tb;
import com.koala.service.BarManage;
import com.koala.service.RoomManage;
import com.koala.utils.LiveUtils;
import com.koala.utils.PraseUtils;
import com.koala.utils.StreamUtils;

import java.util.ArrayList;
import java.util.List;

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
     * @param title String
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
        StreamUtils streamUtils = new StreamUtils(userid);
        currentLive.setRtmp(streamUtils.getRtmp());
        currentLive.setSecretkey(streamUtils.getSecretKey());
        currentLive.setStreamId(streamUtils.getStreamId());
        String msg = currentLive.getRtmp()+","+currentLive.getSecretkey();//rtmp在前，secretkey在后
        Current_liveDao current_liveDao =new Current_liveDaoImpl();
        if (roomTb.getIsLive()==1){//开播过
            if (current_liveDao.updateLive(currentLive))
                return msg;
        }
        else {//萌新一枚
            roomTb.setIsLive(1);
            if (roomDao.updateRoom(roomTb) && current_liveDao.addLive(currentLive)!=null)
                return msg;
        }

        return null;
    }

    /**
      *获取正在直播的房间.
      * @return java.util.List(com.koala.entity.room_tb)
      **/
    @Override
    public List<room_tb> getRoomsOnlive() {
        List<Integer> roomid = LiveUtils.getLives();
        List<room_tb> rooms = new ArrayList<>();
        for (int i=0;i<roomid.size();i++)
            rooms.add(roomDao.getRoomByUserId(roomid.get(i)));
        return rooms;
    }

    /**
      *获取关注的房间.
      * @param userid int
      * @return java.util.List(com.koala.entity.room_tb)
      **/
    @Override
    public List<room_tb> getRoomsFollow(int userid) {
        UserDao userDao = new UserDaoImpl();
        user_tb userTb = userDao.getUserById(userid);
        List<Integer> hostid = PraseUtils.sToi(userTb.getFollow());
        List<room_tb> room_tbs = new ArrayList<>();
        for (int i=0;i<hostid.size();i++)
            room_tbs.add(roomDao.getRoomByUserId(hostid.get(i)));
        return room_tbs;
    }

    /**
      *根据类别查询在播房间.
      * @param category String
      * @return java.util.List(com.koala.entity.room_tb)
      **/
    @Override
    public List<room_tb> getRoomsByCat(String category){
        List<room_tb> all = getRoomsOnlive();
        List<room_tb> part = roomDao.getRoomsByCa(category);
        for (int i=0;i<all.size();i++){
            if (!part.contains(all.get(i)))
                all.remove(i);
        }
        return all;
    }
}
