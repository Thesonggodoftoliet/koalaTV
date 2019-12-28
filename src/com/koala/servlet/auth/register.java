package com.koala.servlet.auth;

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

@WebServlet("/api/auth/register")
public class register extends HttpServlet {
    public register() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("register");
        int tag = 0;
        String token = null;
        JSONObject jsonObject =null;
        JSONObject msg = new JSONObject();
        user_tb user = new user_tb();
        PrintWriter out = response.getWriter();

        try {
            jsonObject = ReciveUtils.getObject(request);
            user.setPhone(jsonObject.getString("phone"));
            user.setUserpassword(jsonObject.getString("userpassword"));
            user.setGender(jsonObject.getInt("gender"));
            user.setNickname(jsonObject.getString("nickname"));
            user.setIcon(jsonObject.getString("icon"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UserManage userManage = new UserManageImpl();
        token =userManage.addUser(user);
        if (token == null)
            tag = -1;
        else if (token.equals("wrong"))
            tag = 0;
        else
            tag = 1;


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