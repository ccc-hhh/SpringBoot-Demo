package com.example.demo.mapper;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    @Insert("insert into `order` set " +
            "order_id=0,room_id=#{roomId},start_date=#{startDate},leave_date=#{endDate}," +
            "amount=#{amount},payment=#{payment},create_date=#{createDate},customer_id=#{userId};")
    boolean orderInsert(Integer roomId, Date startDate, Date endDate, int amount, float payment, Date createDate, Integer userId);

    @Update("update room_info set remain=remain-#{amount} where room_id=#{roomId} and date>=#{startDate} and date<=#{endDate};")
    boolean orderUpdate(Integer roomId, Date startDate, Date endDate, int amount);

    @Select("select order_id,room_id,start_date,leave_date,amount,payment,create_date,customer_id as user_id" +
            " from `order` where room_id=#{roomId} and start_date=#{startDate} and leave_date=#{endDate} and " +
            "amount=#{amount} and payment=#{payment} and customer_id=#{userId};")
    Order orderSelect(Integer roomId, Date startDate, Date endDate, int amount, float payment, Integer userId);

}