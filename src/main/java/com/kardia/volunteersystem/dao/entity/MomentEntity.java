package com.kardia.volunteersystem.dao.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MomentEntity extends FileEntity {

    private String id;
    //一条动态的id
    private String userSend;
    //此动态的发送者id
    private String content;
    //此动态的文本内容
    private int type;
    //此动态的类型,1是纯文字,2是文字+图片或视频,3是混合类型（比如投票）
    private Date time;
    //此动态的发送时间

    private int score;
    //此动态的对应分数

    private String[] fileAddressArray;
    //存文件们的绝对路径的字符串数组

    private ArrayList<String> likesArray;
    //存点赞人的字符串数组->存查看人的字符串数组（存UserEntity的姓名）
    private List<String[]> commentsArray;
    //存评论的字符串数组

    public String[] getFileAddressArray() {
        return fileAddressArray;
    }

    public void setFileAddressArray(String[] fileAddressArray) {
        this.fileAddressArray = fileAddressArray;
    }

    public ArrayList<String> getLikesArray() {
        return likesArray;
    }

    public void setLikesArray(ArrayList<String> likesArray) {
        this.likesArray = likesArray;
    }

    public List<String[]> getCommentsArray() {
        return commentsArray;
    }

    public void setCommentsArray(List<String[]> commentsArray) {
        this.commentsArray = commentsArray;
    }

    public MomentEntity(){
        this.id = "momentid";
        this.userSend = "momentusersend";
        this.content = "momentcontent";
        this.type = 0;
        this.time = new Date();
        this.score = 0;
        this.fileAddressArray = null;
        this.likesArray = null;
        this.commentsArray = null;
    }

    public MomentEntity(String id, String userSend, String content, int type, Date time,int score,
                        String[] fileAddressArray, ArrayList<String> likesArray, List<String[]> commentsArray) {
        this.id = id;
        this.userSend = userSend;
        this.content = content;
        this.type = type;
        this.time = time;
        this.score = score;
        this.fileAddressArray = fileAddressArray;
        this.likesArray = likesArray;
        this.commentsArray = commentsArray;
    }

    public String getId() {
        return id;
    }

    public String getUserSend() {
        return userSend;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    public Date getTime() {
        return time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserSend(String userSend) {
        this.userSend = userSend;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "MomentEntity{" +
                "id='" + id + '\'' +
                ", userSend='" + userSend + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", time=" + time +
                ", score=" + score +
                ", fileAddressArray=" + Arrays.toString(fileAddressArray) +
                ", likesArray=" + likesArray +
                ", commentsArray=" + commentsArray +
                '}';
    }
}
