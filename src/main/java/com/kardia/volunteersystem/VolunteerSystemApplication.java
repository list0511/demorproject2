package com.kardia.volunteersystem;

import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.dao.mapper.UserEntityMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class VolunteerSystemApplication <T> {

    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Jedis jedis = new Jedis("localhost", 6379);
        String[] s= {"s", "s"};
        Map<String,Short> sSS= new HashMap<>();
        Class c =UserEntity.class;
        Method method=c.getDeclaredMethod("getId",null);
        UserEntity userEntity= UserEntity.class.newInstance();
        UserEntity user1=UserEntity.class.getConstructor().newInstance();
        method.invoke(userEntity);
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(in);
        SqlSession session=sqlSessionFactory.openSession();
        UserEntityMapper mapper = session.getMapper(UserEntityMapper.class);
        SpringApplication.run(VolunteerSystemApplication.class, args);
    }

}
