package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by acer on 2018/10/23.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;
    @Override
    public Admin login(Admin admin) {
        return adminDao.queryOneByNameAndPassword(admin);
    }
}
