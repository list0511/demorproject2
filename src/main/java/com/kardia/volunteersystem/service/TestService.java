package com.kardia.volunteersystem.service;

import com.kardia.volunteersystem.dao.entity.TestEntity;
import com.kardia.volunteersystem.dao.mapper.TestEntityMapper;
import com.kardia.volunteersystem.utils.UUIDUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestEntityMapper testEntityMapper;
    public TestService(TestEntityMapper testEntityMapper){
        this.testEntityMapper = testEntityMapper;
    }

    public TestEntity NewTheTest(TestEntity testEntity){
        testEntity.setTestId(UUIDUtil.getOneUUID());
        testEntityMapper.insertTest(testEntity);
        return testEntity;
    }

    public List<TestEntity> queryTestList(TestEntity testEntity){
        List<TestEntity> testEntities = testEntityMapper.queryTest(testEntity);
        return testEntities;
    }
}
