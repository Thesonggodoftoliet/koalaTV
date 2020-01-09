package com.koala.servlet.manage;

import com.koala.entity.programmer_tb;
import com.koala.service.UserManage;
import com.koala.service.impl.UserManageImpl;
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

/**
  *验证后台管理员身份.
  *@author Marting.Lee
  *date 2020/1/9
  **/
@WebServlet("/api/manage/verifyadmin")
public class verifyadmin extends HttpServlet {
    public verifyadmin() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("verifyadmin");
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        PrintWriter out = response.getWriter();
        programmer_tb programmerTb = new programmer_tb();

        try {
            programmerTb.setUseraccount(jsonObject.getInt("useraccount"));
            programmerTb.setUserpassword(jsonObject.getString("userpassword"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        UserManage userManage = new UserManageImpl();
        int tag = userManage.checkIdentity(programmerTb);

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