package com.example.demo.service;


import com.example.demo.entity.Query;
import com.example.demo.mapper.QueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class QueryService {

    @Autowired
    private QueryMapper queryMapper;

    public QueryService(QueryMapper queryMapper) {
        this.queryMapper = queryMapper;
    }

    public List<Query> query(String startDate, String endDate, int amount) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startdate = sdf.parse(startDate);
        Date enddate = sdf.parse(endDate);
        return queryMapper.query(startdate, enddate, amount);
    }
}
