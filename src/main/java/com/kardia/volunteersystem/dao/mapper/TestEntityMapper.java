package com.kardia.volunteersystem.dao.mapper;

import com.kardia.volunteersystem.dao.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestEntityMapper {
    int insertTest(TestEntity testEntity);
    List<TestEntity> queryTest(TestEntity testEntity);
}
