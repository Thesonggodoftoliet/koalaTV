package com.koala.servlet.live;

import com.koala.entity.bar_tb;
import com.koala.entity.room_tb;
import com.koala.service.BarManage;
import com.koala.service.RoomManage;
import com.koala.service.UserManage;
import com.koala.service.impl.BarManageImpl;
import com.koala.service.impl.RoomManageImpl;
import com.koala.service.impl.UserManageImpl;
import com.koala.utils.JwtUtils;
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
/**
  *显示主播的管理信息.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/live/showhostmanage")
public class showhostmanage extends HttpServlet {
    public showhostmanage() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("showhostmanage");
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        PrintWriter out = response.getWriter();
        int userid = 0;
        String token = null;
        try {
            token = jsonObject.getString("token");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        userid  = JwtUtils.decodeToken(token);
        RoomManage roomManage = new RoomManageImpl();
        room_tb room = roomManage.getRoom(userid);
        BarManage barManage = new BarManageImpl();
        bar_tb bar = barManage.getBar(userid);
        token = JwtUtils.createToken(userid);
        UserManage userManage = new UserManageImpl();
        try {
            msg.put("roomid",room.getRoomid());
            msg.put("title",room.getTitle());
            msg.put("category",room.getCategory());
            msg.put("adminid",bar.getAdminid());
            msg.put("barname",bar.getBarname());
            msg.put("coverpic","http://ccnubt.club:8080/imgs/"+bar.getCoverpic());
            msg.put("numofpost",barManage.getNumofPost(bar.getHostid()));
            msg.put("adminname",userManage.getUserById(bar.getAdminid()).getNickname());
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