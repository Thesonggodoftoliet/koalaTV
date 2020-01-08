package com.koala.servlet.manage;

import com.koala.entity.user_tb;
import com.koala.service.BarManage;
import com.koala.service.FanManage;
import com.koala.service.UserManage;
import com.koala.service.impl.BarManageImpl;
import com.koala.service.impl.FanManageImpl;
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
  *个人信息获取.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/manage/personalinfo")
public class personalinfo extends HttpServlet {
    public personalinfo() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("personalinfo");
        PrintWriter out = response.getWriter();
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        String token = null;
        int userid = 0;
        int tag = 0;
        // String url = "http://ccnubt.club:8080/koalaTV/imags/";//暂时不用
        String url = "http://47.106.186.164:8080/imgs/";


        try {
            token = jsonObject.getString("token");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        userid = JwtUtils.decodeToken(token);
        BarManage barManage = new BarManageImpl();
        UserManage userManage = new UserManageImpl();
        FanManage fanManage = new FanManageImpl();
        user_tb user = userManage.getUserById(userid);
        List<user_tb> follows = barManage.hostlist(userid);

        token = JwtUtils.createToken(userid);
        try {
            msg.put("token",token);
            msg.put("phone",user.getPhone());
            msg.put("isAudience",user.getIsAudience());
            msg.put("isAdmin",user.getIsAdmin());
            msg.put("isYoutuber",user.getIsYoutuber());
            msg.put("isBarhost",user.getIsBarhost());
            msg.put("nickname",user.getNickname());
            msg.put("icon",url+user.getIcon());
            msg.put("gender",user.getGender());
            if (user.getIsYoutuber() == 1)
                msg.put("numoffan",fanManage.getNumOfFan(userid));
            else
                msg.put("numoffan",0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (follows == null) {
            tag = -1;
            try {
                msg.put("follows"," ");
                msg.put("numoffollow",0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else {
            tag = 1;
            JSONArray follow = new JSONArray();
            user_tb temp;
            for (int i=0;i<follows.size();i++){
                temp = follows.get(i);
                JSONObject object = new JSONObject();
                try {
                    object.put("username",temp.getNickname());
                    object.put("gender",temp.getGender());
                    object.put("userpic",url+temp.getIcon());
                    object.put("numoffans",fanManage.getNumOfFan(temp.getUserid()));
                    follow.put(object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            try {
                msg.put("numoffollow",follows.size());
                msg.put("follows",follow);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        try {
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