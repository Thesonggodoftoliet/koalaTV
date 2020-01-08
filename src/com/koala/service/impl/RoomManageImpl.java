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
import com.koala.utils.SearchUtils;
import com.koala.utils.StreamUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 直播间管理.
 * @author Marting.Lee
 * 2019/12/29
 */
public class RoomManageImpl implements RoomManage {
    private RoomDao roomDao= new RoomDaoImpl();

    /**
      * 根据房间号获取房间.
      * @param roomid int
      * @return com.koala.entity.room_tb
      **/
    @Override
    public room_tb getRoom(int roomid) {
        return roomDao.getRoomByRoomId(roomid);
    }

    /**
      *添加直播间.
      * @param room com.koala.entity.room_tb
      * @return int
      **/
    @Override
    public int addRoom(room_tb room) {
        room.setRoomid(room.getHostid());
        if (room.getCoverpic() == null)
            room.setCoverpic("默认封面.jpg");
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
        if (title.isEmpty()){
            currentLive.setTitle(roomTb.getTitle());
        }
        else {
            roomTb.setTitle(title);
            currentLive.setTitle(title);
        }
        StreamUtils streamUtils = new StreamUtils(userid);
        currentLive.setRoomid(userid);
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
            if (roomDao.updateRoom(roomTb,currentLive))
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
        if (hostid == null || hostid.isEmpty())//没有关注的主播
            return room_tbs;
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
        if (part == null){
            all.clear();
            return all;
        }
        for (int i=0;i<all.size();i++){
            if (!part.contains(all.get(i))) {
                all.remove(i);
                i--;
            }
        }
        return all;
    }

    /**
      *获取所有被封禁的直播间.
      * @return java.util.List(com.koala.entity.room_tb)
      **/
    @Override
    public List<room_tb> getRoomForbidden() {
        List<room_tb> rooms = roomDao.getAllRoom();
        for (int i=0;i<rooms.size();i++)
            if (rooms.get(i).getIsForbidden() != 1) {
                rooms.remove(i);
                i--;
            }
        return rooms;
    }

    /**
      *获取没有封禁的直播间.
      * @return java.util.List(com.koala.entity.room_tb)
      **/
    @Override
    public List<room_tb> getRoomNotForbidden() {
        List<room_tb> rooms = roomDao.getAllRoom();
        for (int i=0;i<rooms.size();i++)
            if (rooms.get(i).getIsForbidden() == 1) {
                rooms.remove(i);
                i--;
            }
        return rooms;
    }

    /**
      *根据关键词搜索房间.
      * @param keyword String
      * @return java.util.List(com.koala.entity.room_tb)
      **/
    @Override
    public List<room_tb> searchRoomByWord(String keyword) {
        List<room_tb> rooms = roomDao.getAllRoom();
        return SearchUtils.getRoomList(keyword,rooms);
    }

    /**
      *查询修改直播间封禁信息.
      * @param roomid int
     * @param time long
      * @return boolean
      **/
    @Override
    public boolean shutdownRoom(int roomid, long time) {
        Calendar now = Calendar.getInstance();
        room_tb room = roomDao.getRoomByRoomId(roomid);
        if (time == 0){//查询封禁信息
            if (now.after(room.getForbidend())){
                room.setIsForbidden(0);//解除封禁
                roomDao.shutRoom(room);
                return false;//解除封禁
            }
            else
                return true;
        }
        else {//进行封禁处理
            room.setIsForbidden(1);
            room.setForbidend(time);
            return roomDao.shutRoom(room);
        }

    }

    /**
      *对封锁的直播间解除封禁.
      * @param roomid int
      * @return boolean
      **/
    @Override
    public boolean deblockRoom(int roomid) {
        room_tb room = roomDao.getRoomByRoomId(roomid);
        room.setIsForbidden(0);
        return roomDao.shutRoom(room);
    }
}
