package com.kardia.volunteersystem.controller;


import com.kardia.volunteersystem.dao.entity.MissionEntity;
import com.kardia.volunteersystem.dao.entity.MissionRecordEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.service.MissionRecordService;
import com.kardia.volunteersystem.utils.HttpsResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mission")
@CrossOrigin
public class MissionRecordController {

    private final MissionRecordService missionRecordService;

    public MissionRecordController(MissionRecordService missionRecordService){
        this.missionRecordService=missionRecordService;
    }

    public UploadController uploadController = new UploadController();

    @RequestMapping(value="/zviewready",consumes = "application/json")
    public HttpsResponseEntity ZViewReadyRecord(@RequestBody MissionEntity missionEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MissionRecordEntity> result = missionRecordService.ZViewReady(missionEntity);
        httpsResponseEntity.setCode("1");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("查询成功");
        return httpsResponseEntity;
    }

    @RequestMapping(value="/zviewalready",consumes = "application/json")
    public HttpsResponseEntity ZViewAlreadyRecord(@RequestBody MissionEntity missionEntity_front){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MissionRecordEntity> result = missionRecordService.ZViewAlready(missionEntity_front);
        httpsResponseEntity.setCode("1");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("查询成功");
        return httpsResponseEntity;
    }

    @RequestMapping(value="/mark",consumes = "application/json")
    public HttpsResponseEntity MarkTheRecord(@RequestBody MissionRecordEntity missionRecordEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        MissionRecordEntity result = missionRecordService.Mark(missionRecordEntity);
        int updateResult = missionRecordService.addTheScore(missionRecordEntity);
        httpsResponseEntity.setCode("1");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("批改结果："+result.getId()+"更新结果："+updateResult);
        return httpsResponseEntity;
    }

    /**
     * 查看进行中任务
     * @param userEntity
     * @return
     */
    @RequestMapping(value="/seeaccept",consumes = "application/json")
    public HttpsResponseEntity SeeAcceptMissions(@RequestBody UserEntity userEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();

        try{
            List<MissionRecordEntity> missionRecordEntities =missionRecordService.SeeAccept(userEntity);
            if(missionRecordEntities.isEmpty())
            {
                httpsResponseEntity.setMessage("没有进行中任务");
                httpsResponseEntity.setData(missionRecordEntities);
                httpsResponseEntity.setCode("-1");
            }
            else{
                httpsResponseEntity.setMessage("存在进行中任务");
                httpsResponseEntity.setData(missionRecordEntities);
                httpsResponseEntity.setCode("666");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return httpsResponseEntity;
    }


    /**
     * 查看历史任务
     * @param userEntity
     * @return
     */
    @RequestMapping(value="/seehistory",consumes = "application/json")
    public HttpsResponseEntity SeeHistoryMissions(@RequestBody UserEntity userEntity)
    {
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();

        try{
            List<MissionRecordEntity> missionRecordEntities = missionRecordService.SeeHistory(userEntity);
            if(missionRecordEntities.isEmpty()){
                httpsResponseEntity.setMessage("没有历史任务");
                httpsResponseEntity.setData(missionRecordEntities);
                httpsResponseEntity.setCode("-1");

            }
            else{
                httpsResponseEntity.setMessage("存在历史任务");
                httpsResponseEntity.setData(missionRecordEntities);
                httpsResponseEntity.setCode("666");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return httpsResponseEntity;
    }



    @RequestMapping(value="/addrecord",consumes = "application/json")
    public HttpsResponseEntity AddTheRecord(@RequestBody MissionRecordEntity missionRecordEntity)
    {
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        try{
            missionRecordEntity.setMisfileAddressArray(uploadController.uploadMissionRecord(missionRecordEntity));
            MissionRecordEntity missionRecord = missionRecordService.NewTheRecord(missionRecordEntity);
            httpsResponseEntity.setData(missionRecord);
            httpsResponseEntity.setCode("666");
            httpsResponseEntity.setMessage("任务记录创建成功");
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
        return httpsResponseEntity;
    }


    @RequestMapping(value="/modifyrecord",consumes = "application/json")
    public HttpsResponseEntity ModifyTheRecord(@RequestBody MissionRecordEntity missionRecordEntity)
    {
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        try{
            missionRecordEntity.setMisfileAddressArray(uploadController.uploadMissionRecord(missionRecordEntity));
            MissionRecordEntity missionRecord = missionRecordService.ModifyTheRecord(missionRecordEntity);
            httpsResponseEntity.setData(missionRecord);
            httpsResponseEntity.setMessage("修改成功");
            httpsResponseEntity.setCode("666");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return httpsResponseEntity;
    }

    @RequestMapping(value="/queryrecords",consumes = "application/json")
    public HttpsResponseEntity QueryRecordList(@RequestBody UserEntity userEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        try{
            List<MissionRecordEntity> missionRecordEntities = missionRecordService.QueryMissionList(userEntity);
            httpsResponseEntity.setData(missionRecordEntities);
            httpsResponseEntity.setCode("666");
            httpsResponseEntity.setMessage("任务记录全部");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return httpsResponseEntity;
    }

    @RequestMapping(value="/sortrecord",consumes = "application/json")
    public HttpsResponseEntity AddTheRecord(@RequestBody List<MissionRecordEntity> missionRecordEntities)
    {
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        try{

            List<MissionRecordEntity> missionRecordEntityList = missionRecordService.sortMissionRecord(missionRecordEntities);
            httpsResponseEntity.setData(missionRecordEntityList);
            httpsResponseEntity.setCode("666");
            httpsResponseEntity.setMessage("任务记录排序成功");
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
        return httpsResponseEntity;
    }

}
