package com.koala.utils;

import org.apache.commons.collections.Buffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
  *将接收的数据规范为JSON对象或数组.
  *@author Marting.Lee
  *date 2019/12/27
  **/
public class ReciveUtils {
    /**
      *将字节流转换为JSON对象.
      * @param request HttpServletRequest
      * @return org.json.JSONObject
      **/
    public static JSONObject getObject(HttpServletRequest request)throws IOException {
        InputStream js = request.getInputStream();
        InputStreamReader jsr = new InputStreamReader(js);
        BufferedReader br = new BufferedReader(jsr);

        String json = br.readLine();
        System.out.println("有东西吗"+json);

        JSONObject Obj = null;

        try{
            Obj = new JSONObject(json);
        }catch (JSONException e){
            e.printStackTrace();
        }

        return Obj;
    }

    /**
      *将字节流转换为JSON对象数组，key为数组名字.
      * @param request HttpServletRequest
     * @param key String
      * @return org.json.JSONArray
      **/
    public static JSONArray getArray(HttpServletRequest request,String key)throws IOException,JSONException{
        InputStream js =request.getInputStream();
        InputStreamReader jsr = new InputStreamReader(js);
        BufferedReader br = new BufferedReader(jsr);
        String json = br.readLine();

        System.out.println("Array"+json);

        JSONObject jsonObject;
        jsonObject = new JSONObject(json);

        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return jsonArray;
    }
}
