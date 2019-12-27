package com.koala.dao;

import com.koala.entity.current_live;

/**
 * 对正在直播的房间进行管理.
 * @author Marting.Lee
 * 2019/12/27
 */
public interface Current_liveDao {
    current_live getLiveById(int roomid);
    current_live addLive(current_live live);
    boolean updateLive(current_live live);
    boolean deleteLiveById(int roomid);
}
