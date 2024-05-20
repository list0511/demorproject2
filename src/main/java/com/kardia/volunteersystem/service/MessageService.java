package com.kardia.volunteersystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kardia.volunteersystem.dao.entity.MessageEntity;
import com.kardia.volunteersystem.dao.entity.MissionEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.dao.mapper.MessageEntityMapper;
import com.kardia.volunteersystem.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {
    private final MessageEntityMapper messageEntityMapper;

    public MessageService(MessageEntityMapper messageEntityMapper) {
        this.messageEntityMapper = messageEntityMapper;
    }

    public int  NewTheMessage(MessageEntity messageEntity){
        try{
            messageEntity.setSendTime(new Date());
            System.out.println(messageEntity);
            messageEntity.setId(UUIDUtil.getOneUUID());
            return messageEntityMapper.addMessage(messageEntity);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public List<MessageEntity> ShowChatList(MessageEntity messageEntity){
        List<MessageEntity> list=messageEntityMapper.queryMessageList(messageEntity);
        return list;
    }
}
