package com.kardia.volunteersystem.dao.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class MessageEntity extends FileEntity {
    private String id;
    //一条消息的id
    private String userSend;
    //消息的发送者(id
    private String userReceive;
    //消息的接受者(id
    private Date sendTime;
    //消息发送时间
    private String text;
    //消息文本内容
    private int type;
    //消息类型,1文本,2图片,3视频,4文件

    private String[] fileAddressArray;
    //存储当前消息包含的文件的绝对路径，正常来说长度为1，一条消息对应一个文件或一段文本

    public String[] getFileAddressArray() {
        return fileAddressArray;
    }

    public void setFileAddressArray(String[] fileAddressArray) {
        this.fileAddressArray = fileAddressArray;
    }

    public String getId() {
        return id;
    }

    public String getUserSend() {
        return userSend;
    }

    public String getUserReceive() {
        return userReceive;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public String getText() {
        return text;
    }

    public int getType() {
        return type;
    }



    public void setId(String id) {
        this.id = id;
    }

    public void setUserSend(String userSend) {
        this.userSend = userSend;
    }

    public void setUserReceive(String userReceive) {
        this.userReceive = userReceive;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(int type) {
        this.type = type;
    }



    public MessageEntity(String id, String userSend, String userReceive, Date sendTime, String text, int type, String[] fileAddressArray) {
        this.id = id;
        this.userSend = userSend;
        this.userReceive = userReceive;
        this.sendTime = sendTime;
        this.text = text;
        this.type = type;
        this.fileAddressArray = fileAddressArray;
    }

    public MessageEntity(){

    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id='" + id + '\'' +
                ", userSend='" + userSend + '\'' +
                ", userReceive='" + userReceive + '\'' +
                ", sendTime=" + sendTime +
                ", text='" + text + '\'' +
                ", type=" + type +
                ", fileAddressArray=" + Arrays.toString(fileAddressArray) +
                '}';
    }
}
