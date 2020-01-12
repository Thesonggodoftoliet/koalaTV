package com.koala.servlet.bar;

import com.koala.entity.bar_;
import com.koala.service.PostGet;
import com.koala.service.UserManage;
import com.koala.service.impl.PostGetImpl;
import com.koala.service.impl.UserManageImpl;
import com.koala.utils.JwtUtils;
import com.koala.utils.ReciveUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
/**
  *获取某个话圈的全部帖子.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/bar/getallbar")
public class getallbar extends HttpServlet {
    public getallbar() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getallbar");
        JSONObject msg  = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        PrintWriter out = response.getWriter();
        int hostid = 0;
        String token = null;
        try {
            token =jsonObject.getString("token");
            hostid = jsonObject.getInt("hostid");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int tag = 0;
        int userid = JwtUtils.decodeToken(token);
        PostGet postGet = new PostGetImpl();
        UserManage userManage = new UserManageImpl();
        List<bar_> all = postGet.getPostByHost(hostid);
        JSONArray post = new JSONArray();
        bar_ bar ;
        if (all == null)
            tag = -1;
        else {
            tag = 1;
            for (int i=0;i<all.size();i++){
                bar = all.get(i);
                JSONObject object = new JSONObject();
                try {
                    object.put("hostid",bar.getHostid());
                    object.put("barid",bar.getBarid());
                    object.put("title",bar.getTitle());
                    object.put("username",userManage.getUserById(bar.getUserid()).getNickname());
                    object.put("userpic","http://ccnubt.club:8080/imgs/"+userManage.getUserById(bar.getUserid()).getIcon());
                    object.put("posttime",bar.getPosttime());
                    object.put("content",bar.getContent());
                    object.put("pic","http://ccnubt.club:8080/imgs/"+bar.getPic());
                    object.put("replynum",bar.getReplynum());
                    object.put("latesttime",bar.getLastreplytime());
                    post.put(object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }

        token = JwtUtils.createToken(userid);
        try {
            msg.put("tag",tag);
            msg.put("token",token);
            msg.put("post",post);
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