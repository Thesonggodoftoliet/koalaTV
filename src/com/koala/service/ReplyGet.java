package com.koala.service;

import com.koala.entity.post_;

import java.util.List;

/**
 * 对回复消息的获取.
 * @author Marting.Lee
 * 2019/12/28
 */
public interface ReplyGet {
    List<post_> getReplies(int hostid,int barid);
}
