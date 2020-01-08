package com.koala.servlet.live;

import com.koala.entity.room_tb;
import com.koala.service.RoomManage;
import com.koala.service.UserManage;
import com.koala.service.impl.RoomManageImpl;
import com.koala.service.impl.UserManageImpl;
import com.koala.utils.ReciveUtils;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
  *通过roomid搜索房间.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/live/searchroombyid")
public class searchroombyid extends HttpServlet {
    public searchroombyid() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("searchroombyid");
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        PrintWriter out = response.getWriter();
        int roomid = 0;
        int tag = 0;
        // String url = "http://ccnubt.club:8080/koalaTV/imags/";//暂时不用
        String url = "http://47.106.186.164:8080/imgs/";


        try {
            roomid = jsonObject.getInt("roomid");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RoomManage roomManage =new RoomManageImpl();
        room_tb room = roomManage.getRoom(roomid);
        UserManage userManage = new UserManageImpl();
        if (room !=null) {
            try {
                msg.put("tag", 1);
                msg.put("roomid", room.getRoomid());
                msg.put("username", userManage.getUserById(room.getHostid()).getNickname());
                msg.put("title", room.getTitle());
                msg.put("coverpic", url + room.getCoverpic());
                msg.put("category", room.getCategory());
                msg.put("isForbidden", room.getIsForbidden());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                msg.put("tag",-1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        out.print(msg);
        out.flush();
        out.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}