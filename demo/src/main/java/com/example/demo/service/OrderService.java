package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public boolean orderInsert(Integer roomId, String startDate, String endDate, int amount, float payment, Integer userId) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startdate = sdf.parse(startDate);
        Date enddate = sdf.parse(endDate);
        Date createDate = new Date();
        return orderMapper.orderInsert(roomId, startdate, enddate, amount, payment, createDate, userId);
    }

    public boolean orderUpdate(Integer roomId, String startDate, String endDate, int amount) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startdate = sdf.parse(startDate);
        Date enddate = sdf.parse(endDate);
        Date createDate = new Date();
        return orderMapper.orderUpdate(roomId, startdate, enddate, amount);
    }

    public Order orderSelect(Integer roomId, String startDate, String endDate, int amount, float payment, Integer userId) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startdate = sdf.parse(startDate);
        Date enddate = sdf.parse(endDate);
        return orderMapper.orderSelect(roomId, startdate, enddate, amount, payment, userId);
    }
}
