package com.koala.servlet.youtuber;

import com.koala.entity.user_tb;
import com.koala.service.UserManage;
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

@WebServlet("/api/youtuber/followyoutuber")
public class followyoutuber extends HttpServlet {
    public followyoutuber() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("followyoutuber");
        PrintWriter out = response.getWriter();
        int tag = 0;
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        user_tb user = new user_tb();
        String token = null;

        try {
            token = jsonObject.getString("token");
            user.setUserid(JwtUtils.decodeToken(token));
            int follow = jsonObject.getInt("follow");
            user.setFollow(String.valueOf(follow));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UserManage userManage = new UserManageImpl();
        tag = userManage.followYoutuber(user);
        token = JwtUtils.createToken(user.getUserid());

        try {
            msg.put("tag",tag);
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