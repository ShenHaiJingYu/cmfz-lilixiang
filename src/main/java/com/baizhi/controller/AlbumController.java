package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by acer on 2018/10/25.
 */
@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("/getAll")
    @ResponseBody
    public List getAll(){
        List<Album> list= albumService.getAll();
        return list;
    }
    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(Album album, MultipartFile pic, HttpServletRequest request){
        try{
            albumService.insert(album,pic,request.getSession().getServletContext().getRealPath("/"));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
