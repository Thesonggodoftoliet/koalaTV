package com.koala.dao.Implement;

import com.koala.dao.Current_liveDao;
import com.koala.entity.current_live;
import com.koala.utils.JdbcUtils;

/**
 * 对正在直播的房间进行管理.
 * @author Marting.Lee
 * 2019/12/27
 */

public class Current_liveDaoImpl implements Current_liveDao {

    /**
      *获取某个直播密匙.
      * @param roomid int
      * @return com.koala.entity.current_live
      **/
    @Override
    public current_live getLiveById(int roomid) {
        String sql = "select * from current_live where roomid=?";
        return (current_live) JdbcUtils.getObjectById(current_live.class,sql,roomid);
    }

    /**
      *添加本次直播.
      * @param live com.koala.entity.current_live
      * @return com.koala.entity.current_live
      **/
    @Override
    public current_live addLive(current_live live) {
        String sql = "insert into current_live values(?,?,?,?,?)";
        int tag = JdbcUtils.executeSQL(sql,live.getRoomid(),live.getRtmp(),live.getTitle(),live.getSecretkey(),live.getStreamId());
        if (tag == 0)return null;
        else return live;
    }

    /**
      *更新直播信息.
      * @param live com.koala.entity.current_live
      * @return boolean
      **/
    @Override
    public boolean updateLive(current_live live) {
        String sql = "update current_live set rtmp = ?,title =? ,secretkey=?,streamId=? where roomid = ?";
        int tag = JdbcUtils.executeSQL(sql,live.getRtmp(),live.getTitle(),live.getSecretkey(),live.getStreamId(),live.getRoomid());
        if (tag == 0)return false;
        else return true;
    }

    /**
      *删除直播信息.
      * @param roomid int
      * @return boolean
      **/
    @Override
    public boolean deleteLiveById(int roomid) {
        String sql = "delete from current_live where roomid=?";
        int tag = JdbcUtils.executeSQL(sql,roomid);
        if (tag == 0)return false;
        else return true;
    }
}
