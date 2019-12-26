package com.koala.utils;
/*
 * @Author_Marting.Lee
 * @Date_2019/12/26
 * @Description_PraseUtils
 */

import java.util.ArrayList;
import java.util.List;

public class PraseUtils {
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
