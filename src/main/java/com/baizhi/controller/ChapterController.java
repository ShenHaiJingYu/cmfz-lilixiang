package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by acer on 2018/10/25.
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(Chapter chapter, MultipartFile mou, HttpServletRequest request){
        System.out.println(mou);
        try{
            chapterService.insert(chapter,mou,request.getSession().getServletContext().getRealPath("/"));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
