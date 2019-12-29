package com.koala.servlet.manage;

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

@WebServlet("/api/manage/vimpersonalinfo")
public class vimpersonalinfo extends HttpServlet {
    public vimpersonalinfo() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("vimpersonalinfo");
        JSONObject jsonObject;
        PrintWriter out = response.getWriter();
        JSONObject msg = new JSONObject();
        int tag =0;
        String token = null;
        user_tb user = new user_tb();
        try {
            jsonObject = ReciveUtils.getObject(request);
            token = jsonObject.getString("token");
            user.setUserid(JwtUtils.decodeToken(token));
            user.setIcon(jsonObject.getString("icon"));
            user.setNickname(jsonObject.getString("nickname"));
            user.setGender(jsonObject.getInt("gender"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UserManage userManage = new UserManageImpl();
        tag = userManage.modifyUser(user);
        if (tag == 1)
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