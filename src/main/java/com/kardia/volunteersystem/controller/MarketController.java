package com.kardia.volunteersystem.controller;

import com.kardia.volunteersystem.dao.entity.MarketEntity;
import com.kardia.volunteersystem.dao.entity.MarketOrderEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.service.MarketOrderService;
import com.kardia.volunteersystem.service.MarketService;
import com.kardia.volunteersystem.utils.HttpsResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/market")
@CrossOrigin
public class MarketController {

    private final MarketService marketService;
    private final MarketOrderService marketOrderService;
    public MarketController(MarketService marketService, MarketOrderService marketOrderService){
        this.marketService = marketService;
        this.marketOrderService = marketOrderService;
    }

    public UploadController uploadController = new UploadController();


    @RequestMapping(value="/newproduct",consumes = "application/json")
    @ResponseBody
    public HttpsResponseEntity addTheProduct(@RequestBody MarketEntity marketEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        marketEntity.setFileAddress(uploadController.uploadMarket(marketEntity));
        MarketEntity result = marketService.newTheProduct(marketEntity);
        httpsResponseEntity.setCode("666");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("成功");
        return httpsResponseEntity;
    }

    @RequestMapping(value="/viewproduct",consumes = "application/json")
    public HttpsResponseEntity viewAllProduct(@RequestBody UserEntity userEntity){
        System.out.println("ViewProduct");
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MarketEntity> result = marketService.viewAllP(userEntity);
        List<MarketEntity> modifiedResult = new ArrayList<>(); // 创建一个新的列表来存储经过处理后的 MarketEntity
        for (MarketEntity marketEntity : result) {
            modifiedResult.add(uploadController.downloadMarket(marketEntity)); // 将处理后的 marketEntity 添加到新的列表中
            System.out.println(Arrays.deepToString(marketEntity.getFileData()));
        }

        httpsResponseEntity.setCode("666");
        httpsResponseEntity.setData(modifiedResult);
        httpsResponseEntity.setMessage("成功");
        return httpsResponseEntity;
    }

    @RequestMapping(value="/selectMarketById",consumes = "application/json")
    public HttpsResponseEntity selectMarketById(@RequestBody MarketOrderEntity marketOrderEntity
    ){
        System.out.println("ViewProduct");
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MarketEntity> result = marketService.selectMarketById(marketOrderEntity);
        httpsResponseEntity.setCode("666");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("成功");
        return httpsResponseEntity;
    }

    @RequestMapping(value="/vieworder",consumes = "application/json")
    public HttpsResponseEntity viewAllOrder(@RequestBody UserEntity userEntity){
        System.out.println("viewAllOrders"+userEntity.toString());

        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MarketOrderEntity> result = marketOrderService.viewAllO(userEntity);
        System.out.println("viewAllOrders"+result.toString());
        httpsResponseEntity.setCode("666");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("成功");
        return httpsResponseEntity;
    }

    @RequestMapping(value="/childvieworder",consumes = "application/json")
    public HttpsResponseEntity childviewAllOrder(@RequestBody UserEntity userEntity){
        System.out.println("childviewAllOrders"+userEntity.toString());

        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MarketOrderEntity> result = marketOrderService.childviewAllOrder(userEntity);
        System.out.println("childviewAllOrders"+result.toString());
        httpsResponseEntity.setCode("666");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("成功");
        return httpsResponseEntity;
    }

    @RequestMapping(value="/processorder",consumes = "application/json")
    public HttpsResponseEntity processTheOrder(@RequestBody MarketOrderEntity marketOrderEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        MarketOrderEntity result = marketOrderService.processTheO(marketOrderEntity);
        httpsResponseEntity.setCode("666");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("成功");
        return httpsResponseEntity;
    }

    @RequestMapping(value="/neworder",consumes = "application/json")
    public HttpsResponseEntity addTheOrder(@RequestBody MarketOrderEntity marketOrderEntity){
        marketOrderEntity.setTime(new Date());
        System.out.println("new Oder");

        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        MarketOrderEntity result = marketOrderService.addTheO(marketOrderEntity);
        httpsResponseEntity.setCode("666");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("成功");
        return httpsResponseEntity;
    }

    @RequestMapping(value = "/viewalreadyorder", consumes = "application/json")
    public HttpsResponseEntity viewAlreadyOrder(@RequestBody UserEntity userEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MarketOrderEntity> result = marketOrderService.viewAlready(userEntity);
        httpsResponseEntity.setCode("666");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("成功");
        return httpsResponseEntity;
    }

    @RequestMapping(value = "/sortmarket", consumes = "application/json")
    public HttpsResponseEntity sortMarketEntity(@RequestBody List<MarketEntity> marketEntities){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        List<MarketEntity> result = marketService.sortMarketList(marketEntities);
        httpsResponseEntity.setCode("666");
        httpsResponseEntity.setData(result);
        httpsResponseEntity.setMessage("成功");
        return httpsResponseEntity;
    }


}

