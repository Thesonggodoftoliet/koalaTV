package com.koala.servlet.live;

import com.koala.entity.room_tb;
import com.koala.entity.user_tb;
import com.koala.service.FanManage;
import com.koala.service.RoomManage;
import com.koala.service.UserManage;
import com.koala.service.impl.FanManageImpl;
import com.koala.service.impl.RoomManageImpl;
import com.koala.service.impl.UserManageImpl;
import com.koala.utils.JwtUtils;
import com.koala.utils.LiveUtils;
import com.koala.utils.ReciveUtils;
import org.json.JSONArray;
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
  *获取直播间详细信息.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/live/getroom")
public class getroom extends HttpServlet {
    public getroom() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getroom");
        JSONObject jsonObject = ReciveUtils.getObject(request);
        JSONObject msg = new JSONObject();
        PrintWriter out = response.getWriter();
        int tag = 0;
        int roomid = 0;
        String token = null;
        String url = "http://ccnubt.club:8080/imgs/";//暂时不用
        //String url = "http://47.106.186.164:8080/imgs/";

        try {
            token = jsonObject.getString("token");
            roomid = jsonObject.getInt("roomid");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int userid= JwtUtils.decodeToken(token);
        RoomManage roomManage = new RoomManageImpl();
        UserManage userManage = new UserManageImpl();
        FanManage fanManage = new FanManageImpl();
        room_tb room = roomManage.getRoom(roomid);
        user_tb user = userManage.getUserById(room.getHostid());
        token = JwtUtils.createToken(userid);

        try {
            msg.put("roomid",roomid);
            msg.put("hostid",room.getHostid());
            msg.put("title",room.getTitle());
            msg.put("category",room.getCategory());
            msg.put("watch", LiveUtils.getNum(roomid));
            msg.put("rtmpurl","rtmp://play.ccnubt.club/live/"+roomid);
            msg.put("flvurl","rtmp://play.ccnubt.club/live/"+roomid+".flv");
            msg.put("hlsurl","rtmp://play.ccnubt.club/live/"+roomid+".m3u8");
            msg.put("username",user.getNickname());
            msg.put("userpic",url+user.getIcon());
            msg.put("fans",fanManage.getNumOfFan(room.getHostid()));
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