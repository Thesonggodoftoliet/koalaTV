package com.koala.service.impl;

import com.koala.dao.Bar_Dao;
import com.koala.dao.Implement.Bar_DaoImpl;
import com.koala.dao.Implement.Post_DaoImpl;
import com.koala.dao.Post_Dao;
import com.koala.entity.bar_;
import com.koala.entity.post_;
import com.koala.service.ReplyPost;
import com.koala.utils.TimeUtils;

/**
 * 发表回复.
 * @author Marting.Lee
 * 2019/12/30
 */
public class ReplyPostImpl implements ReplyPost {
    private Post_Dao post_dao = new Post_DaoImpl();
    private Bar_Dao bar_dao = new Bar_DaoImpl();

    @Override
    public int postReply(post_ post) {
        post_ sqlpost = post_dao.getLastReply(post.getHostid(),post.getBarid());
        bar_ bar = new bar_();
        bar.setHostid(post.getHostid());
        bar.setBarid(post.getBarid());
        bar_ sqlbar = bar_dao.getPostById(bar);
        sqlbar.setReplynum(sqlbar.getReplynum()+1);
        if (sqlpost == null)
            post.setPostid(1);
        else
            post.setPostid(sqlpost.getPostid()+1);
        post.setPosttime(TimeUtils.dateToStr());
        sqlbar.setLastreplytime(post.getPosttime());

        if (post_dao.addReply(post,sqlbar.getReplynum()+1) == null)
            return 0;
        else
            return 1;
    }
}
