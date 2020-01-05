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

@WebServlet("/api/bar/changadmin")
public class changadmin extends HttpServlet {
    public changadmin() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("changadmin");
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        String token = null;
        int admin = 0;
        try {
            token = jsonObject.getString(token);
            admin = jsonObject.getInt("admin");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int userid = JwtUtils.decodeToken(token);
        BarManage barManage = new BarManageImpl();
        int tag = barManage.changeAdmin(userid,admin);
        token = JwtUtils.createToken(userid);

        try {
            msg.put("tag",tag);
            msg.put("token",token);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        out.print(msg);
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}