package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by acer on 2018/10/23.
 */
@SpringBootApplication
@MapperScan("com.baizhi.dao")
public class Cmfz {
    public static void main(String[] args) {
        SpringApplication.run(Cmfz.class,args);
    }
}
