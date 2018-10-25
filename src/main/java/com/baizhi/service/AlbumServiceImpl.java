package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by acer on 2018/10/25.
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Override
    public List<Album> getAll() {
        List list = albumDao.getAll();
        return list;
    }

    @Override
    public void insert(Album album, MultipartFile pic, String path) {
        File file = new File(path+"pic");
        if(!file.exists()){
            file.mkdir();
        }
        //文件名
        String fileName = pic.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(fileName);
        String newName = uuid+"."+extension;
        try{
            pic.transferTo(new File(file,newName));
        }catch (Exception e){
            e.printStackTrace();
        }
        Date date = new Date();
        album.setPublishDate(date);
        album.setCoverImg(newName);
        albumDao.insert(album);
    }
}
