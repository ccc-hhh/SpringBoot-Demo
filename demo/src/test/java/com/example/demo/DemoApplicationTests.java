package com.example.demo;

import com.example.demo.controller.IndexController;
import com.example.demo.mapper.QueryMapper;
import com.example.demo.service.QueryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private QueryMapper queryMapper;

    @Autowired
    private QueryService queryService;

    @Autowired
    private IndexController indexController;


    @Test
    void contextLoads() throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = sdf.parse("2020-11-28");
//        Date endDate = sdf.parse("2020-11-30");
//        System.out.println(indexController.query("2020-11-28", "2020-11-30", 4).toString());
    }

}
