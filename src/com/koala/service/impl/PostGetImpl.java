package com.koala.service.impl;

import com.koala.dao.Bar_Dao;
import com.koala.dao.Implement.Bar_DaoImpl;
import com.koala.dao.Implement.UserDaoImpl;
import com.koala.dao.UserDao;
import com.koala.entity.bar_;
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
            for (int i = 0; i < 10; i++)
                totbar.add(bar_dao.getLatestPost(hostid.get(i % size), i / size));
        }
        return totbar;
    }
}
