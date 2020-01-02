package com.koala.servlet.bar;

import com.koala.entity.bar_;
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

@WebServlet("/api/bar/modifypost")
public class modifypost extends HttpServlet {
    public modifypost() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("modifypost");
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        int userid = 0;
        String token = null;
        bar_ bar = new bar_();
        PrintWriter out =response.getWriter();

        try {
            token = jsonObject.getString("token");
            bar.setHostid(jsonObject.getInt("hostid"));
            bar.setBarid(jsonObject.getInt("barid"));
            bar.setPic(jsonObject.getString("pic"));
            bar.setContent(jsonObject.getString("content"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        BarManage barManage = new BarManageImpl();
        userid = JwtUtils.decodeToken(token);
        int tag = barManage.modifyPost(userid,bar);
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