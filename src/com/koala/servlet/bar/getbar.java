package com.koala.servlet.bar;

import com.koala.entity.bar_tb;
import com.koala.service.BarManage;
import com.koala.service.UserManage;
import com.koala.service.impl.BarManageImpl;
import com.koala.service.impl.UserManageImpl;
import com.koala.utils.JwtUtils;
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

@WebServlet("/api/bar/getbar")
public class getbar extends HttpServlet {
    public getbar() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getbar");
        JSONObject msg = new JSONObject();
        JSONObject jsonObject = ReciveUtils.getObject(request);
        PrintWriter out = response.getWriter();
        String token = null;

        try {
            token = jsonObject.getString("token");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int userid = JwtUtils.decodeToken(token);
        token = JwtUtils.createToken(userid);
        BarManage barManage = new BarManageImpl();
        UserManage userManage = new UserManageImpl();
        List<bar_tb> barlist = barManage.managelist(userid);
        int tag = 0;
        if (barlist == null)
            tag =-1;
        else {
            tag = 1;
            JSONArray bars = new JSONArray();
            try {
                for (int i=0;i<barlist.size();i++) {
                    JSONObject object = new JSONObject();
                    object.put("barname", barlist.get(i).getBarname());
                    object.put("hostid", barlist.get(i).getHostid());
                    object.put("hostname", userManage.getUserById(barlist.get(i).getHostid()).getNickname());
                    object.put("adminid", barlist.get(i).getAdminid());
                    object.put("adminname", userManage.getUserById(barlist.get(i).getAdminid()).getNickname());
                    object.put("coverpic", barlist.get(i).getCoverpic());
                    object.put("numofpost", barManage.getNumofPost(barlist.get(i).getHostid()));
                    bars.put(object);
                }
                msg.put("bars",bars);
            } catch (JSONException e) {
                e.printStackTrace();
            }
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