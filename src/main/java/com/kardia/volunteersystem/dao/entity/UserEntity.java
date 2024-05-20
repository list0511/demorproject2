package com.kardia.volunteersystem.dao.entity;

import java.util.Arrays;

public class UserEntity extends FileEntity {
    private String id;
    //志愿者或孩子的id
    private String account;
    //登录时用的账号
    private String password;
    //登录时用的密码
    private String nickname;
    //昵称
    private int type;
    //用户类型，1为孩子，2为志愿者
    private String[] pic;
    //pic用来存储头像文件的绝对路径，是一个长度为1的字符串数组
    private String description;
    //用户描述，可以用来描述孩子的具体情况
    private int scoreTotal;
    //孩子的累计积分
    private int scoreCurrent;
    //孩子的现有积分

    private String[] bindArray;
    //bindArray用来存储志愿者和孩子的绑定情况

    public String[] getBindArray() {
        return bindArray;
    }

    public void setBindArray(String[] bindArray) {
        this.bindArray = bindArray;
    }

    public UserEntity(){
        this.id = "userid";
        this.account = "useraccount";
        this.password = "userpassword";
        this.nickname = "usernickname";
        this.type = 0;
        this.pic = null;
        this.description = "userdescription";
        this.scoreTotal = 0;
        this.scoreCurrent = 0;
        this.bindArray = null;
        //空参构造
    }

    public UserEntity(String id, String account, String password, String nickname, int type, String[] pic,
                      String description, int scoreTotal, int scoreCurrent, String[] bindArray) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.type = type;
        this.pic = pic;
        this.description = description;
        this.scoreTotal = scoreTotal;
        this.scoreCurrent = scoreCurrent;
        this.bindArray = bindArray;
        //全参构造
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String[] getPic() {
        return pic;
    }

    public void setPic(String[] pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public int getScoreCurrent() {
        return scoreCurrent;
    }

    public void setScoreCurrent(int scoreCurrent) {
        this.scoreCurrent = scoreCurrent;
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", type=" + type +
                ", pic='" + pic + '\'' +
                ", description='" + description + '\'' +
                ", scoreTotal=" + scoreTotal +
                ", scoreCurrent=" + scoreCurrent +
                ", bindArray=" + Arrays.toString(bindArray) +
                '}';
    }
}
