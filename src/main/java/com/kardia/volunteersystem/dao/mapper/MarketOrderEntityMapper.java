package com.kardia.volunteersystem.dao.mapper;

import com.kardia.volunteersystem.dao.entity.MarketOrderEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MarketOrderEntityMapper {

    List<MarketOrderEntity> queryOrderList(MarketOrderEntity marketOrderEntity);



    int deleteOrder(MarketOrderEntity marketOrderEntity);

    int insertOrder(MarketOrderEntity marketOrderEntity);

    int modifyOrder(MarketOrderEntity marketOrderEntity);

    List<MarketOrderEntity> vieworder(UserEntity userEntity);


    List<MarketOrderEntity> childvieworder(UserEntity userEntity);
    List<MarketOrderEntity> viewalreadyorder(UserEntity userEntity);



}

