package com.koala.dao;
/*
 * @Author_Marting.Lee
 * @Date_2019/12/26
 * @Description_ProgrammerDao
 */

import com.koala.entity.programmer_tb;

public interface ProgrammerDao {
    programmer_tb getProgrammerById(int userid);
}
