package com.kardia.volunteersystem.dao.mapper;

import com.kardia.volunteersystem.dao.entity.MessageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
@Mapper
public interface MessageEntityMapper {
    List<MessageEntity> queryMessageList(MessageEntity messageEntity);

    int addMessage(MessageEntity messageEntity);


}
