package com.kardia.volunteersystem.controller;

import com.kardia.volunteersystem.dao.entity.MomentEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.service.MomentService;
import com.kardia.volunteersystem.utils.HttpsResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/moment")
@CrossOrigin
public class MomentController {
    private final MomentService momentService;

    public MomentController(MomentService momentService){
        this.momentService=momentService;
    }

    public UploadController uploadController = new UploadController();
    @RequestMapping(value="/add",consumes = "application/json")
    public HttpsResponseEntity AddMoment(@RequestBody MomentEntity momentEntity){
        String s="ss";
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        momentEntity.setFileAddressArray(uploadController.uploadMoment(momentEntity));
        MomentEntity result = momentService.AddMoment(momentEntity);
        httpsResponseEntity.setCode("1");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("添加成功");
        return httpsResponseEntity;
    }

    @RequestMapping(value="/modify",consumes = "application/json")
    public HttpsResponseEntity ModifyMoment(@RequestBody MomentEntity momentEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        momentEntity.setFileAddressArray(uploadController.uploadMoment(momentEntity));
        MomentEntity result = momentService.ModifyMoment(momentEntity);
        httpsResponseEntity.setCode("1");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("修改成功");
        return httpsResponseEntity;
    }
    @RequestMapping(value="/delete",consumes = "application/json")
    public HttpsResponseEntity DeleteMoment(@RequestBody MomentEntity momentEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        MomentEntity result = momentService.DeleteMoment(momentEntity);
        httpsResponseEntity.setCode("1");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("删除成功");
        return httpsResponseEntity;
    }
    @RequestMapping(value="/select",consumes = "application/json")
    public HttpsResponseEntity SelectMoment(@RequestBody UserEntity userEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MomentEntity> result = new ArrayList<>();
        result.addAll(momentService.SelectByUserId(userEntity)); // 获取指定用户的动态信息
        if (userEntity.getBindArray() != null) {
            for (String bindUserId : userEntity.getBindArray()) {
                if (bindUserId != null && !bindUserId.isEmpty()) {
                    UserEntity bindUser = new UserEntity();
                    bindUser.setId(bindUserId);
                    System.out.println(bindUserId);
                    result.addAll(momentService.SelectByUserId(bindUser));  // 获取绑定用户的动态信息
                }
            }
        }
        result = momentService.SortMomentByTime(result); // 对动态信息按时间排序
        httpsResponseEntity.setCode("1");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("查询成功");
        return httpsResponseEntity;
    }

    @RequestMapping(value="/query",consumes = "application/json")
    public HttpsResponseEntity QueryMoment(@RequestBody MomentEntity momentEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MomentEntity> result = new ArrayList<>();
        result=momentService.QueryMoment(momentEntity);
        httpsResponseEntity.setCode("1");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("列表成功");
        return httpsResponseEntity;
    }

    @RequestMapping(value="/getscore",consumes = "application/json")
    public int GetScoreFromMoment(@RequestParam("momentId") String momentId, @RequestParam("userId") String userId )
    {
        int result = momentService.getScore(momentId,userId);
        if(result == 0){
            System.out.println("积分记录失败");

        }
        else {
            System.out.println("积分记录成功");
        }
        return result;

    }

    //新增评论
    @RequestMapping(value="/addcomment",consumes = "application/json")
    public HttpsResponseEntity AddTheComment(@RequestBody String MomentId,String UserID,String comment){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        int result = momentService.addTheComment(MomentId,UserID,comment);
        if(result!=0){
            httpsResponseEntity.setCode("1");
            httpsResponseEntity.setData(result);
            httpsResponseEntity.setMessage("创建成功");
        }
        else{
            httpsResponseEntity.setCode("0");
            httpsResponseEntity.setData(result);
            httpsResponseEntity.setMessage("添加失败");
        }
        return httpsResponseEntity;
    }


}