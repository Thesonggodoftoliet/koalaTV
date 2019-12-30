package com.koala.servlet.auth;

import com.koala.utils.JwtUtils;
import com.koala.utils.MessageUtils;
import com.koala.utils.ReciveUtils;
import com.mysql.cj.protocol.Message;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/auth/identify")
public class identify extends HttpServlet {
    public identify() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("identify");
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        PrintWriter out = response.getWriter();
        String phone= null;
        int tag = 0;
        String token = null;
        try {
            phone = jsonObject.getString("phone");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (phone == null)
            tag = -1;
        else {
            tag = 1;
            String code = MessageUtils.generateCode();
            MessageUtils.Send(code,phone);
            token = JwtUtils.createToken(code);
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