package com.koala.servlet.youtuber;

import com.auth0.jwt.JWT;
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

/**
  *取消关注.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/youtuber/conselfollow")
public class conselfollow extends HttpServlet {
    public conselfollow() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("conselfollow");
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        PrintWriter out = response.getWriter();
        int userid= 0;
        String token = null;
        int follow = 0;
        int tag = 0;

        try {
            token = jsonObject.getString("token");
            follow = jsonObject.getInt("hostid");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        userid = JwtUtils.decodeToken(token);
        UserManage userManage = new UserManageImpl();
        if (userManage.concelFollow(userid,follow))
            tag = 1;

        token = JwtUtils.createToken(userid);
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