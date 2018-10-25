package com.baizhi.service;

import com.baizhi.entity.Album;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by acer on 2018/10/25.
 */
public interface AlbumService {
    List<Album> getAll();
    void insert(Album album, MultipartFile pic, String path);
}
