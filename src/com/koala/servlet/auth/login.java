package com.koala.servlet.auth;

import com.google.gson.Gson;
import com.koala.entity.user_tb;
import com.koala.service.UserManage;
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

@WebServlet("/api/auth/login")
public class login extends HttpServlet {
    public login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
          tag = -1 密码错误  tag = -2 无此用户 tag = 0 服务器错误 tag = 1 成功
         */
        System.out.println("login");
        int tag = 0;
        String token = null;
        PrintWriter out = response.getWriter();
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = null;
        user_tb user = new user_tb();
        try {
            jsonObject = ReciveUtils.getObject(request);
            String phone = jsonObject.getString("phone");
            String password = jsonObject.getString("userpassword");
            user.setPhone(phone);
            user.setUserpassword(password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UserManage userManage = new UserManageImpl();
        token = userManage.authUser(user);
        if (token == null)
            tag = -2;
        else if (token.equals("wrong"))
            tag = -1;
        else
            tag =1;
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