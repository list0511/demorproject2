package com.kardia.volunteersystem.controller;

import com.kardia.volunteersystem.dao.entity.MessageEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.service.MessageService;
import com.kardia.volunteersystem.utils.HttpsResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/message")
@CrossOrigin
public class MessageController {

    private final MessageService messageService;


    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    public UploadController uploadController = new UploadController();

    @RequestMapping(value = "/queryMessageList", method = RequestMethod.POST , headers = "Accept=application/json")
    public HttpsResponseEntity queryMessageList(@RequestBody MessageEntity messageEntity)
    {
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        try {
            List<MessageEntity> listmap= messageService.ShowChatList(messageEntity);
            if(listmap.isEmpty())
            {
                httpsResponseEntity.setCode("-1");
                httpsResponseEntity.setData(0);
                httpsResponseEntity.setMessage("没有消息记录");
            } else  {
                httpsResponseEntity.setCode("666");
                httpsResponseEntity.setData(listmap);
                httpsResponseEntity.setMessage("查询成功");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return httpsResponseEntity;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST , headers = "Accept=application/json")
    public HttpsResponseEntity AddTheMessage(@RequestBody  MessageEntity messageEntity)
    {
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        messageEntity.setSendTime(new Date());
        messageEntity.setFileAddressArray(uploadController.uploadMessage(messageEntity));
        try {
            int result = messageService.NewTheMessage(messageEntity);
            if(result==1)
            {
                httpsResponseEntity.setData(result);
                httpsResponseEntity.setCode("666");
                httpsResponseEntity.setMessage("消息添加成功");
            }
            else {
                httpsResponseEntity.setData(result);
                httpsResponseEntity.setCode("-1");
                httpsResponseEntity.setMessage("消息添加失败");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpsResponseEntity;
    }
}
