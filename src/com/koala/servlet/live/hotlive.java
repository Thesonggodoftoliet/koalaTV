package com.koala.servlet.live;

import com.koala.entity.current_live;
import com.koala.entity.room_tb;
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
import java.util.List;

/**
  *获取最火的直播间.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/live/hotlive")
public class hotlive extends HttpServlet {
    public hotlive() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hotlive");
        JSONObject msg = new JSONObject();
        PrintWriter out  = response.getWriter();
        int tag = 0;

        RoomManage roomManage = new RoomManageImpl();
        UserManage userManage = new UserManageImpl();
        List<room_tb> all = roomManage.getRoomsOnlive();
        FanManage fanManage = new FanManageImpl();
        JSONArray rooms = new JSONArray();
        room_tb temp;
        if (all.isEmpty()){
            tag = -1;
        }else{
            tag = 1;
            for (int i=0;i<all.size();i++){
                temp = all.get(i);
                JSONObject object = new JSONObject();
                try {
                    object.put("category",temp.getCategory());
                    object.put("title",temp.getTitle());
                    object.put("roomid",temp.getRoomid());
                    object.put("watch", LiveUtils.getNum(temp.getRoomid()));
                    object.put("homeid",temp.getHostid());
                    object.put("rtmpurl","rtmp://play.ccnubt.club/live/"+temp.getRoomid());
                    object.put("flvurl","rtmp://play.ccnubt.club/live/"+temp.getRoomid()+".flv");
                    object.put("hlsurl","rtmp://play.ccnubt.club/live/"+temp.getRoomid()+".m3u8");
                    object.put("username",userManage.getUserById(temp.getHostid()).getNickname());
                    object.put("userpic","http://ccnubt.club:8080/imgs/"+userManage.getUserById(temp.getHostid()).getIcon());
                    object.put("fans",fanManage.getNumOfFan(temp.getHostid()));
                    rooms.put(object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }


        try {
            msg.put("tag",tag);
            msg.put("rooms",rooms);
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