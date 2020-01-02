package com.koala.servlet.bar;

import com.koala.entity.bar_;
import com.koala.service.PostPost;
import com.koala.service.impl.PostPostImpl;
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

@WebServlet("/api/bar/deploypost")
public class deploypost extends HttpServlet {
    public deploypost() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deploypost");
        PrintWriter out = response.getWriter();
        int tag = 0;
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        int userid = 0;
        bar_ bar = new bar_();
        try {
            String token = jsonObject.getString("token");
            userid = JwtUtils.decodeToken(token);
            bar.setHostid(jsonObject.getInt("hostid"));
            bar.setUserid(userid);
            bar.setContent(jsonObject.getString("content"));
            bar.setPic(jsonObject.getString("pic"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String token = JwtUtils.createToken(userid);
        PostPost postPost = new PostPostImpl();
        if (postPost.postMessage(bar) == 0)
            tag = -1;
        else
            tag = 1;

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