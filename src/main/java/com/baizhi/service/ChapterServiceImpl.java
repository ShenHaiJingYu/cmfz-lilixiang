package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.UUID;

/**
 * Created by acer on 2018/10/25.
 */
@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private AlbumDao albumDao;

    @Override
    public void insert(Chapter chapter, MultipartFile mou, String path) {
        File file = new File(path + "miaoyin");
        double size = mou.getSize();
        if (!file.exists()) {
            file.mkdir();
        }
        //文件名
        String fileName = mou.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(fileName);
        String newName = uuid + "." + extension;
        try {
            mou.transferTo(new File(file, newName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String uid = UUID.randomUUID().toString();
        chapter.setId(uid);
        chapter.setSize(size);
        chapter.setUrl(newName);
        chapter.setDuration("05:00");
        chapterDao.insert(chapter);
        albumDao.updateCount(chapter.getAlbum_id());
    }

}