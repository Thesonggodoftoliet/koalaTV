package com.koala.servlet.bar;

import com.koala.entity.post_;
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

@WebServlet("/api/bar/modifyreply")
public class modifyreply extends HttpServlet {
    public modifyreply() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("modifyreply");
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        String token=null;
        post_ post = new post_();
        PrintWriter out = response.getWriter();

        try {
            token = jsonObject.getString("token");
            post.setBarid(jsonObject.getInt("barid"));
            post.setPostid(jsonObject.getInt("postid"));
            post.setHostid(jsonObject.getInt("hostid"));
            post.setContent(jsonObject.getString("content"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        int userid = JwtUtils.decodeToken(token);
        BarManage barManage = new BarManageImpl();
        int tag = barManage.modifyReply(userid,post);
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