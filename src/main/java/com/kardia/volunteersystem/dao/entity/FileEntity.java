package com.kardia.volunteersystem.dao.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FileEntity implements Serializable {
    private byte[][] fileData;

    //字节流二维数组，用来存文件内容
    private String[] fileName;
    //字符串数组，用来存文件名
    private String[] fileExtend;
    //字符串数组，用来存扩展名

    public byte[][] getFileData() {
        return fileData;
    }

    public void setFileData(byte[][] fileData) {
        this.fileData = fileData;
    }

    public String[] getFileName() {
        return fileName;
    }

    public void setFileName(String[] fileName) {
        this.fileName = fileName;
    }

    public String[] getFileExtend() {
        return fileExtend;
    }

    public void setFileExtend(String[] fileExtend) {
        this.fileExtend = fileExtend;
    }

    public List<File> convertToFile(byte[][] fileData, String[] fileName, String[] fileExtend){
        List<File> tempFiles = new ArrayList<>();
        for(int i=0;i<fileExtend.length;i++){
            try {
                File tempFile = File.createTempFile(fileName[i], "."+fileExtend[i]);
                tempFiles.add(tempFile);
                FileOutputStream outputStream = new FileOutputStream(tempFile);
                outputStream.write(fileData[i]);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tempFiles;
    }
}
