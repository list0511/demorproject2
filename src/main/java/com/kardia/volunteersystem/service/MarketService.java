package com.kardia.volunteersystem.service;

import com.kardia.volunteersystem.dao.entity.MarketEntity;
import com.kardia.volunteersystem.dao.entity.MarketOrderEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.dao.mapper.MarketEntityMapper;
import com.kardia.volunteersystem.utils.UUIDUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    private final MarketEntityMapper marketEntityMapper;


    public MarketService(MarketEntityMapper marketEntityMapper){
        this.marketEntityMapper=marketEntityMapper;
    }



    /**
     * 返回包含全部商品信息的List
     */
    public List<MarketEntity>  viewAllP(UserEntity userEntity){
        List<MarketEntity> result = marketEntityMapper.queryMarketList();
        return result;
    }

    /**
     * 将新增商品信息存入数据库，新增成功，返回该商品现有的信息；新增失败（其实不会失败），返回信息中id为-1
     */
    public MarketEntity  newTheProduct(MarketEntity marketEntity){
        marketEntity.setId(UUIDUtil.getOneUUID());
        int result = marketEntityMapper.insertMarket(marketEntity);
        if(result !=0){
            return marketEntity;
        }
        else{
            marketEntity.setId("-1");
            return marketEntity;
        }
    }

    public List<MarketEntity> sortMarketList(List<MarketEntity> marketEntities){
        marketEntities=marketEntityMapper.sortMarketList(marketEntities);
        return marketEntities;
    }

    public List<MarketEntity> selectMarketById(MarketOrderEntity marketOrderEntity){
        List<MarketEntity> marketEntities=marketEntityMapper.selectMarketById(marketOrderEntity);
        return marketEntities;
    }

}
