package com.koala.service.impl;

import com.jieba.JiebaSegmenter;
import com.koala.dao.BarDao;
import com.koala.dao.Bar_Dao;
import com.koala.dao.Implement.BarDaoImpl;
import com.koala.dao.Implement.Bar_DaoImpl;
import com.koala.dao.Implement.Post_DaoImpl;
import com.koala.dao.Implement.UserDaoImpl;
import com.koala.dao.Post_Dao;
import com.koala.dao.UserDao;
import com.koala.entity.bar_;
import com.koala.entity.bar_tb;
import com.koala.entity.post_;
import com.koala.entity.user_tb;
import com.koala.service.BarManage;
import com.koala.utils.PraseUtils;
import com.koala.utils.SearchUtils;
import com.koala.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 对话圈进行管理.
 * @author Marting.Lee
 * 2019/12/29
 */
public class BarManageImpl implements BarManage {
    private BarDao barDao = new BarDaoImpl();
    private Bar_Dao bar_dao = new Bar_DaoImpl();
    /**
      *增加话圈.
      * @param bar com.koala.entity.bar_tb
      * @return int
      **/
    @Override
    public int addBar(bar_tb bar) {
        bar.setAdminid(bar.getHostid());
        if (barDao.addBar(bar) != null)
            return 1;
        else
            return 0;
    }

    /**
      *获取关注的主播.
      * @param userid int
      * @return java.util.List(com.koala.entity.user_tb)
      **/
    @Override
    public List<user_tb> hostlist(int userid) {
        UserDao userDao = new UserDaoImpl();
        user_tb user = userDao.getUserById(userid);
        List<Integer> idlist = PraseUtils.sToi(user.getFollow());
        List<user_tb> temp = new ArrayList<>();
        if (idlist == null)
            return null;//没有关注
        else {
            for (int i = 0;i<idlist.size();i++)
                temp.add(userDao.getUserById(idlist.get(i)));
            return temp;
        }
    }

    /**
      *根据关键词，获取相关的微博.
      * @param userid int
     * @param keyword String
      * @return java.util.List(com.koala.entity.bar_)
      **/
    @Override
    public List<bar_> barlist(int userid,String keyword) {
        UserDao userDao = new UserDaoImpl();
        List<Integer> hostid = PraseUtils.sToi(userDao.getUserById(userid).getFollow());
        List<bar_> postList = new ArrayList<>();

        //获取所有的帖子，现在数量较少可以使用这种办法
        for (int i=0;i<hostid.size();i++){
            List<bar_> temp = bar_dao.getAllPost(hostid.get(i));
            if (temp!=null)
                postList.addAll(temp);
        }

        if (postList.isEmpty())
            return null;
        else
            return SearchUtils.getList(keyword,postList);
    }

    /**
      *修改帖子内容.
      * @param userid int
     * @param bar com.koala.entity.bar_
      * @return int
      **/
    @Override
    public int modifyPost(int userid, bar_ bar) {
        bar_ sqlbar= bar_dao.getPostById(bar);
        if (sqlbar.getUserid() != userid)
            return -1;//没有权限
        else {
            if (bar.getContent()!=null && !sqlbar.getContent().equals(bar.getContent()))
                sqlbar.setContent(bar.getContent());
            if (bar.getPic()!=null && !sqlbar.getPic().equals(bar.getPic()))
                sqlbar.setPic(bar.getPic());
            sqlbar.setLastreplytime(TimeUtils.dateToStr());

            if (bar_dao.updatePost(sqlbar))
                return 1;
        }
        return 0;
    }

    /**
      *修改回复内容.
      * @param userid int
     * @param post com.koala.entity.post_
      * @return int
      **/
    @Override
    public int modifyReply(int userid, post_ post) {
        Post_Dao post_dao = new Post_DaoImpl();
        bar_ tmep = new bar_();
        tmep.setBarid(post.getBarid());
        tmep.setHostid(post.getHostid());
        //bar_ sqlbar = bar_dao.getPostById(tmep);
        post_ sqlpost = post_dao.getReplyById(post);
        if (sqlpost.getUserid()!=userid)
            return -1;
        else {
            if (post.getContent() != null && !sqlpost.getContent().equals(post.getContent()))
                sqlpost.setContent(post.getContent());
            sqlpost.setPosttime(TimeUtils.dateToStr());
            //sqlbar.setLastreplytime(sqlpost.getPosttime());

            if (post_dao.updateReply(sqlpost))
                return 1;
        }
        return 0;
    }

    /**
      *联动删帖.
      * @param userid int
     * @param bar com.koala.entity.bar_
      * @return int
      **/
    @Override
    public int deletePost(int userid, bar_ bar) {
        UserDao userDao = new UserDaoImpl();
        user_tb user = userDao.getUserById(userid);
        bar_ sqlbar = bar_dao.getPostById(bar);
        if (user.getIsBarhost() == 0 && sqlbar.getUserid()!=userid){//不是话圈主持人,也不是发帖人
            return -1;//没有权限
        }
        else if (user.getIsBarhost() == 1 && sqlbar.getUserid()!=userid){//是话圈主持人，但不是发帖人
            bar_tb bar_t = barDao.getBarByHostId(bar.getHostid());
            if (bar_t.getAdminid() == userid) {//是这个话圈的主持

            }
            else
                return -1;//没有权限
        }
        else{

        }

        Post_Dao post_dao = new Post_DaoImpl();
        if (post_dao.deletePost(sqlbar))
                return 1;
        return 0;
    }

    /**
      *删除某一个回复.
      * @param userid int
     * @param post com.koala.entity.post_
      * @return int
      **/
    @Override
    public int deleteReply(int userid, post_ post) {
        UserDao userDao = new UserDaoImpl();
        user_tb user = userDao.getUserById(userid);
        Post_Dao post_dao = new Post_DaoImpl();
        post_ sqlpost = post_dao.getReplyById(post);
        if (user.getIsBarhost() == 0 && sqlpost.getUserid()!=userid)
            return -1;
        else if (user.getIsBarhost() == 1 && sqlpost.getUserid()!= userid){
            bar_tb barTb = barDao.getBarByHostId(post.getHostid());
            if (barTb.getAdminid() == userid){

            }else
                return -1;
        }
        else {

        }
        if (post_dao.deleteReply(sqlpost))
            return 1;
        return 0;
    }

    /**
      *更换话圈主持人.
      * @param userid int
     * @param admin int
      * @return int
      **/
    @Override
    public int changeAdmin(int userid, int admin) {
        bar_tb sqlbar = barDao.getBarByHostId(userid);
        if (sqlbar == null)
            return -1;
        else {
            sqlbar.setAdminid(admin);
            if (barDao.updateBarByHostId(sqlbar))
                return 1;
        }
        return 0;
    }
}
