package com.koala.dao;
/*
 * @Author_Marting.Lee
 * @Date_2019/12/26
 * @Description_RoomDao
 */

import com.koala.entity.room_tb;

import java.util.List;
/**
  *对直播间进行增删查改.
  *@author Marting.Lee
  *date 2019/12/27
  **/
public interface RoomDao {
    room_tb getRoomByRoomId(int roomid);
    room_tb getRoomByUserId(int userid);
    room_tb getLastRoom();
    List<room_tb> getAllRoom();
    List<room_tb> getRoomsByCa(String keyword);
    //List<room_tb> getAllLivingRoom();
    room_tb addRoom(room_tb room);
    boolean updateRoom(room_tb room);
    int getNumOfRoom();
    boolean deleteRoom(int userid);
}
