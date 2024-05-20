package com.kardia.volunteersystem.service;

import com.kardia.volunteersystem.dao.entity.MarketEntity;
import com.kardia.volunteersystem.dao.entity.MarketOrderEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.dao.mapper.MarketOrderEntityMapper;
import com.kardia.volunteersystem.utils.UUIDUtil;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketOrderService implements BeanPostProcessor {
    private final MarketOrderEntityMapper marketOrderEntityMapper;

    public MarketOrderService(MarketOrderEntityMapper marketOrderEntityMapper){
        this.marketOrderEntityMapper=marketOrderEntityMapper;
    }

    /**
     * 根据传入的志愿者信息，回传此志愿者的全部未处理订单
     */
    public List<MarketOrderEntity> viewAllO(UserEntity userEntity){
        List<MarketOrderEntity> list = marketOrderEntityMapper.vieworder(userEntity);
        return list;
    }



    public List<MarketOrderEntity> childviewAllOrder(UserEntity userEntity){
        List<MarketOrderEntity> list = marketOrderEntityMapper.childvieworder(userEntity);
        return list;
    }

    public List<MarketOrderEntity> viewAlready(UserEntity userEntity){
        List<MarketOrderEntity> list = marketOrderEntityMapper.viewalreadyorder(userEntity);
        return list;
    }

    /**
     * 根据传入的的订单记录entity，更新数据库
     */
    public MarketOrderEntity processTheO(MarketOrderEntity marketOrderEntity){
        int result = marketOrderEntityMapper.modifyOrder(marketOrderEntity);
        if(result!=0){
            return marketOrderEntity;
        }
        else{
            marketOrderEntity.setId("-1");
            return marketOrderEntity;
        }
    }

    /**
     * 将新增订单信息存入数据库，新增成功，返回该订单现有的信息；新增失败（其实不会失败），返回信息中id为-1
     */
    public MarketOrderEntity addTheO(MarketOrderEntity marketOrderEntity){
        marketOrderEntity.setId(UUIDUtil.getOneUUID());
        int result = marketOrderEntityMapper.insertOrder(marketOrderEntity);
        if(result!=0){
            return marketOrderEntity;
        }
        else{
            marketOrderEntity.setId("-1");
            return marketOrderEntity;
        }
    }


}
