package com.koala.servlet.manage;

import com.koala.entity.user_tb;
import com.koala.service.UserManage;
import com.koala.service.impl.UserManageImpl;
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
  *更换手机.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/manage/changephone")
public class changephone extends HttpServlet {
    public changephone() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("changephone");
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        int tag = 0;
        String token = null;
        String oldcode = null;
        String newcode = null;
        String phone = null;
        PrintWriter out =response.getWriter();

        try {
            token = jsonObject.getString("token");
            phone =jsonObject.getString("phone");
            newcode = jsonObject.getString("newcode");
            oldcode = jsonObject.getString("oldcode");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (JwtUtils.verifyToken(oldcode) == 0)
            tag = -2;
        else if (!newcode.equals(JwtUtils.decodeTokenToS(oldcode)))
            tag = -3;
        else {
            user_tb user = new user_tb();
            user.setUserid(JwtUtils.decodeToken(token));
            user.setPhone(phone);
            UserManage userManage = new UserManageImpl();
            if (userManage.getUser(phone) != null)
                tag = -1;
            if (userManage.modifyKeyInfo(user,1) != 0)
                tag = 1;
            token = JwtUtils.createToken(user.getUserid());
        }

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