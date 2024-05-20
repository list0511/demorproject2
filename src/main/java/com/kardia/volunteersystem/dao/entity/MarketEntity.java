package com.kardia.volunteersystem.dao.entity;

import jdk.jfr.DataAmount;

import java.io.Serializable;

public class MarketEntity extends FileEntity {

    private String id;
    //一个商品的id
    private String name;
    //商品名
    private String description;
    //商品描述
    private int type;
    //商品类型
    //1是生活用品，2是文具，3是玩具
    private String[] fileAddress;
    //fileAddress用来存储商品文件的绝对路径，是一个长度为1的字符串数组（存一张图片
    private int cost;
    //商品所需积分
    private String updater;
    //上架这个商品的志愿者id

    public MarketEntity(){
        this.id = "marketid";
        this.name = "marketname";
        this.description = "marketdesription";
        this.type = 0;
        this.fileAddress = new String[]{"marketfileaddress"};
        this.cost = 0;
        this.updater = "marketupdater";

    }
    public MarketEntity(String id, String name, String description, int type, String[] fileAddress, int cost, String updater) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.fileAddress = fileAddress;
        this.cost = cost;
        this.updater = updater;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setFileAddress(String[] fileAddress) {
        this.fileAddress = fileAddress;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }

    public String[] getFileAddress() {
        return fileAddress;
    }

    public int getCost() {
        return cost;
    }

    public String getUpdater() {
        return updater;
    }

    @Override
    public String toString() {
        return "MarketEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", fileAddress='" + fileAddress + '\'' +
                ", cost=" + cost +
                ", updater='" + updater + '\'' +
                '}';
    }
}

