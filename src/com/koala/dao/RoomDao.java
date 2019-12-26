package com.koala.dao;
/*
 * @Author_Marting.Lee
 * @Date_2019/12/26
 * @Description_RoomDao
 */

import com.koala.entity.room_tb;

import java.util.List;

public interface RoomDao {
    room_tb getRoomByRoomId(int roomid);
    room_tb getRoomByUserId(int userid);
    List<room_tb> getAllRoom(String exasql);//exasql 额外选项（全部房间或者是标题或者分类）
    room_tb addRoom(room_tb room);
    boolean updateRoom(room_tb room);
    int getNumOfRoom();
    boolean deleteRoom(int userid);
}
