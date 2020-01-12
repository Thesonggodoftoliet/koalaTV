package com.koala.servlet.live;

import com.koala.service.RoomManage;
import com.koala.service.impl.RoomManageImpl;
import com.koala.utils.LiveUtils;
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
  *解封房间.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/live/deblockroom")
public class deblockroom extends HttpServlet {
    public deblockroom() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deblockroom");
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        int roomid = 0;
        int tag =0;

        try {
            roomid = jsonObject.getInt("roomid");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RoomManage roomManage = new RoomManageImpl();
        if (roomManage.deblockRoom(roomid)) {
            tag = 1;
            LiveUtils.resumeRoom(roomid);
        }

        try {
            msg.put("tag",tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();

        out.print(tag);
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}