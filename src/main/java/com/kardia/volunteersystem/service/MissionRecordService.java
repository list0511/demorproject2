package com.kardia.volunteersystem.service;

import com.kardia.volunteersystem.dao.entity.MissionEntity;
import com.kardia.volunteersystem.dao.entity.MissionRecordEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.dao.mapper.MissionRecordEntityMapper;
import com.kardia.volunteersystem.dao.mapper.UserEntityMapper;
import com.kardia.volunteersystem.utils.BeanArrayUtil;
import com.kardia.volunteersystem.utils.UUIDUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MissionRecordService {
    private final MissionRecordEntityMapper missionRecordEntityMapper;
    private final UserEntityMapper userEntityMapper;

    public MissionRecordService(MissionRecordEntityMapper missionRecordEntityMapper, UserEntityMapper userEntityMapper){
        this.missionRecordEntityMapper = missionRecordEntityMapper;
        this.userEntityMapper = userEntityMapper;
    }

    //查看当前任务下待批改的记录
    public List<MissionRecordEntity> ZViewReady(MissionEntity missionEntity){
        BeanArrayUtil beanArrayUtil = new BeanArrayUtil();
        MissionRecordEntity missionRecordEntity =  new MissionRecordEntity();
        missionRecordEntity.setMissionId(missionEntity.getId());
        missionRecordEntity.setStatus(1);
        List<MissionRecordEntity> list = missionRecordEntityMapper.selectMissionRecordById(missionRecordEntity);
        return list;

    }

    public List<MissionRecordEntity> SeeAccept(UserEntity userEntity){
        List<MissionRecordEntity> result = missionRecordEntityMapper.SeeAccept(userEntity);

        System.out.println("进行中任务："+result);
        return result;
    }

    public List<MissionRecordEntity> SeeHistory(UserEntity userEntity){
        List<MissionRecordEntity> result = missionRecordEntityMapper.SeeHistory(userEntity);

        System.out.println("历史任务："+result);
        return result;
    }

    /**
     * 查看全部任务记录
     */
    public List<MissionRecordEntity> QueryMissionList(UserEntity userEntity){
        List<MissionRecordEntity> missionRecordEntities =
                missionRecordEntityMapper.queryMissionRecordList(userEntity);
        System.out.println("结果是："+missionRecordEntities);
        return missionRecordEntities;
    }


    /**
     * 新增项目
     */
    public MissionRecordEntity NewTheRecord(MissionRecordEntity missionRecordEntity)
    {

        missionRecordEntity.setId(UUIDUtil.getOneUUID());

        missionRecordEntityMapper.insertRecord(missionRecordEntity);
        return missionRecordEntity;
    }

    /**
     * 修改项目
     */

    public MissionRecordEntity ModifyTheRecord(MissionRecordEntity missionRecordEntity)
    {
        missionRecordEntityMapper.modifyRecord(missionRecordEntity);
        return missionRecordEntity;
    }

    public List<MissionRecordEntity> ZViewAlready(MissionEntity missionEntity){
        BeanArrayUtil beanArrayUtil = new BeanArrayUtil();
        MissionRecordEntity missionRecordEntity =  new MissionRecordEntity();
        missionRecordEntity.setMissionId(missionEntity.getId());
        missionRecordEntity.setStatus(2);
        List<MissionRecordEntity> list = missionRecordEntityMapper.selectMissionRecordById(missionRecordEntity);
        return list;
    }


    //批改当前的待批改任务，更新当前记录的状态
    public MissionRecordEntity Mark(MissionRecordEntity missionRecordEntity){
        int result = missionRecordEntityMapper.mark(missionRecordEntity);
        if(result !=0){
            return missionRecordEntity;
        }
        else{
            missionRecordEntity.setId("-1");
            return missionRecordEntity;
        }
    }

    //将批改后的任务加分到对应儿童
    public int addTheScore(MissionRecordEntity missionRecordEntity)
    {
        UserEntity theUser = missionRecordEntityMapper.obtainScore(missionRecordEntity);
        int result1 = userEntityMapper.addScore(theUser);
        int result2 = missionRecordEntityMapper.updateObtainedRecord(missionRecordEntity);
        int badResult = 0 ;
        if(result1 == 0){
            System.out.println("儿童表加分失败");
            return badResult;
        }
        else if(result2 == 0){
            System.out.println("任务记录表再次修改失败");
            return badResult;
        }
        else if(theUser == null)
        {
            System.out.println("没有找到要加分的儿童");
            return badResult;
        }
        else{
            return 1;
        }

    }

    public List<MissionRecordEntity> sortMissionRecord(List<MissionRecordEntity> missionRecordEntities){
        missionRecordEntities=missionRecordEntityMapper.sortMissionRecord(missionRecordEntities);
        return missionRecordEntities;
    }

}
