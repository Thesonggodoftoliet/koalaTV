package com.koala.service;

import com.koala.entity.bar_;
import com.koala.entity.user_tb;

import java.util.List;

/**
 * 对话圈的消息获取.
 * @author Marting.Lee
 * 2019/12/28
 */
public interface PostGet {
    List<bar_> getPost(user_tb user);
    List<bar_> getPostByHost(int hostid);
}
