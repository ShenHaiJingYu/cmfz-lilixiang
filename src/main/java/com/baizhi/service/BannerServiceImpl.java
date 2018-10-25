package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2018/10/24.
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    @Override
    public Map queryAll(int page,int rows) {
        int start = (page - 1) * rows;
        int count = page * rows;
        List<Banner> list = bannerDao.queryAll(start, count);
        int total = bannerDao.queryCount(start, count);
        Map map = new HashMap();
        map.put("rows", list);
        map.put("total", total);
        return map;
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
