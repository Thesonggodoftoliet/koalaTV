package com.koala.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.lang.System.exit;
import static java.lang.System.in;
import static org.junit.jupiter.api.Assertions.*;

class PraseUtilsTest {

    @Test
    void addStr() {
        String oldstr = "1,2,3,4,5,6,";
        int tag = oldstr.indexOf(""+5);
        if (tag == 0)
            oldstr=oldstr.substring(2);
        else if (tag == oldstr.length()-2)
            oldstr=oldstr.substring(0,oldstr.length()-2);
        else {
            String begin = oldstr.substring(0,tag);
            String end = oldstr.substring(tag+2);
            oldstr = begin+end;
        }
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