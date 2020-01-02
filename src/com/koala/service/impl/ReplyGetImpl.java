package com.koala.service.impl;

import com.koala.dao.Implement.Post_DaoImpl;
import com.koala.dao.Post_Dao;
import com.koala.entity.post_;
import com.koala.service.ReplyGet;

import java.util.List;

/**
 * 获取回复.
 * @author Marting.Lee
 * 2019/12/30
 */
public class ReplyGetImpl implements ReplyGet {
    private Post_Dao post_dao = new Post_DaoImpl();
    @Override
    public List<post_> getReplies(int hostid, int barid) {
        return post_dao.getAllReply(hostid,barid);
    }
}
