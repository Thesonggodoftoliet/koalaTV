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

@WebServlet("/api/manage/findpassword")
public class findpassword extends HttpServlet {
    public findpassword() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("findpassword");
        int tag = 0;
        PrintWriter out =response.getWriter();
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        user_tb user = new user_tb();
        String oldcode = null;
        String newcode = null;
        try {
            user.setPhone(jsonObject.getString("phone"));
            user.setUserpassword(jsonObject.getString("userpassword"));
            oldcode = jsonObject.getString("oldcode");
            newcode = jsonObject.getString("newcode");
        }catch (JSONException e){
            e.printStackTrace();
        }

        if (JwtUtils.verifyToken(oldcode) == 0)
            tag = -2;
        else if (!newcode.equals(JwtUtils.decodeTokenToS(oldcode)))
            tag = -3;
        else {
            UserManage userManage = new UserManageImpl();
            if (userManage.modifyKeyInfo(user,2)!=0)
                tag = 1;
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