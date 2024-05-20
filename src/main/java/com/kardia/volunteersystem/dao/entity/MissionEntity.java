package com.kardia.volunteersystem.dao.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class MissionEntity extends FileEntity {
    private String id;
    //一项任务的id
    private String name;
    //任务名
    private int type;
    //任务类型,1背诵，2做题目，3写作
    private String description;
    //任务描述
    private int missionScore;
    //任务满分
    private String missionCreator;
    //任务创建者的id
    private Date startDate;
    //任务开始时间
    private Date endDate;
    //任务结束时间

    private String[] fileAddressArray;
    //存放该任务内容文件绝对路径的数组

    public String[] getFileAddressArray() {
        return fileAddressArray;
    }

    public void setFileAddressArray(String[] fileAddressArray) {
        this.fileAddressArray = fileAddressArray;
    }

    public MissionEntity() {
        this.id = "missionid";
        this.name = "missionname";
        this.type = 0;
        this.description = "missiondescription";
        this.missionScore = 0;
        this.missionCreator = "missioncreator";
        this.startDate = new Date();
        this.endDate = new Date();
        this.fileAddressArray = null;
    }

    public MissionEntity(String id, String name, int type, String description, int missionScore,
                         String missionCreator, Date startDate, Date endDate, String[] fileAddressArray) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.missionScore = missionScore;
        this.missionCreator = missionCreator;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fileAddressArray = fileAddressArray;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getMissionScore() {
        return missionScore;
    }

    public String getMissionCreator() {
        return missionCreator;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMissionScore(int missionScore) {
        this.missionScore = missionScore;
    }

    public void setMissionCreator(String missionCreator) {
        this.missionCreator = missionCreator;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "MissionEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", missionScore=" + missionScore +
                ", missionCreator='" + missionCreator + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", fileAddressArray=" + Arrays.toString(fileAddressArray) +
                '}';
    }
}
