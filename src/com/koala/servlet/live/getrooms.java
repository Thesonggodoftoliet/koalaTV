package com.koala.servlet.live;

import com.koala.entity.room_tb;
import com.koala.service.RoomManage;
import com.koala.service.UserManage;
import com.koala.service.impl.RoomManageImpl;
import com.koala.service.impl.UserManageImpl;
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
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/api/live/getrooms")
public class getrooms extends HttpServlet {
    public getrooms() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getrooms");
        JSONObject msg = new JSONObject();
        PrintWriter out = response.getWriter();
        RoomManage roomManage = new RoomManageImpl();
        List<room_tb> forbidden = roomManage.getRoomForbidden();
        List<room_tb> notforbidden = roomManage.getRoomNotForbidden();
        UserManage userManage = new UserManageImpl();
        int tag = 1;
        if (forbidden.size() == 0)
            tag = -1;
        JSONArray forbiddens = new JSONArray();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i=0;i<forbidden.size();i++){
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("roomid",forbidden.get(i).getRoomid());
                jsonObject.put("username",userManage.getUserById(forbidden.get(i).getHostid()).getNickname());
                jsonObject.put("category",forbidden.get(i).getCategory());
                jsonObject.put("endtime",simpleDateFormat.format(forbidden.get(i).getForbidend()));
                forbiddens.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        JSONArray notforbiddens = new JSONArray();
        for (int i=0;i<notforbidden.size();i++){
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("roomid",notforbidden.get(i).getRoomid());
                jsonObject.put("username",userManage.getUserById(notforbidden.get(i).getHostid()).getNickname());
                jsonObject.put("category",notforbidden.get(i).getCategory());
                notforbiddens.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        try {
            msg.put("tag",tag);
            msg.put("forbiddens",forbiddens);
            msg.put("notforbiddens",notforbiddens);
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