package com.koala.service;

import com.koala.entity.bar_;
import com.koala.entity.bar_tb;
import com.koala.entity.post_;
import com.koala.entity.user_tb;

import java.util.List;

/**
 * 对话圈进行管理.
 * @author Marting.Lee
 * 2019/12/29
 */
public interface BarManage {
    bar_tb getBar(int hostid);
    int addBar(bar_tb bar);
    List<user_tb> hostlist(int userid);
    List<bar_> barlist(int userid,String keyword);
    List<bar_tb> managelist(int userid);
    int modifyBar(bar_tb bar,int userid);
    int getNumofPost(int hostid);
    int modifyPost(int userid,bar_ bar);
    int modifyReply(int userid,post_ post);
    int deletePost(int userid,bar_ bar);
    int deleteReply(int userid, post_ post);
    int changeAdmin(int userid,int admin);
}
