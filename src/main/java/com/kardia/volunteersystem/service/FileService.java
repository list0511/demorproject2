package com.kardia.volunteersystem.service;

import com.kardia.volunteersystem.dao.entity.FileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.ResourceBundle;

@Mapper
public class FileService {
    public File getTheFile(String path){

        return new File(path);
    }

}
