package com.example.demo.mapper;

import com.example.demo.entity.Query;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface QueryMapper {

    @Select("select RI.room_id,RT.room_name,H.hotel_id,H.hotel_name,avg(RI.price) as avgPrice " +
            "from room_info RI,room_type RT,hotel H " +
            "where H.hotel_id=RT.hotel_id and RI.room_id=RT.room_id and (RI.room_id,RT.room_id) in " +
            "(select room_id,room_id from room_info group by room_id " +
            "having min(date)<=#{startDate} and max(date)>=#{endDate} and count(date)>#{endDate}-#{startDate} and min(remain)>=#{num}) " +
            "group by RI.room_id;")
    List<Query> query(Date startDate, Date endDate, int num);

}