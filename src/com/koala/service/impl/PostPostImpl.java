package com.koala.service.impl;

import com.koala.dao.BarDao;
import com.koala.dao.Bar_Dao;
import com.koala.dao.Implement.BarDaoImpl;
import com.koala.dao.Implement.Bar_DaoImpl;
import com.koala.dao.Implement.Post_DaoImpl;
import com.koala.dao.Post_Dao;
import com.koala.entity.bar_;
import com.koala.entity.bar_tb;
import com.koala.service.PostPost;
import com.koala.utils.TimeUtils;

import java.util.Calendar;

/**
 * 发帖，因为是主要功能，访问频繁，故单独做一个服务.
 * @author Marting.Lee
 * 2019/12/29
 */
public class PostPostImpl implements PostPost {
    private Post_Dao post_dao = new Post_DaoImpl();
    private bar_tb bar_tb = new bar_tb();
    private BarDao barDao = new BarDaoImpl();
    private Bar_Dao bar_dao = new Bar_DaoImpl();

    /**
      *发帖.
      * @param bar com.koala.entity.bar_
      * @return int
      **/
    @Override
    public int postMessage(bar_ bar) {
        bar_tb = barDao.getBarByHostId(bar.getHostid());
        bar.setTitle(bar_tb.getBarname());
        bar.setReplynum(0);
        bar.setPosttime(TimeUtils.dateToStr());
        bar.setLastreplytime(bar.getPosttime());
        bar_ sqlbar = bar_dao.getLastPost(bar.getHostid());
        if (sqlbar == null)
            bar.setBarid(1);
        else
            bar.setBarid(sqlbar.getBarid()+1);
        
        post_dao.createTable(bar.getBarid());
        if (bar_dao.addPost(bar) == null)
            return 0;
        else
            return 1;
    }
}
