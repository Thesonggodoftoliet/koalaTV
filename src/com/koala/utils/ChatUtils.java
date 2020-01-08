package com.koala.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 聊天室工具类.
 * @author Marting.Lee
 * 2020/1/7
 */
public class ChatUtils {
    private String url="https://console.tim.qq.com";
    private int appid = 1400304245;
    private String key = "97cd89d162bf07de8eb1e2e76c7eb3712d105dc6bf1d0ca406b33d9fde3b2d78";
    private String identifier = "administrator";
    private String add = "&sdkappid=1400304245&identifier=administrator&contenttype=json";

    /**
      *发送请求.
      * @param url String
     * @param obj int
      **/
    public void Send(URL url, JSONObject obj) throws IOException {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            connection.connect();
            //POST请求
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());


            out.write(obj.toString().getBytes("UTF-8"));
            System.out.println("data=" + obj.toString());
            out.flush();
            out.close();
            //读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            System.out.println(sb);
            reader.close();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
      *添加用户.
      * @param userid int
     * @param nickname String
     * @param faceurl String
      **/
    public void addUser(int userid,String nickname,String faceurl) throws JSONException, IOException {
        JSONObject object = new JSONObject();
        object.put("Identifier",userid+"");
        object.put("Nick",nickname);
        //object.put("FaceUrl",faceurl);
        UserSigUtils userSigUtils = new UserSigUtils(appid,key);
        String def = url+"/v4/im_open_login_svc/account_import?&usersig="+userSigUtils.genSig(identifier,30*60*1000)+add;
        URL last = new URL(def);
        Send(last,object);
    }

    /**
      *创建群组.
      * @param hostid int
     * @param roomid int
     * @param hostname String
      **/
    public void addGroup(int hostid,int roomid,String hostname) throws JSONException, IOException {
        JSONObject object = new JSONObject();
        object.put("Owner_Account",hostid+"");
        object.put("Type","ChatRoom");
        object.put("GroupId",roomid+"");
        object.put("Name",hostname);
        UserSigUtils userSigUtils = new UserSigUtils(appid,key);
        String def = url+"/v4/group_open_http_svc/create_group?&usersig="+userSigUtils.genSig(identifier,30*60*1000)+add;
        URL last = new URL(def);
        Send(last,object);
    }
}
