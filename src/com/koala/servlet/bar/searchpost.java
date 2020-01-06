package com.koala.servlet.bar;

import com.koala.entity.bar_;
import com.koala.service.BarManage;
import com.koala.service.UserManage;
import com.koala.service.impl.BarManageImpl;
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

@WebServlet("/api/bar/searchpost")
public class searchpost extends HttpServlet {
    public searchpost() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("searchpost");
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        int tag = 0;
        String token = null;
        PrintWriter out = response.getWriter();
        String keyword = null;
        // String url = "http://ccnubt.club:8080/koalaTV/imags/";//暂时不用
        String url = "http://47.106.186.164:8080/imgs/";

        try {
            keyword = jsonObject.getString("keyword");
            token = jsonObject.getString("token");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int userid = JwtUtils.decodeToken(token);
        List<bar_> barList;
        BarManage barManage = new BarManageImpl();
        barList = barManage.barlist(userid,keyword);
        JSONArray bars = new JSONArray();
        if (barList == null)
            tag = -1;
        else {
            tag = 1;
            UserManage userManage = new UserManageImpl();
            for (int i=0;i<barList.size();i++){
                JSONObject object = new JSONObject();
                try {
                    object.put("hostid",barList.get(i).getHostid());
                    object.put("barid",barList.get(i).getBarid());
                    object.put("title",barList.get(i).getTitle());
                    object.put("replynum",barList.get(i).getReplynum());
                    object.put("lastreplytime",barList.get(i).getLastreplytime());
                    object.put("posttime",barList.get(i).getPosttime());
                    object.put("pic",url+barList.get(i).getPic());
                    object.put("content",barList.get(i).getContent());
                    object.put("username",userManage.getUserById(barList.get(i).getUserid()).getNickname());
                    bars.put(object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        token = JwtUtils.createToken(userid);

        try {
            msg.put("tag",tag);
            msg.put("token",token);
            msg.put("bars",bars);
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