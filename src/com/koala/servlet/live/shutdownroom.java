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
/**
  *封禁直播间.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/live/shutdownroom")
public class shutdownroom extends HttpServlet {
    public shutdownroom() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("shutdownroom");
        JSONObject msg = new JSONObject();
        PrintWriter out = response.getWriter();
        long time = Long.parseLong(request.getParameter("time"));
        int roomid = Integer.parseInt(request.getParameter("roomid"));
        String reason = request.getParameter("reson");
        int tag = 0;

        Date now = new Date();
        RoomManage roomManage = new RoomManageImpl();
        if (roomManage.shutdownRoom(roomid,now.getTime()+time*24*60*60*1000,reason))
            tag = 1;

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