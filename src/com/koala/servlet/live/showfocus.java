package com.koala.servlet.live;

import com.auth0.jwt.JWT;
import com.koala.service.FanManage;
import com.koala.service.impl.FanManageImpl;
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

@WebServlet("/api/live/showfocus")
public class showfocus extends HttpServlet {
    public showfocus() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("showfocus");
        JSONObject msg  = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        PrintWriter out = response.getWriter();
        String token = null;
        int roomid =0;
        int tag = 0;

        try {
            token = jsonObject.getString("token");
            roomid = jsonObject.getInt("roomid");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int userid = JwtUtils.decodeToken(token);
        FanManage fanManage = new FanManageImpl();
        tag = fanManage.isFollow(userid,roomid);
        token = JwtUtils.createToken(userid);

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