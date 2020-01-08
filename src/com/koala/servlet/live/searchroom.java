package com.koala.servlet.live;

import com.koala.entity.room_tb;
import com.koala.service.RoomManage;
import com.koala.service.UserManage;
import com.koala.service.impl.RoomManageImpl;
import com.koala.service.impl.UserManageImpl;
import com.koala.utils.JwtUtils;
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
  *通过关键字搜索房间标题.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/live/searchroom")
public class searchroom extends HttpServlet {
    public searchroom() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("searchroom");
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        PrintWriter out = response.getWriter();
        String token = null;
        String keyword = null;
        int tag = 1;
        // String url = "http://ccnubt.club:8080/koalaTV/imags/";//暂时不用
        String url = "http://47.106.186.164:8080/imgs/";


        try {
            token = jsonObject.getString("token");
            keyword = jsonObject.getString("keyword");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int userid = JwtUtils.decodeToken(token);
        token = JwtUtils.createToken(userid);
        RoomManage roomManage = new RoomManageImpl();
        List<room_tb> roomlist = roomManage.searchRoomByWord(keyword);
        UserManage userManage = new UserManageImpl();
        JSONArray rooms = new JSONArray();
        room_tb temp;
        if (roomlist == null)
            tag = -1;
        else {
            for (int i = 0; i < roomlist.size(); i++) {
                temp = roomlist.get(i);
                JSONObject object = new JSONObject();
                try {
                    object.put("roomid", temp.getRoomid());
                    object.put("title", temp.getTitle());
                    object.put("coverpic", url + temp.getCoverpic());
                    object.put("category", temp.getCategory());
                    object.put("username", userManage.getUserById(temp.getHostid()).getNickname());
                    rooms.put(object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            msg.put("tag",tag);
            msg.put("rooms",rooms);
            msg.put("token",token);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        out.print(msg);
        out.flush();
        out.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}