package com.baizhi.dao;

import com.baizhi.entiey.Admin;

/**
 * Created by acer on 2018/10/23.
 */
public interface AdminDao {
    public Admin queryOneByNameAndPassword(Admin admin);
}
