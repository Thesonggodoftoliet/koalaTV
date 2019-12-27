package com.koala.servlet.auth;

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
import java.io.PrintWriter;

@WebServlet("/api/login")
public class login extends HttpServlet {
    public login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login");
        int tag = 0;
        String token = null;
        PrintWriter out = response.getWriter();
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = null;
        user_tb user = new user_tb();
        try {
            jsonObject = ReciveUtils.getObject(request);
            String phone = jsonObject.getString("phone");
            String password = jsonObject.getString("userpassword");
            user.setPhone(phone);
            user.setUserpasswrod(password);
        } catch (JSONException e) {
            e.printStackTrace();
            tag = -2;
        }

        

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}