package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

/**
 * Created by acer on 2018/10/24.
 */
public interface BannerService {
    List<Banner> queryAll(int start,int count);
    int queryCount(int start, int count);
    void insertOne(Banner banner);
    void delete(int id);
    void update(Banner banner);
}
