package com.koala.service.impl;

import com.koala.dao.Bar_Dao;
import com.koala.dao.Implement.Bar_DaoImpl;
import com.koala.dao.Implement.UserDaoImpl;
import com.koala.dao.UserDao;
import com.koala.entity.bar_;
import com.koala.entity.post_;
import com.koala.entity.user_tb;
import com.koala.service.PostGet;
import com.koala.utils.PraseUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取话圈消息.
 * @author Marting.Lee
 * 2019/12/29
 */
public class PostGetImpl implements PostGet {
    Bar_Dao bar_dao = new Bar_DaoImpl();
    UserDao userDao = new UserDaoImpl();
    @Override
    public List<bar_> getPost(user_tb user) {
        user_tb sqluser = userDao.getUserById(user.getUserid());
        List<Integer> hostid = PraseUtils.sToi(sqluser.getFollow());
        List<bar_> totbar = new ArrayList<>();
        if (hostid == null || hostid.isEmpty())//没有关注的人
            return null;
        int size = hostid.size();//关注的主播数量
        int count = 0;
        for(int i = 0;i<size;i++)
            count+= bar_dao.getNumOfPost(hostid.get(i));

        if (count<=10) {//关注的主播帖子总数小于10
            for (int i =0;i<size;i++) {
                List<bar_> temp;
                temp = bar_dao.getLatestPosts(hostid.get(i), bar_dao.getNumOfPost(hostid.get(i)));
                totbar.addAll(temp);
            }
        }
        else {
            List<Integer> counts = new ArrayList<>();
            for (int j=0;j<size;j++)
                counts.add(0);
            for (int i = 0; i < 10; i++) {
                System.out.println(counts.get(i%size)+","+i);
                bar_ bar = bar_dao.getLatestPost(hostid.get(i % size), counts.get(i % size));
                if (bar == null) {
                    hostid.remove(i);
                    counts.remove(i);
                    size -- ;
                    i--;
                }
                else {
                    System.out.println("barid "+bar.getBarid());
                    totbar.add(bar);
                    int num = counts.get(i % size);
                    System.out.println("修正"+counts.get(i%size)+","+i);
                    counts.set(i%size,num+1);
                }
            }
        }
        return totbar;
    }

    /**
      *获取这个话圈的所有帖子.
      * @param hostid int
      * @return java.util.List(com.koala.entity.bar_)
      **/
    @Override
    public List<bar_> getPostByHost(int hostid) {
        List<bar_> all = bar_dao.getAllPost(hostid);
        return all;
    }
}
