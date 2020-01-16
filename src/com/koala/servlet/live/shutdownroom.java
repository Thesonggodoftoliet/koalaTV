package com.koala.servlet.live;

import com.koala.service.RoomManage;
import com.koala.service.impl.RoomManageImpl;
import com.koala.utils.JwtUtils;
import com.koala.utils.LiveUtils;
import com.koala.utils.ReciveUtils;
import com.koala.utils.TimeUtils;
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
        int time = Integer.parseInt(request.getParameter("time"));
        int roomid = Integer.parseInt(request.getParameter("roomid"));
        String reason = request.getParameter("reason");
        int tag = 0;

        Date now = new Date();
        RoomManage roomManage = new RoomManageImpl();

        System.out.println("reason "+reason+"  o(*￣︶￣*)o"+request.getParameter("reason"));

        if (reason.equals("a"))
            reason = "作弊";
        else if (reason.equals("b"))
            reason = "辱骂/仇恨言论";
        else if (reason.equals("c"))
            reason = "挂机";
        else if (reason.equals("d"))
            reason = "不恰当昵称或标题";
        else
            reason = "其他";

        if (roomManage.shutdownRoom(roomid,now.getTime()+time*24*60*60*1000,reason)){
            LiveUtils.forbidRoom(roomid, TimeUtils.dateToStrD(time));
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