package com.koala.servlet.live;

import com.koala.entity.current_live;
import com.koala.entity.room_tb;
import com.koala.service.RoomManage;
import com.koala.service.impl.RoomManageImpl;
import com.koala.utils.JwtUtils;
import com.koala.utils.PraseUtils;
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
import java.util.Calendar;
import java.util.List;

@WebServlet("/api/live/onlive")
public class onlive extends HttpServlet {
    public onlive() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("onlive");
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        PrintWriter out = response.getWriter();
        String token = null;
        current_live currentLive = new current_live();
        int tag = 1;

        try {
            token = jsonObject.getString("token");
            currentLive.setTitle(jsonObject.getString("title"));
            currentLive.setRoomid(JwtUtils.decodeToken(token));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RoomManage roomManage= new RoomManageImpl();
        token = JwtUtils.createToken(currentLive.getRoomid());
        room_tb room  = roomManage.getRoom(currentLive.getRoomid());
        if (room.getIsForbidden() == 1){
            if (roomManage.shutdownRoom(room.getRoomid(),0)) {
                tag = 0;
                try {
                    msg.put("tag", -1);
                    msg.put("token", token);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else {
                tag = 1;
            }
        }

        if (tag == 1) {//如果房间没被封禁
            if (roomManage.onLiving(currentLive.getRoomid(), currentLive.getTitle()) == null) {
                try {
                    msg.put("tag", 0);
                    msg.put("token", token);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                List<String> list = PraseUtils.getKey(roomManage.onLiving(currentLive.getRoomid(), currentLive.getTitle()));
                try {
                    msg.put("token", token);
                    msg.put("tag", 1);
                    msg.put("rtmp", list.get(0));
                    msg.put("secretkey", list.get(1));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }

        out.print(msg);
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}