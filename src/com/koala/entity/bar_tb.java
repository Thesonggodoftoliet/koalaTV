package com.koala.entity;

/**
  *整个圈子的模型实体，单独一个是某一个.
  *@author Marting.Lee
  *date 2019/12/26
  **/
public class bar_tb {
    private int hostid;//主播id
    private int adminid;//主持人id
    private String barname;//话圈名
    private String coverpic;//封面

    public int getHostid() {
        return hostid;
    }

    public void setHostid(int hostid) {
        this.hostid = hostid;
    }

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public String getBarname() {
        return barname;
    }

    public void setBarname(String barname) {
        this.barname = barname;
    }

    public String getCoverpic() {
        return coverpic;
    }

    public void setCoverpic(String coverpic) {
        this.coverpic = coverpic;
    }
}
