package com.kardia.volunteersystem.controller;


import com.kardia.volunteersystem.dao.entity.MissionEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.service.MissionService;
import com.kardia.volunteersystem.utils.HttpsResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mession")
@CrossOrigin
public class MissionController {
    @Autowired
    private final MissionService missionService;
    public  MissionController(MissionService missionService){
        this.missionService=missionService;
    }
    public UploadController uploadController = new UploadController();

    //将志愿者新建的任务存入数据库
    @GetMapping("/add")
    public HttpsResponseEntity AddTheMission(@RequestBody MissionEntity missionEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        missionEntity.setFileAddressArray(uploadController.uploadMission(missionEntity));
        MissionEntity  result = missionService.NewTheMission(missionEntity);
        httpsResponseEntity.setCode("1");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("创建成功");
        return httpsResponseEntity;
    }

    //查看当前由志愿者本人创建且正在进行的任务
    @RequestMapping(value="/openview",consumes = "application/json")
    public HttpsResponseEntity ViewOpenMissions(@RequestBody UserEntity userEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MissionEntity> result = missionService.ViewOpen(userEntity);
        httpsResponseEntity.setCode("1");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("创建成功");
        return httpsResponseEntity;
    }
    //查看当前由志愿者本人创建且已经结束的任务
    @RequestMapping(value="/closedview",consumes = "application/json")
    public HttpsResponseEntity ViewClosedMissions(@RequestBody UserEntity userEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MissionEntity> result = missionService.ViewClosed(userEntity);
        httpsResponseEntity.setCode("666");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("创建成功");
        return httpsResponseEntity;
    }
    //查看当前由志愿者本人创建且尚未开始的任务
    @RequestMapping(value="/preview",consumes = "application/json")
    public HttpsResponseEntity ViewPreMissions(@RequestBody UserEntity userEntity){
        System.out.println("22222222222");
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MissionEntity> result = missionService.ViewPre(userEntity);
        httpsResponseEntity.setCode("666");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("创建成功");
        return httpsResponseEntity;
    }

    /**
     * 儿童查找可选任务
     * @param userEntity
     * @return
     */
    @RequestMapping(value="/seeselect",consumes = "application/json")
    public HttpsResponseEntity SeeSelectMissions(@RequestBody UserEntity userEntity)
    {
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        try {
            List<MissionEntity> hasMissions = missionService.SeeSelect(userEntity);
            if(hasMissions.isEmpty())
            {
                httpsResponseEntity.setMessage("没有可选任务");
                httpsResponseEntity.setData(hasMissions);
                httpsResponseEntity.setCode("-1");
            }
            else{
                httpsResponseEntity.setMessage("存在可选任务");
                httpsResponseEntity.setData(hasMissions);
                httpsResponseEntity.setCode("666");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return httpsResponseEntity;
    }

    @RequestMapping(value="/sortmission",consumes = "application/json")
    public HttpsResponseEntity SortMissions(@RequestBody List<MissionEntity> missionEntities){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MissionEntity> result = missionService.sortMission(missionEntities);
        httpsResponseEntity.setCode("666");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("创建成功");
        return httpsResponseEntity;
    }

}
