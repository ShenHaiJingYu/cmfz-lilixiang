package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by acer on 2018/10/24.
 */
public interface BannerDao {
    List<Banner> queryAll(@Param("start") int start, @Param("count") int count);
    int queryCount(@Param("start") int start, @Param("count") int count);
    void insertOne(Banner banner);
    void delete(int id);
    void update(Banner banner);
}
