package com.koala.servlet.bar;

import com.koala.entity.post_;
import com.koala.service.ReplyPost;
import com.koala.service.impl.ReplyPostImpl;
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
  *发表回复.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/bar/deployreply")
public class deployreply extends HttpServlet {
    public deployreply() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deployreply");
        PrintWriter out = response.getWriter();
        String token = null;
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        int tag = 0;
        post_ post = new post_();

        try {
            token = jsonObject.getString("token");
            post.setContent(jsonObject.getString("content"));
            post.setBarid(jsonObject.getInt("barid"));
            post.setHostid(jsonObject.getInt("hostid"));
            post.setUserid(JwtUtils.decodeToken(token));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ReplyPost replyPost = new ReplyPostImpl();
        if (replyPost.postReply(post) == 1)
            tag = 1;
        token = JwtUtils.createToken(post.getUserid());

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