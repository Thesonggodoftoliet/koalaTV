package com.koala.entity;
/*
 * @Author_Marting.Lee
 * @Date_2019/12/26
 * @Description_r_+ 房间号 表示某个房间的权限管理
 * 房间权限管理表
 */

public class r_ {
    private int userid;
    private int limits;// 1 封号 2 禁言 3 普通人 4 房管 5 房主

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getLimits() {
        return limits;
    }

    public void setLimits(int limits) {
        this.limits = limits;
    }
}
