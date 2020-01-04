package com.koala.servlet.bar;

import com.koala.entity.post_;
import com.koala.entity.user_tb;
import com.koala.service.ReplyGet;
import com.koala.service.UserManage;
import com.koala.service.impl.ReplyGetImpl;
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

@WebServlet("/api/bar/getreplies")
public class getreplies extends HttpServlet {
    public getreplies() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getreplies");
        PrintWriter out  = response.getWriter();
        JSONObject msg= new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        String token = null;
        // String url = "http://ccnubt.club:8080/koalaTV/imags/";//暂时不用
        String url = "http://47.106.186.164:8080/koalaTV/imgs/";

        int tag = 0;
        int hostid= 0;
        int barid = 0;
        try {
            token = jsonObject.getString("token");
            hostid = jsonObject.getInt("hostid");
            barid = jsonObject.getInt("barid");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ReplyGet replyGet = new ReplyGetImpl();
        UserManage userManage = new UserManageImpl();
        List<post_> postList = replyGet.getReplies(hostid,barid);
        JSONArray posts = new JSONArray();
        if (postList == null)
            tag = -1;
        else {
            tag = 1;
            for (int i = 0;i<postList.size();i++){
                user_tb temp = userManage.getUserById(postList.get(i).getUserid());
                JSONObject object = new JSONObject();
                try {
                    object.put("username",temp.getNickname());
                    object.put("hostid",postList.get(i).getHostid());
                    object.put("barid",postList.get(i).getBarid());
                    object.put("postid",postList.get(i).getPostid());
                    object.put("posttime",postList.get(i).getPosttime());
                    object.put("content",postList.get(i).getContent());
                    object.put("userpic",url+temp.getIcon());
                    posts.put(object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            msg.put("tag",tag);
            msg.put("reply",posts);
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