package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by acer on 2018/10/24.
 */
@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public Map queryAll(int page, int rows) {
        Map map = null;
        try{
            map = bannerService.queryAll(page,rows);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public boolean insertOne(Banner banner, MultipartFile pic, HttpServletRequest request) {
        try {
            bannerService.insertOne(banner,pic,request.getSession().getServletContext().getRealPath("/"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(int id) {
        try {
            bannerService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean update(Banner banner) {
        try {
            bannerService.update(banner);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
