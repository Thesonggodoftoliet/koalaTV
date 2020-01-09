package com.koala.entity;
/**
  *后台管理员.
  *@author Marting.Lee
  *date 2019/12/26
  **/
public class programmer_tb {
    private int useraccount;
    private String userpassword;

    public int getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(int useraccout) {
        this.useraccount = useraccout;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
