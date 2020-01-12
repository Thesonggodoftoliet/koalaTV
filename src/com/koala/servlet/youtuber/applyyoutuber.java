package com.koala.servlet.youtuber;

import com.koala.entity.bar_tb;
import com.koala.entity.room_tb;
import com.koala.entity.user_tb;
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
  *申请成为主播.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/youtuber/applyyoutuber")
public class applyyoutuber extends HttpServlet {
    public applyyoutuber() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("applyyoutuber");
        //没有考虑它已经是主播的情况
        int tag = 0;
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        PrintWriter out = response.getWriter();
        String token = null;
        user_tb user = new user_tb();
        room_tb room = new room_tb();
        bar_tb bar = new bar_tb();
        try {
            token = jsonObject.getString("token");
            user.setUserid(JwtUtils.decodeToken(token));
            room.setCategory(jsonObject.getString("category"));
            room.setCoverpic(jsonObject.getString("coverpic"));
            room.setHostid(user.getUserid());
            room.setTitle(jsonObject.getString("title"));
            bar.setHostid(user.getUserid());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        UserManage userManage = new UserManageImpl();

        //关注自己
        user.setFollow(String.valueOf(user.getUserid()));
        userManage.followYoutuber(user);


        user = userManage.getUserById(user.getUserid());
        bar.setBarname(user.getNickname());
        bar.setCoverpic(user.getIcon());

        tag =userManage.applyForBar(user,bar,room);

        token = JwtUtils.createToken(user.getUserid());

        try {
            msg.put("token",token);
            msg.put("tag",tag);
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