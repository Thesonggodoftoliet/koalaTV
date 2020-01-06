package com.koala.servlet.bar;

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

@WebServlet("/api/bar/changeadmin")
public class changeadmin extends HttpServlet {
    public changeadmin() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("changeadmin");
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        PrintWriter out = response.getWriter();
        String token = null;
        int tag =0;
        int userid = 0;
        int adminid = 0;

        try {
            token = jsonObject.getString("token");
            adminid = jsonObject.getInt("adminid");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        userid = JwtUtils.decodeToken(token);
        BarManage barManage = new BarManageImpl();
        tag = barManage.changeAdmin(userid,adminid);
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