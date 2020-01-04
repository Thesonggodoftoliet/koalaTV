package com.koala.service;

import com.koala.entity.room_tb;

import java.util.List;

/**
 * 对直播间的管理.
 * @author Marting.Lee
 * 2019/12/29
 */
public interface RoomManage {
    room_tb getRoom(int roomid);
    int addRoom(room_tb room);
    String onLiving(int userid,String title);
    List<room_tb> getRoomsOnlive();
    List<room_tb> getRoomsFollow(int userid);
    List<room_tb> getRoomsByCat(String category);
    List<room_tb> getRoomForbidden();
    List<room_tb> getRoomNotForbidden();
    List<room_tb> searchRoomByWord(String keyword);
    boolean shutdownRoom(int roomid,long time);
    boolean deblockRoom(int roomid);
}
