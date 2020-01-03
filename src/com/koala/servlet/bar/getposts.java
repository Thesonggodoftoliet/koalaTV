package com.koala.servlet.bar;

import com.koala.entity.bar_;
import com.koala.entity.user_tb;
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

@WebServlet("/api/bar/getposts")
public class getposts extends HttpServlet {
    public getposts() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getposts");
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        JSONArray posts = new JSONArray();
        PrintWriter out = response.getWriter();
        int tag = 0;
        user_tb user = new user_tb();
        String token = null;

       // String url = "http://ccnubt.club:8080/koalaTV/imags/";//暂时不用
        String url = "http://localhost:8080/koalaTV/imags/";

        try {
            token = jsonObject.getString("token");
            user.setUserid(JwtUtils.decodeToken(token));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        PostGet postGet = new PostGetImpl();
        List<bar_> barList = postGet.getPost(user);
        if (barList == null)
            tag = -1;
        else {
            UserManage userManage = new UserManageImpl();
            for (int i = 0; i < barList.size(); i++) {
                JSONObject object = new JSONObject();
                user_tb temp = userManage.getUserById(barList.get(i).getUserid());
                try {
                    object.put("hostid",barList.get(i).getHostid());
                    object.put("barid",barList.get(i).getBarid());
                    object.put("title", barList.get(i).getTitle());
                    object.put("username", temp.getNickname());
                    object.put("posttime", barList.get(i).getPosttime());
                    object.put("content", barList.get(i).getContent());
                    object.put("pic", url+barList.get(i).getPic());
                    object.put("replynum", barList.get(i).getReplynum());
                    object.put("latesttime", barList.get(i).getLastreplytime());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                posts.put(object);
                tag = 1;
            }
        }

        token = JwtUtils.createToken(user.getUserid());

        try {
            msg.put("tag",tag);
            msg.put("token",token);
            msg.put("post",posts);
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