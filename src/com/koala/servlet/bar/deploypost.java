package com.koala.servlet.bar;

import com.koala.entity.user_tb;
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

@WebServlet("/api/bar/deploypost")
public class deploypost extends HttpServlet {
    public deploypost() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deploypost");
        int tag = 0;
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        user_tb user = new user_tb();

        try {
            String token = jsonObject.getString("token");
            user.setUserid(JwtUtils.decodeToken(token));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}