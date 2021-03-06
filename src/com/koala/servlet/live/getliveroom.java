package com.koala.servlet.live;

import com.koala.entity.room_tb;
import com.koala.service.RoomManage;
import com.koala.service.UserManage;
import com.koala.service.impl.RoomManageImpl;
import com.koala.service.impl.UserManageImpl;
import com.koala.utils.JwtUtils;
import com.koala.utils.LiveUtils;
import com.koala.utils.ReciveUtils;
import org.json.JSONArray;
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
  *根据关键字查询正在直播的房间.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/live/getliveroom")
public class getliveroom extends HttpServlet {
    public getliveroom() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getliveroom");
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        String token = null;
        String category =null;
        int tag = 0;
        PrintWriter out = response.getWriter();
         String url = "http://ccnubt.club:8080/imgs/";//暂时不用
        //String url = "http://47.106.186.164:8080/imgs/";

        try {
            category = jsonObject.getString("category");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray rooms = new JSONArray();
        RoomManage roomManage = new RoomManageImpl();
        List<room_tb> roomTbList;
        if (category.equals("all"))
            roomTbList=roomManage.getRoomsOnlive();
        else if (category.equals("follow")) {
            try {
                token = jsonObject.getString("token");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            int userid = JwtUtils.decodeToken(token);
            roomTbList = roomManage.getRoomsFollow(userid);
            token = JwtUtils.createToken(userid);
        }
        else
            roomTbList = roomManage.getRoomsByCat(category);
        if (roomTbList.isEmpty())
            tag = -1;
        else {
            tag = 1;
            int roomid;
            room_tb temp;
            UserManage userManage = new UserManageImpl();
            for (int i=0;i<roomTbList.size();i++){
                try {
                    JSONObject object = new JSONObject();
                    temp = roomTbList.get(i);
                    roomid = temp.getRoomid();
                    object.put("username",userManage.getUserById(temp.getHostid()).getNickname());
                    object.put("roomid",roomid);
                    object.put("category",temp.getCategory());
                    object.put("coverpic",url+temp.getCoverpic());
                    object.put("title",temp.getTitle());
                    object.put("num", LiveUtils.getNum(roomid));
                    rooms.put(object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            msg.put("tag",tag);
            msg.put("token",token);
            msg.put("rooms",rooms);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(msg);

        out.print(msg);
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}