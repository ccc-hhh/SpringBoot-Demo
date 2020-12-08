package com.example.demo.controller;


import com.example.demo.entity.Order;
import com.example.demo.entity.Query;
import com.example.demo.service.OrderService;
import com.example.demo.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/index")
public class IndexController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private QueryService queryService;

    @Autowired
    private OrderService orderService;

    public IndexController(QueryService queryService,OrderService orderService) {
        this.queryService = queryService;
        this.orderService = orderService;
    }

    @GetMapping("/query")
    public List<Query> query(String startDate, String endDate, Integer amount) throws ParseException {
        logger.info("对方查询了" + startDate + "到" + endDate + "间的剩余数大于" + amount + "的房间.");
        return queryService.query(startDate, endDate, amount);
    }

    @GetMapping("/order")
    public Order order(Integer roomId, String startDate, String endDate, int amount, float payment, Integer userId) throws ParseException {
        logger.info("对方预定了" + amount + "间房间类型ID为" + roomId + "的房间");
        if (orderService.orderInsert(roomId, startDate, endDate, amount, payment, userId)) {
            logger.info("插入成功:roomId:"+roomId+",userId:"+userId+",amount:"+amount+",payment:"+payment);
            if (orderService.orderUpdate(roomId, startDate, endDate, amount)) {
                logger.info("更新成功:startDate:"+startDate+",endDate:"+endDate+",amount:"+amount);
                return orderService.orderSelect(roomId, startDate, endDate, amount, payment, userId);
            } else {
                logger.info("更新失败:startDate:"+startDate+",endDate:"+endDate+",amount:"+amount);
                return null;
            }
        }else{
            logger.info("插入失败:roomId:"+roomId+",userId:"+userId+",amount:"+amount+",payment:"+payment);
            return null;
        }
    }


}