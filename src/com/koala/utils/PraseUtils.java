package com.koala.utils;

import java.util.ArrayList;
import java.util.List;

/**
  *转换工具.
  *@author Marting.Lee
  *date 2019/12/27
  **/
public class PraseUtils {
    /**
      *将String分离成int，比如[9,8] 变成 9 8.
      * @param str String
      * @return java.util.List(java.lang.Integer)
      **/
    public static List<Integer> sToi(String str){
        System.out.println("调用sToi"+str);
        List list = new ArrayList();
        if (str == null)
            return null;
        if (str.indexOf("[")!=-1 || str.indexOf("]")!=-1)
        {
            str = str.substring(1);
            str = str.substring(0,str.length()-1);
        }
        while (!str.isEmpty()) {
            if (str.indexOf(",") != -1) {
                int tag = str.indexOf(",");
                String str1 = str.substring(0, tag);
                str = str.substring(tag);
                System.out.println("new字符串" + str1 + "old 字符串" + str);
                Integer integer = Integer.parseInt(str1);
                System.out.println("id= " + integer);
                list.add(integer);
                str = str.substring(1);
            } else {
                Integer integer = Integer.parseInt(str);
                System.out.println("id= " + integer);
                list.add(integer);
                str=str.substring(1);
            }
        }
        return list;
    }

    /**
      *在字符串后面添加新子串.
      * @param oldstr String
     * @param newstr String
      * @return java.lang.String
      **/
    public static String addStr(String oldstr,String newstr){

        if (oldstr == null)
            return newstr+",";

        if (oldstr.indexOf('[')!=-1 || oldstr.indexOf(']')!=-1) {
            oldstr.substring(1);
            oldstr.substring(0, oldstr.length() - 1);
        }

        oldstr = oldstr+newstr+",";
        System.out.println("follow"+oldstr);
        return oldstr;
    }

    /**
      *分离出rtmp和秘钥.
      * @param key String
      * @return java.util.List(java.lang.String)
      **/
    public static List<String> getKey(String key){
        List<String> msg = new ArrayList<>();
        int tag = key.indexOf(",");
        String str1 = key.substring(0,tag);
        msg.add(str1);
        key = key.substring(tag+1);
        msg.add(key);
        return msg;
    }
}
