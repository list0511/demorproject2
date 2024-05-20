package com.kardia.volunteersystem.controller;

import com.google.gson.Gson;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.service.FileService;
import com.kardia.volunteersystem.service.UserService;
import com.kardia.volunteersystem.utils.HttpsResponseEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private final UserService userService;
    private final FileService fileService;

    public UserController(UserService userService, FileService fileService) {
        this.userService = userService;
        this.fileService = fileService;
    }

    public UploadController uploadController = new UploadController();

    @RequestMapping(value = "/modifymsg",consumes = "application/json")
    public HttpsResponseEntity queryUserList(@RequestBody UserEntity userEntity)
    {
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        try {
            List<UserEntity> hasUser;
            hasUser=userService.queryUserList(userEntity);
            System.out.println("调用列表");

            if(hasUser.isEmpty())
            {
                httpsResponseEntity.setCode("0");
                httpsResponseEntity.setData(0);
                httpsResponseEntity.setMessage("没有任务记录");
            } else  {
                httpsResponseEntity.setCode("666");
                httpsResponseEntity.setData(hasUser);
                httpsResponseEntity.setMessage("查询成功");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return httpsResponseEntity;
    }


    @RequestMapping(value = "/selectUserById",consumes = "application/json")
    public HttpsResponseEntity selectUserById(@RequestBody UserEntity userEntity)
    {
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        try {
            List<UserEntity> hasUser=userService.searchUserById(userEntity);
            if(hasUser.isEmpty())
            {
                httpsResponseEntity.setCode("0");
                httpsResponseEntity.setData(0);
                httpsResponseEntity.setMessage("没有项目");
            } else  {
                httpsResponseEntity.setCode("666");
                httpsResponseEntity.setData(hasUser);
                httpsResponseEntity.setMessage("查询成功");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return httpsResponseEntity;
    }

//    @RequestMapping(value = "/modifymsg",consumes = "application/json")
//    public HttpsResponseEntity ModifyTheUserMsg(@RequestBody UserEntity userEntity)
//    {
//        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
//        UserEntity userEntity1;
//        try {
//            userEntity.setPic(uploadController.uploadUser(userEntity));
//            userEntity1=userService.ModifyMsg(userEntity);
//            httpsResponseEntity.setCode("0");
//            httpsResponseEntity.setData(userEntity1);
//            httpsResponseEntity.setMessage("用户修改成功");
//            return httpsResponseEntity;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//        return httpsResponseEntity;
//    }

    @RequestMapping(value = "/add",consumes = "application/json")
    public HttpsResponseEntity AddTheUser(@RequestBody  UserEntity userEntity)
    {
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();

        try {
            UserEntity n = userService.IfHasTheUser(userEntity);
            if(n.getId().equals("-1") )
            {
                UserEntity result=userService.NewTheUser(userEntity);
                httpsResponseEntity.setMessage("新增成功");
                httpsResponseEntity.setData(result);
                httpsResponseEntity.setCode("666");
            }
            else {
                UserEntity userEntity1 = new UserEntity();
                userEntity1.setId("1");
                httpsResponseEntity.setCode("-1111111");
                httpsResponseEntity.setData(userEntity1);
                httpsResponseEntity.setMessage("新增失败");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpsResponseEntity;
    }

    @RequestMapping(value = "/login",consumes = "application/json")
    public HttpsResponseEntity UserLogin(@RequestBody  UserEntity userEntity)
    {
        System.out.println(userEntity+"111111111111111111");
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();

        try {
            UserEntity n = userService.IfHasTheUser(userEntity);
            if(n.getId().equals("-1"))
            {
                UserEntity result= new UserEntity();
                result.setId("-1");
                httpsResponseEntity.setMessage("账号不存在");
                httpsResponseEntity.setData(result);
                httpsResponseEntity.setCode("-2");
            }
            else {

//                File aFile = fileService.getTheFile(n.getPic()[0]);
//                String fileName = aFile.getName().substring(0,aFile.getName().lastIndexOf("."));
//                String fileExtend = aFile.getName().substring(aFile.getName().lastIndexOf("."));
//                byte[] fileContent = Files.readAllBytes(aFile.toPath());
//                String[] temp = n.getFileName();
//                temp[0] = fileName;
//                n.setFileName(temp);
//                String[] temp1 = n.getFileExtend();
//                temp1[0] = fileExtend;
//                n.setFileExtend(temp1);
//                byte[][] temp2 = n.getFileData();
//                temp2[0] = fileContent;
//                n.setFileData(temp2);

                UserEntity userEntity1;
                userEntity1=userService.IfPwdCorrect(n,userEntity.getPassword());

                if(userEntity1.getId().equals("-1")){
                    httpsResponseEntity.setCode("-1");
                    httpsResponseEntity.setData(userEntity1);
                    httpsResponseEntity.setMessage("密码错误");
                }else{
                    httpsResponseEntity.setCode("1");
                    userEntity1 = uploadController.downloadUser(userEntity1);
                    httpsResponseEntity.setData(userEntity1);
                    httpsResponseEntity.setMessage("密码正确");
                }

            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpsResponseEntity;
    }
    @RequestMapping(value = "/deleteUser",consumes = "application/json")
    public HttpsResponseEntity deleteUser(@RequestBody UserEntity userEntity)
    {
        HttpsResponseEntity httpResponseEntity = new HttpsResponseEntity();

        try {
            int result = userService.deleteUser(userEntity);
            if(result != 0)
            {
                httpResponseEntity.setData(result);
                httpResponseEntity.setCode("666");
                httpResponseEntity.setMessage("删除成功");
            }
            else
            {
                httpResponseEntity.setData(0);
                httpResponseEntity.setCode("0");
                httpResponseEntity.setMessage("删除失败");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return httpResponseEntity;
    }

    @RequestMapping(value="/getmychild",consumes = "application/json")
    public HttpsResponseEntity getMyChildren(@RequestBody UserEntity userEntity)
    {
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        try{
            List<UserEntity> result = userService.getMyC(userEntity);
            if(result.isEmpty())
            {
                httpsResponseEntity.setCode("-1");
                httpsResponseEntity.setData(result);
                httpsResponseEntity.setMessage("该名志愿者不存在儿童");
            }
            else{
                httpsResponseEntity.setCode("666");
                httpsResponseEntity.setMessage("该名志愿者存在儿童");
                httpsResponseEntity.setData(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return httpsResponseEntity;
    }

    @RequestMapping(value="/getallchild",consumes = "application/json")
    public HttpsResponseEntity getAllChildren(){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        try{
            List<UserEntity> result = userService.getAllC();
            if(result.isEmpty())
            {
                httpsResponseEntity.setCode("-1");
                httpsResponseEntity.setData(result);
                httpsResponseEntity.setMessage("没有儿童");
            }
            else{
                httpsResponseEntity.setMessage("存在儿童");
                httpsResponseEntity.setCode("666");
                httpsResponseEntity.setData(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return httpsResponseEntity;
    }

    @RequestMapping(value="/getthechild",consumes = "application/json")
    public HttpsResponseEntity getTheChild(@RequestBody UserEntity userEntity)
    {
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        try{
            UserEntity result = userService.getTheC(userEntity);
            if(result == null){
                httpsResponseEntity.setData(result);
                httpsResponseEntity.setMessage("找不到");
                httpsResponseEntity.setCode("-1");
            }else {
                httpsResponseEntity.setCode("666");
                httpsResponseEntity.setData(result);
                httpsResponseEntity.setMessage("找到了");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return httpsResponseEntity;
    }

    //新加controller，获取对应朋友的全部信息
    @RequestMapping(value = "/GetFriend", consumes = "application/json")
    public HttpsResponseEntity GetFriend(@RequestBody UserEntity userEntity)
    {
        HttpsResponseEntity httpResponseEntity = new HttpsResponseEntity();
        try {
            List<UserEntity> result = userService.GetAllFriend(userEntity);
            if(result!=null)
            {
                httpResponseEntity.setData(result);
                httpResponseEntity.setCode("666");
                httpResponseEntity.setMessage("查找朋友成功");
            }
            else
            {
                httpResponseEntity.setData(0);
                httpResponseEntity.setCode("0");
                httpResponseEntity.setMessage("查找朋友失败");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return httpResponseEntity;
    }

}
