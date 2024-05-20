package com.kardia.volunteersystem.service;

import com.kardia.volunteersystem.dao.entity.MissionEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.dao.mapper.MissionEntityMapper;
import com.kardia.volunteersystem.utils.BeanArrayUtil;
import com.kardia.volunteersystem.utils.UUIDUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MissionService {
    private final MissionEntityMapper missionEntityMapper;

    public  MissionService(MissionEntityMapper missionEntityMapper){
        this.missionEntityMapper =missionEntityMapper;
    }

    /**
     *将志愿者新建的任务存入数据库
     */
    public  MissionEntity  NewTheMission(MissionEntity missionEntity){
       try{
           missionEntity.setId(UUIDUtil.getOneUUID());
           missionEntityMapper.insertMission(missionEntity);
           return missionEntity;
       }catch (Exception e){
           MissionEntity missionEntity1 = new MissionEntity();
           missionEntity1.setId("-1");
           e.printStackTrace();
           return missionEntity1;
       }
    }

    //返回当前由志愿者本人创建且正在进行的任务
    public List<MissionEntity>  ViewOpen(UserEntity userEntity){

        List<MissionEntity> list = missionEntityMapper.viewOpen(userEntity);
//        System.out.println(userEntity.getId());
//        System.out.println(list.size());
//        System.out.println(list.get(0).toString());
        return list;
    }



    //返回当前由志愿者本人创建且已经结束的任务
    public List<MissionEntity>  ViewClosed(UserEntity userEntity){
        List<MissionEntity> list =   missionEntityMapper.viewClosed(userEntity);
        return list;
    }

    //返回当前由志愿者本人创建且尚未开始的任务
    public List<MissionEntity>  ViewPre(UserEntity userEntity){
        List<MissionEntity> list =   missionEntityMapper.viewPre(userEntity);
        return list;
    }

    /*
     *返回由对应志愿者创建的可选任务
     */
    public List<MissionEntity> SeeSelect(UserEntity userEntity)
    {
        List<MissionEntity> result = missionEntityMapper.SeeSelect(userEntity);
//        System.out.println("任务列表"+result);
        return result;
    }

    public List<MissionEntity>  sortMission(List<MissionEntity> missionEntities){

        missionEntities=missionEntityMapper.sortMission(missionEntities);
        return missionEntities;
    }

}
