package com.kardia.volunteersystem.dao.mapper;


import com.kardia.volunteersystem.dao.entity.MissionEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MissionEntityMapper {
    //查询任务列表
    List<MissionEntity>  queryMissonList(UserEntity userEntity);


    //志愿者本人创建且正在进行的任务
    List<MissionEntity>  viewOpen(UserEntity userEntity);


    //当前由志愿者本人创建且已经结束的任务
    List<MissionEntity>  viewClosed(UserEntity userEntity);

    //志愿者本人创建且尚未开始的任务
    List<MissionEntity>  viewPre(UserEntity userEntity);
    //创建任务信息
    int insertMission(MissionEntity missionEntity);

    //删除任务信息
    int deleteMission(MissionEntity missionEntity);

    //编辑任务信息
    int updateMission(MissionEntity missionEntity);

    //查询任务信息
    List<MissionEntity> selectMission(MissionEntity missionEntity);

    //孩子查看自己的志愿者创建的可选任务
    List<MissionEntity> SeeSelect(UserEntity userEntity);

    List<MissionEntity> sortMission(List<MissionEntity> missionEntities);

}
