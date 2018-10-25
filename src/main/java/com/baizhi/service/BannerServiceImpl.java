package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by acer on 2018/10/24.
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    @Override
    public List<Banner> queryAll(int start,int count) {
        List<Banner> list = bannerDao.queryAll(start,count);
        return list;
    }

    @Override
    public int queryCount(int start, int count) {
        int i = bannerDao.queryCount(start,count);
        return i;
    }

    @Override
    public void insertOne(Banner banner) {

        bannerDao.insertOne(banner);
    }

    @Override
    public void delete(int id) {
        bannerDao.delete(id);
    }

    @Override
    public void update(Banner banner) {
        bannerDao.update(banner);
    }
}
