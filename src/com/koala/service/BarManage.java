package com.koala.service;

import com.koala.entity.bar_tb;

/**
 * 对话圈进行管�?
 * @author Marting.Lee
 * 2019/12/29
 */
public interface BarManage {
    int addBar(bar_tb bar);
    List<user_tb> hostlist(int userid);
    int modifyPost(int userid,bar_ bar);
    int modifyReply(int userid,post_ post);
    int deletePost(int userid,bar_ bar);
    int deleteReply(int userid, post_ post);

}
