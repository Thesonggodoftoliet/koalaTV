package com.koala.servlet.manage;

import com.koala.entity.user_tb;
import com.koala.utils.ReciveUtils;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/manage/findpassword")
public class findpassword extends HttpServlet {
    public findpassword() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("findpassword");
        int tag = 0;
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        user_tb user = new user_tb();
        try {
            user.setPhone(jsonObject.getString("phone"));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}