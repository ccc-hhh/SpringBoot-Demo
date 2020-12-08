package com.example.demo.entity;

import java.util.Date;

public class Order {

    private Integer orderId;
    private Integer roomId;
    private Date startDate;
    private Date endDate;
    private int amount;
    private float payment;
    private Date createDate;
    private Integer useId;

    public Order(Integer orderID, Integer roomId, Date startDate, Date endDate, int amount, float payment, Date createDate, Integer userId) {
        this.orderId = orderID;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.payment = payment;
        this.createDate = createDate;
        this.useId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", roomId=" + roomId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", amount=" + amount +
                ", payment=" + payment +
                ", createDate=" + createDate +
                ", useId=" + useId +
                '}';
    }

    public Integer getRoomId() {
        return roomId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public float getPayment() {
        return payment;
    }

    public int getAmount() {
        return amount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getUseId() {
        return useId;
    }
}
