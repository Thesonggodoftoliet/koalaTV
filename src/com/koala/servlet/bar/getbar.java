package com.koala.servlet.bar;

import com.koala.entity.bar_tb;
import com.koala.service.BarManage;
import com.koala.service.UserManage;
import com.koala.service.impl.BarManageImpl;
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

@WebServlet("/api/bar/getbar")
public class getbar extends HttpServlet {
    public getbar() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getbar");
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        PrintWriter out = response.getWriter();
        String token = null;
        int hostid = 0;

        try {
            token = jsonObject.getString("tokne");
            hostid = jsonObject.getInt("hostid");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int userid = JwtUtils.decodeToken(token);
        token = JwtUtils.createToken(userid);
        BarManage barManage = new BarManageImpl();
        UserManage userManage = new UserManageImpl();
        bar_tb bar =  barManage.getBar(hostid);
        int tag = 0;
        if (bar == null)
            tag =-1;
        else {
            tag = 1;
            try {
                msg.put("barname",bar.getBarname());
                msg.put("hostid",bar.getHostid());
                msg.put("hostname",userManage.getUserById(bar.getHostid()).getNickname());
                msg.put("adminid",bar.getAdminid());
                msg.put("adminname",userManage.getUserById(bar.getAdminid()).getNickname());
                msg.put("coverpic",bar.getCoverpic());
                msg.put("numofpost",barManage.getNumofPost(bar.getHostid()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

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