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
/**
  *删除回复.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/bar/deletereply")
public class deletereply extends HttpServlet {
    public deletereply() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deletereply");
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        PrintWriter out =response.getWriter();
        String token = null;
        post_ post = new post_();

        try {
            token = jsonObject.getString("token");
            post.setHostid(jsonObject.getInt("hostid"));
            post.setPostid(jsonObject.getInt("postid"));
            post.setBarid(jsonObject.getInt("barid"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        int userid = JwtUtils.decodeToken(token);
        BarManage barManage = new BarManageImpl();
        int tag = barManage.deleteReply(userid,post);
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