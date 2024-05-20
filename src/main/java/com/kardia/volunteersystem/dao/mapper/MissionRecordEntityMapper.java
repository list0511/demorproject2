package com.kardia.volunteersystem.dao.mapper;

import com.kardia.volunteersystem.dao.entity.MissionRecordEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
@Mapper
public interface MissionRecordEntityMapper{
    /**
     * 查询任务记录列表
     * @param missionRecordEntity 任务记录实体类
     * @return 任务记录列表
     */
    List<MissionRecordEntity> queryMissionRecordList(MissionRecordEntity missionRecordEntity);

    /**
     * 创建任务记录
     * @param missionRecordEntity 任务记录实体类
     * @return 受影响的行数
     */
    int insertMissionRecord(MissionRecordEntity missionRecordEntity);

    /**
     * 删除任务记录
     * @param missionRecordEntity 任务记录实体类
     * @return 受影响的行数
     */
    int deleteMissionRecord(MissionRecordEntity missionRecordEntity);

    /**
     * 编辑任务记录
     * @param missionRecordEntity 任务记录实体类
     * @return 受影响的行数
     */
    int updateMissionRecord(MissionRecordEntity missionRecordEntity);

    /**
     * 批改当前的待批改任务，更新当前记录的状态
     * @param missionRecordEntity 任务记录实体类
     * @return 受影响的行数
     */
    int mark(MissionRecordEntity missionRecordEntity);

    /**
     * 孩子查询进行中任务
     */
    List<MissionRecordEntity> SeeAccept(UserEntity userEntity);

    /**
     * 孩子查询历史任务
     */
    List<MissionRecordEntity> SeeHistory(UserEntity userEntity);

    /**
     * 查询任务记录列表
     */
    List<MissionRecordEntity> queryMissionRecordList(UserEntity userEntity);

    /**
     * 新建任务记录
     */

    int insertRecord(MissionRecordEntity missionRecordEntity);


    /**
     *修改任务记录
     */
    int modifyRecord(MissionRecordEntity missionRecordEntity);

    /**
     * 查询某个任务记录
     * @param missionRecordEntity 任务记录实体类
     * @return 任务记录列表
     */
    List<MissionRecordEntity> selectMissionRecordById(MissionRecordEntity missionRecordEntity);

    UserEntity obtainScore(MissionRecordEntity missionRecordEntity);

    int updateObtainedRecord(MissionRecordEntity missionRecordEntity);

    List<MissionRecordEntity> sortMissionRecord(List<MissionRecordEntity> missionRecordEntities);

}
