package com.kardia.volunteersystem.dao.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class MissionRecordEntity extends FileEntity {

    private String id;
    //一条记录的id
    private String childId;
    //该记录对应的孩子id
    private String volunteerId;
    //该记录对应的志愿者id
    private String missionId;
    //该记录对应的任务id
    private Date childTime;
    //孩子最后一次提交任务的时间
    private Date volunteerTime;
    //志愿者最后一次批改任务的时间
    private String missionContent;
    //孩子提交任务时的文本内容
    private String evaluationContent;
    //志愿者进行批改时的文本内容
    private int status;
    //记录状态（规格说明文档）
    private int score;
    //该记录对应任务的满分
    private int obtainScore;
    //该记录让孩子得了多少分
    private int ifObtain;
    //该记录有没有给孩子加过分
    private String[] misfileAddressArray;
    //存放当前任务记录文件绝对路径的数组

    public String[] getMisfileAddressArray() {
        return misfileAddressArray;
    }

    public void setMisfileAddressArray(String[] misfileAddressArray) {
        this.misfileAddressArray = misfileAddressArray;
    }


    public MissionRecordEntity(){
        this.id = "recordid";
        this.childId = "childid";
        this.volunteerId = "volunteerid";
        this.missionId = "missionid";
        this.childTime = new Date();
        this.volunteerTime = new Date();
        this.missionContent = "missioncontent";
        this.evaluationContent = "evaluationcontent";
        this.status = 0;
        this.score = 0;
        this.obtainScore = 0;
        this.ifObtain = 0;
        this.misfileAddressArray = null;
    }


    public MissionRecordEntity(String id, String childId, String volunteerId, String missionId, Date childTime,
                               Date volunteerTime, String missionContent, String evaluationContent, int status,
                               int score, int obtainScore, int ifObtain, String[] misfileAddressArray) {
        this.id = id;
        this.childId = childId;
        this.volunteerId = volunteerId;
        this.missionId = missionId;
        this.childTime = childTime;
        this.volunteerTime = volunteerTime;
        this.missionContent = missionContent;
        this.evaluationContent = evaluationContent;
        this.status = status;
        this.score = score;
        this.obtainScore = obtainScore;
        this.ifObtain = ifObtain;
        this.misfileAddressArray = misfileAddressArray;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public String getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(String volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public Date getChildTime() {
        return childTime;
    }

    public void setChildTime(Date childTime) {
        this.childTime = childTime;
    }

    public Date getVolunteerTime() {
        return volunteerTime;
    }

    public void setVolunteerTime(Date volunteerTime) {
        this.volunteerTime = volunteerTime;
    }

    public String getMissionContent() {
        return missionContent;
    }

    public void setMissionContent(String missionContent) {
        this.missionContent = missionContent;
    }

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getObtainScore() {
        return obtainScore;
    }

    public void setObtainScore(int obtainScore) {
        this.obtainScore = obtainScore;
    }

    public int getIfObtain() {
        return ifObtain;
    }

    public void setIfObtain(int ifObtain) {
        this.ifObtain = ifObtain;
    }

    @Override
    public String toString() {
        return "MissionRecordEntity{" +
                "id='" + id + '\'' +
                ", childId='" + childId + '\'' +
                ", volunteerId='" + volunteerId + '\'' +
                ", missionId='" + missionId + '\'' +
                ", childTime=" + childTime +
                ", volunteerTime=" + volunteerTime +
                ", missionContent='" + missionContent + '\'' +
                ", evaluationContent='" + evaluationContent + '\'' +
                ", status=" + status +
                ", score=" + score +
                ", obtainScore=" + obtainScore +
                ", ifObtain=" + ifObtain +
                ", misfileAddressArray=" + Arrays.toString(misfileAddressArray) +
                '}';
    }
}
