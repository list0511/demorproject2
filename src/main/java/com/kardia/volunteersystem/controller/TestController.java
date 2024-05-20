package com.kardia.volunteersystem.controller;

import com.kardia.volunteersystem.dao.entity.TestEntity;
import com.kardia.volunteersystem.service.TestService;
import com.kardia.volunteersystem.utils.HttpsResponseEntity;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {
    private final TestService testService;
    public TestController(TestService testService){
        this.testService = testService;
    }

    public UploadController uploadController = new UploadController();

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public HttpsResponseEntity addTest(@ModelAttribute TestEntity testEntity){
        HttpsResponseEntity httpsResponseEntity = new HttpsResponseEntity();
        testEntity.setTestPath(uploadController.uploadTest(testEntity));
        TestEntity testEntity1 = testService.NewTheTest(testEntity);
        httpsResponseEntity.setCode("1");
        httpsResponseEntity.setData(testEntity1);
        httpsResponseEntity.setMessage("测试添加成功");
        return httpsResponseEntity;
    }
}
