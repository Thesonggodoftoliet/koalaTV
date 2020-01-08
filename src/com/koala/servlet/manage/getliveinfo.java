package com.koala.servlet.manage;

import com.koala.service.Tencent;
import com.koala.service.impl.TencentImpl;
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
/**
  *获取直播间的信息.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/manage/getliveinfo")
public class getliveinfo extends HttpServlet {
    public getliveinfo() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getliveinfo");
        Tencent tencent = new TencentImpl();
        JSONObject msg = new JSONObject();
        try {
            JSONObject province = new JSONObject(tencent.getProvince());
            JSONArray provinces = province.getJSONArray("DataInfoList");
            JSONArray provincelist = new JSONArray();
            for (int i=0;i<provinces.length();i++){
                JSONObject object = new JSONObject();
                province = provinces.getJSONObject(i);
                object.put(province.getString("ProvinceName"),province.getJSONArray("DetailInfoList").getJSONObject(0).getInt("Online"));
                provincelist.put(object);
            }
            msg.put("provinces",provincelist);
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                msg.put("provinces"," ");
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }

        try {
            JSONObject bandwidth = new JSONObject(tencent.getBandwidth());
            JSONArray bandwidths = bandwidth.getJSONArray("DataInfoList");
            JSONArray bandwidthlists = new JSONArray();
            for (int i = 0;i<bandwidths.length();i++){
                JSONObject object = new JSONObject();
                bandwidth = bandwidths.getJSONObject(i);
                object.put(bandwidth.getString("Time"),bandwidth.getDouble("Bandwidth"));
                bandwidthlists.put(object);
            }
            msg.put("bandwidths",bandwidthlists);
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                msg.put("bandwidths"," ");
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }

        try {
            JSONObject people = new JSONObject(tencent.getOnline());
            msg.put("num",people.getInt("TotalOnline"));
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                msg.put("num",0);
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }

        PrintWriter out = response.getWriter();
        out.print(msg);
        out.flush();
        out.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}