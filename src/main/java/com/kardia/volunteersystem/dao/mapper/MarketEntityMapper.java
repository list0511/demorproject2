package com.kardia.volunteersystem.dao.mapper;

import com.kardia.volunteersystem.dao.entity.MarketEntity;
import com.kardia.volunteersystem.dao.entity.MarketOrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.stream.BaseStream;

@Repository
@Component
@Mapper
public interface MarketEntityMapper extends BaseStream {

    /**
     * 显示全部商品列表
     */
    List<MarketEntity> queryMarketList( );

    /**
     * 增加商品
     */
    int insertMarket(MarketEntity marketEntity);

    /**
     * 修改商品信息
     */
    int updateMarket(MarketEntity marketEntity);

    /**
     * 删除商品
     */
    int deleteMarket(MarketEntity marketEntity);

    /**
     * 查询商品（按名称,价格,类型,提供者）
     */
    List<MarketEntity> selectMarketBySomething(MarketEntity marketEntity);
    List<MarketEntity> sortMarketList(List<MarketEntity> marketEntities);

    List<MarketEntity> selectMarketById(MarketOrderEntity marketOrderEntity);
}
