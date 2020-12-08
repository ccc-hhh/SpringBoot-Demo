package com.example.demo.entity;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Query {

    private Integer roomId;
    private String roomName;
    private Integer hotelId;
    private String hotelName;
    private float avgPrice;
    public Query(Integer roomId, String roomName, Integer hotelId, String hotelName, float avgPrice) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.avgPrice = avgPrice;
    }

    @Override
    public String toString() {
        return "Query{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", avgPrice=" + avgPrice +
                '}';
    }

    public Integer getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public float getAvgPrice() {
        return avgPrice;
    }

}
