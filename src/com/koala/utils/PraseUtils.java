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
}
