package com.kardia.volunteersystem.dao.mapper;

import com.kardia.volunteersystem.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserEntityMapper {
    //查询用户列表
    List<UserEntity> queryUserList(UserEntity userEntity);
    //创建用户基本信息
    int insertUser(UserEntity userEntity);
    //删除用户基本信息
    int deleteUser(UserEntity userEntity);
    //编辑用户信息
    int modifyUser(UserEntity userEntity);
    //查询某个用户
    List<UserEntity> selectUserByAccountByPwd(UserEntity userEntity);

    List<UserEntity> selectUserByAccount(UserEntity userEntity);

    List<UserEntity> selectUserById(UserEntity userEntity);

    List<UserEntity> getallChild();

    List<UserEntity> getmyChild(UserEntity userEntity);

    UserEntity gettheChild(UserEntity userEntity);

    int addScore(UserEntity userEntity);

    //查询查看某动态的儿童
    UserEntity selectCheckMomentChild(UserEntity userEntity);

    //动态积分加成
    int addMomentScore(UserEntity userEntity);
}
