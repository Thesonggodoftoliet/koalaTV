package com.koala.servlet.bar;

import com.koala.entity.bar_;
import com.koala.entity.post_;
import com.koala.entity.user_tb;
import com.koala.service.BarManage;
import com.koala.service.impl.BarManageImpl;
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
  *删帖.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/bar/deletepost")
public class deletepost extends HttpServlet {
    public deletepost() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deletepost");
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        PrintWriter out  = response.getWriter();
        String token = null;
        int userid = 0;
        int hostid = 0;
        int barid = 0;

        try {
            token = jsonObject.getString("token");
            hostid = jsonObject.getInt("hostid");
            barid = jsonObject.getInt("barid");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        bar_ bar = new bar_();
        bar.setBarid(barid);
        bar.setHostid(hostid);

        userid = JwtUtils.decodeToken(token);
        BarManage barManage = new BarManageImpl();
        int tag = barManage.deletePost(userid,bar);
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