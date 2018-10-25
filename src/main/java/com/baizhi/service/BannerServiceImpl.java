package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

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
    public void insertOne(Banner banner, MultipartFile pic,String path) {
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
        banner.setUrl(newName);
        banner.setCreatDate(date);
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
