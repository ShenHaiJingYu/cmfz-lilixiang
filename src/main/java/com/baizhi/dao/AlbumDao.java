package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by acer on 2018/10/25.
 */
public interface AlbumDao {
    List<Album> getAll();
    void insert(Album album);
    void updateCount(int id);
}
