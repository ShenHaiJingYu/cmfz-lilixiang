package com.baizhi.service;

import com.baizhi.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by acer on 2018/10/24.
 */
public interface BannerService {
    Map queryAll(int page, int rows);
    int queryCount(int start, int count);
    void insertOne(Banner banner, MultipartFile pic,String path);
    void delete(int id);
    void update(Banner banner);
}
