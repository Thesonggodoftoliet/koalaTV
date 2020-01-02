package com.koala.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;
import static java.lang.System.in;
import static org.junit.jupiter.api.Assertions.*;

class PraseUtilsTest {

    @Test
    void addStr() {
        String oldstr = "1,1";
        String newstr = "1";
        if (oldstr == null) {
            System.out.println("follow " + newstr);
            exit(0);
        }
        if (oldstr.indexOf('[')!=-1 || oldstr.indexOf(']')!=-1) {
            oldstr.substring(1);
            oldstr.substring(0, oldstr.length() - 1);
        }

        oldstr = oldstr+","+newstr;
        System.out.println("follow "+oldstr);
    }

    @Test
    void sToi() {
        String str = "1,2,3,";
        List list = new ArrayList();
        if (str == null) {
            System.out.println("没有");
            exit(0);
        }
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

        for (int i = 0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}