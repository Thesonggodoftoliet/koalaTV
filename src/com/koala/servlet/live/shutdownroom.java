package com.koala.servlet.live;

import com.koala.service.RoomManage;
import com.koala.service.impl.RoomManageImpl;
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
import java.util.Date;

@WebServlet("/api/live/shutdownroom")
public class shutdownroom extends HttpServlet {
    public shutdownroom() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("shutdownroom");
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        String token = null;
        PrintWriter out = response.getWriter();
        long time = 0;
        int roomid = 0;
        int tag = 0;

        try {
            token = jsonObject.getString("token");
            time = jsonObject.getInt("time");
            roomid = jsonObject.getInt("roomid");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Date now = new Date();
        RoomManage roomManage = new RoomManageImpl();
        if (roomManage.shutdownRoom(roomid,now.getTime()+time*24*60*60*1000))
            tag = 1;
        token = JwtUtils.createToken(JwtUtils.decodeToken(token));

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