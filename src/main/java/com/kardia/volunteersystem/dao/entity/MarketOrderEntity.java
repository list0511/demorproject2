package com.kardia.volunteersystem.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class MarketOrderEntity implements Serializable {

    private String id;
    //一条订单的id
    private String orderMarketId;
    //订单对应的商品id
    private String volunteerId;
    private String childId;
    //订单对应的孩子id
    private Date time;
    //下单时间
    private int status;
    //订单状态（太好了，这个类没有文件

    public MarketOrderEntity(){
        this.id = "orderid";
        this.orderMarketId = "marketid";
        this.volunteerId = "volunteerid";
        this.childId = "childid";
        this.time = new Date();
        this.status = 0;
    }

    public MarketOrderEntity(String id, String orderMarketId,String volunteerId, String childId, Date time, int status) {
        this.id = id;
        this.orderMarketId = orderMarketId;
        this.volunteerId = volunteerId;
        this.childId = childId;
        this.time = time;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getOrderMarketId() {
        return orderMarketId;
    }

    public String getChildId() {
        return childId;
    }

    public Date getTime() {
        return time;
    }

    public int getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrderMarketId(String orderMarketId) {
        this.orderMarketId = orderMarketId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(String volunteerId) {
        this.volunteerId = volunteerId;
    }

    @Override
    public String toString() {
        return "MarketOrderEntity{" +
                "id='" + id + '\'' +
                ", orderMarketId='" + orderMarketId + '\'' +
                ", volunteerId='" + volunteerId + '\'' +
                ", childId='" + childId + '\'' +
                ", time=" + time +
                ", status=" + status +
                '}';
    }

}
