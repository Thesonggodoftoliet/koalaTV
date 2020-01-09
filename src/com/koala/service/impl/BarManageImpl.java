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
      *获取话圈的具体消息.
      * @param hostid int
      * @return com.koala.entity.bar_tb
      **/
    @Override
    public bar_tb getBar(int hostid) {
        return barDao.getBarByHostId(hostid);
    }

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
        if (idlist == null || idlist.isEmpty())
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

        if (hostid == null || hostid.isEmpty())//没有关注的人
            return null;

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
      *获取用户所管理的话圈.
      * @param userid int
      * @return java.util.List(com.koala.entity.bar_tb)
      **/
    @Override
    public List<bar_tb> managelist(int userid) {
        List<bar_tb> all = barDao.getAllBar();
        List<bar_tb> temp = new ArrayList<>();
        if (all == null)
            return null;
        else {
            for (int i=0;i<all.size();i++)
                if (all.get(i).getAdminid() == userid)
                    temp.add(all.get(i));

                return temp;
        }
    }

    /**
      *修改bar信息.
      * @param bar com.koala.entity.bar_tb
      * @return int
      **/
    @Override
    public int modifyBar(bar_tb bar,int userid) {
        bar_tb sqlbar = barDao.getBarByHostId(bar.getHostid());
        if (sqlbar.getHostid() != userid && sqlbar.getAdminid()!= userid)
            return -1;

        if (!bar.getCoverpic().isEmpty() && !bar.getCoverpic().equals(sqlbar.getCoverpic()))
            sqlbar.setCoverpic(bar.getCoverpic());

        if (!bar.getBarname().isEmpty() && !bar.getBarname().equals(sqlbar.getBarname()))
            sqlbar.setBarname(bar.getBarname());
        if (barDao.updateBarByHostId(sqlbar))
            return 1;
        else
            return 0;
    }

    /**
      *获取发帖总数.
      * @param hostid int
      * @return int
      **/
    @Override
    public int getNumofPost(int hostid) {
        return bar_dao.getNumOfPost(hostid);
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
            if (!bar.getContent().isEmpty() && !sqlbar.getContent().equals(bar.getContent())) {
                System.out.println("修改帖子内容");
                sqlbar.setContent(bar.getContent());
            }
            if (!bar.getPic().isEmpty() && !sqlbar.getPic().equals(bar.getPic()))
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
            if (!post.getContent().isEmpty() && !sqlpost.getContent().equals(post.getContent()))
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
        bar_ temp = new bar_();
        temp.setHostid(post.getHostid());
        temp.setBarid(post.getBarid());
        temp = bar_dao.getPostById(temp);
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
        if (post_dao.deleteReply(sqlpost,temp.getReplynum()-1))
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
        if (sqlbar.getAdminid() == admin)//不用修改
            return -1;

        sqlbar.setAdminid(admin);

        if (barDao.changeAdmin(sqlbar))
                return 1;
        return 0;
    }
}
