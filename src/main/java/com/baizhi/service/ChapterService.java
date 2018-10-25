package com.baizhi.service;

import com.baizhi.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by acer on 2018/10/25.
 */
public interface ChapterService {
    void insert(Chapter chapter, MultipartFile mou, String path);
}
