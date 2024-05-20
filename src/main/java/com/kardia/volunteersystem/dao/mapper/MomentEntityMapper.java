package com.kardia.volunteersystem.dao.mapper;

import com.kardia.volunteersystem.dao.entity.MomentEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MomentEntityMapper {
    List<MomentEntity> queryMomentList(MomentEntity momentEntity);
    //创建用户基本信息
    int insertMoment(MomentEntity momentEntity);
    //删除用户基本信息
    int deleteMoment(MomentEntity momentEntity);
    //编辑用户信息
    int modifyMoment(MomentEntity momentEntity);
    //查询某个用户
    List<MomentEntity> selectMomentByUserId(UserEntity userEntity);
    //查询被查看的动态
    MomentEntity selectCheckedMoment(MomentEntity momentEntity);

    MomentEntity selectMomentById(MomentEntity momentEntity);

}