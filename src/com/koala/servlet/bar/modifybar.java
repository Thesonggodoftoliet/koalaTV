package com.koala.servlet.bar;

import com.koala.entity.bar_tb;
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
  *修改话圈.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/bar/modifybar")
public class modifybar extends HttpServlet {
    public modifybar() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("modifybar");
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        PrintWriter out = response.getWriter();
        String token = null;
        int tag = 0;
        bar_tb bar = new bar_tb();
        int userid = 0;

        try {
            token = jsonObject.getString("token");
            bar.setHostid(jsonObject.getInt("hostid"));
            bar.setBarname(jsonObject.getString("barname"));
            bar.setCoverpic(jsonObject.getString("coverpic"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        userid = JwtUtils.decodeToken(token);
        BarManage barManage = new BarManageImpl();
        tag = barManage.modifyBar(bar,userid);
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