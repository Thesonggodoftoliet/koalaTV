package com.koala.servlet.bar;

import com.auth0.jwt.JWT;
import com.koala.entity.user_tb;
import com.koala.service.BarManage;
import com.koala.service.FanManage;
import com.koala.service.impl.BarManageImpl;
import com.koala.service.impl.FanManageImpl;
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
  *获取关注的主播信息.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/bar/getfollow")
public class getfollow extends HttpServlet {
    public getfollow() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getfollow");
        PrintWriter out =response.getWriter();
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        int tag = 0;
        String token =null;
        List<user_tb> hostList;
         String url = "http://ccnubt.club:8080/imags/";//暂时不用
        //String url = "http://47.106.186.164:8080/imgs/";

        try {
            token = jsonObject.getString("token");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int userid = JwtUtils.decodeToken(token);
        BarManage barManage = new BarManageImpl();
        FanManage fanManage = new FanManageImpl();
        hostList = barManage.hostlist(userid);
        JSONArray hosts = new JSONArray();
        if (hostList == null)
            tag = -1;
        else {
            tag = 1;
            for (int i =0;i<hostList.size();i++){
                JSONObject object = new JSONObject();
                try {
                    object.put("hostid",hostList.get(i).getUserid());
                    object.put("username",hostList.get(i).getNickname());
                    object.put("hostpic",url+hostList.get(i).getIcon());
                    object.put("numoffan",fanManage.getNumOfFan(hostList.get(i).getUserid()));
                    hosts.put(object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        token = JwtUtils.createToken(userid);

        try {
            msg.put("tag",tag);
            msg.put("hosts",hosts);
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