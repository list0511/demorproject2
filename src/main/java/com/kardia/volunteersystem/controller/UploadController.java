package com.kardia.volunteersystem.controller;

import com.kardia.volunteersystem.dao.entity.*;
import com.kardia.volunteersystem.utils.UUIDUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UploadController {
//    @GetMapping("/upload")
//    public String upload(){
//        return "upload";
//    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file){
        if(file!=null && file.getOriginalFilename()!=null){
            String originalFilename = file.getOriginalFilename();
            String extend = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newName = UUIDUtil.getOneUUID();
            ApplicationHome applicationHome = new ApplicationHome(this.getClass());
            String path = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath() +
                    "\\src\\main\\resources\\static\\images\\" + newName +extend;
            try {
                File file1 = new File(path);
                file.transferTo(file1);
                return file1.getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "uploadFailed";
    }


    //将本地（安卓设备）的文件上传到服务器
    @PostMapping("/uploadUser")
    @ResponseBody
    public String[] uploadUser(@RequestBody UserEntity userEntity){
        List<String> filePaths = new ArrayList<>();
        if(userEntity.getFileData()!=null){
            byte[][] fileBytes = userEntity.getFileData();
            int fileCount = userEntity.getFileExtend().length;
            if(fileBytes.length>0){
                String[] filename = UUIDUtil.getUUID(fileCount);
                String[] extensions = userEntity.getFileExtend();
                ApplicationHome applicationHome = new ApplicationHome(this.getClass());
                for(int i=0;i<fileCount;i++){
                    String path = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath()
                            + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                            + File.separator + "static" + File.separator + "users" + File.separator + filename[i]
                            + extensions[i];
                    try {
                        File file = new File(path);
                        FileUtils.writeByteArrayToFile(file, fileBytes[i]);
                        filePaths.add(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return filePaths.toArray(new String[0]);
    }

    @PostMapping("/uploadMission")
    @ResponseBody
    public String[] uploadMission(@RequestBody MissionEntity missionEntity){
        List<String> filePaths = new ArrayList<>();
        if(missionEntity.getFileData()!=null){
            byte[][] fileBytes = missionEntity.getFileData();
            int fileCount = missionEntity.getFileExtend().length;
            if(fileBytes.length>0){
                String[] filename = UUIDUtil.getUUID(fileCount);
                String[] extensions = missionEntity.getFileExtend();
                ApplicationHome applicationHome = new ApplicationHome(this.getClass());
                for(int i=0;i<fileCount;i++){
                    String path = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath()
                            + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                            + File.separator + "static" + File.separator + "missions" + File.separator + filename[i]
                            + extensions[i];
                    try {
                        File file = new File(path);
                        FileUtils.writeByteArrayToFile(file, fileBytes[i]);
                        filePaths.add(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return filePaths.toArray(new String[0]);
    }

    @PostMapping("/uploadMissionRecord")
    @ResponseBody
    public String[] uploadMissionRecord(@RequestBody MissionRecordEntity missionRecordEntity){
        List<String> filePaths = new ArrayList<>();
        if(missionRecordEntity.getFileData()!=null){
            byte[][] fileBytes = missionRecordEntity.getFileData();
            int fileCount = missionRecordEntity.getFileExtend().length;
            if(fileBytes.length>0){
                String[] filename = UUIDUtil.getUUID(fileCount);
                String[] extensions = missionRecordEntity.getFileExtend();
                ApplicationHome applicationHome = new ApplicationHome(this.getClass());
                for(int i=0;i<fileCount;i++){
                    String path = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath()
                            + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                            + File.separator + "static" + File.separator + "missionrecords" + File.separator + filename[i]
                            + extensions[i];
                    try {
                        File file = new File(path);
                        FileUtils.writeByteArrayToFile(file, fileBytes[i]);
                        filePaths.add(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return filePaths.toArray(new String[0]);
    }

    @PostMapping("/uploadMarket")
    @ResponseBody
    public String[] uploadMarket(@RequestBody MarketEntity marketEntity){
        List<String> filePaths = new ArrayList<>();
        if(marketEntity.getFileData()!=null){
            byte[][] fileBytes = marketEntity.getFileData();
            int fileCount = marketEntity.getFileExtend().length;
            if(fileBytes.length>0){
                String[] filename = UUIDUtil.getUUID(fileCount);
                String[] extensions = marketEntity.getFileExtend();
                ApplicationHome applicationHome = new ApplicationHome(this.getClass());
                for(int i=0;i<fileCount;i++){
                    String path = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath()
                            + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                            + File.separator + "static" + File.separator + "markets" + File.separator + filename[i]
                            + extensions[i];
                    try {
                        File file = new File(path);
                        FileUtils.writeByteArrayToFile(file, fileBytes[i]);
                        filePaths.add(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return filePaths.toArray(new String[0]);
    }

    @PostMapping("/uploadMoment")
    @ResponseBody
    public String[] uploadMoment(@RequestBody MomentEntity momentEntity){
        List<String> filePaths = new ArrayList<>();
        if(momentEntity.getFileData()!=null){
            byte[][] fileBytes = momentEntity.getFileData();
            int fileCount = fileBytes.length;
            if(fileBytes.length>0){
                String[] filename = UUIDUtil.getUUID(fileCount);
                String[] extensions = momentEntity.getFileExtend();
                ApplicationHome applicationHome = new ApplicationHome(this.getClass());
                for(int i=0;i<fileCount;i++){
                    String path = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath()
                            + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                            + File.separator + "static" + File.separator + "moments" + File.separator + filename[i]
                            + extensions[i];
                    try {
                        File file = new File(path);
                        FileUtils.writeByteArrayToFile(file, fileBytes[i]);
                        filePaths.add(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return filePaths.toArray(new String[0]);
    }

    @PostMapping("/uploadMessage")
    @ResponseBody
    public String[] uploadMessage(@RequestBody MessageEntity messageEntity){
        List<String> filePaths = new ArrayList<>();
        if(messageEntity.getFileData()!=null){
            byte[][] fileBytes = messageEntity.getFileData();
            int fileCount = messageEntity.getFileExtend().length;
            if(fileBytes.length>0){
                String[] filename = UUIDUtil.getUUID(fileCount);
                String[] extensions = messageEntity.getFileExtend();
                ApplicationHome applicationHome = new ApplicationHome(this.getClass());
                for(int i=0;i<fileCount;i++){
                    String path = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath()
                            + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                            + File.separator + "static" + File.separator + "messages" + File.separator + filename[i]
                            + extensions[i];
                    try {
                        File file = new File(path);
                        FileUtils.writeByteArrayToFile(file, fileBytes[i]);
                        filePaths.add(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return filePaths.toArray(new String[0]);
    }




    //将服务器上的文件下载到本地（安卓设备）
    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename){
        try {
            File file = new File(filename.substring(filename.lastIndexOf("/")));
            Resource resource = new UrlResource(file.toURI());

            if(resource.exists()){
                return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename()+"\"").body(resource);
            }else{
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping("/uploadTest")
    @ResponseBody
    public String[] uploadTest(TestEntity testEntity) {
        byte[][] fileBytes = testEntity.getFileData();
        int fileCount = testEntity.getFileExtend().length;
        System.out.println("fileCount:" + fileCount+",fileBytes:" + fileBytes.length);
        List<String> filePaths = new ArrayList<>();
        if(fileBytes.length>0){
            String[] filename = UUIDUtil.getUUID(fileCount);
            String[] extensions = testEntity.getFileExtend();
            ApplicationHome applicationHome = new ApplicationHome(this.getClass());
            for(int i=0;i<fileCount;i++){
                String path = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath()
                        + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                        + File.separator + "static" + File.separator + "tests" + File.separator + filename[i]
                        + extensions[i];
                System.out.println("path:" + path);
                try {
                    File file = new File(path);
                    FileUtils.writeByteArrayToFile(file, fileBytes[i]);
                    filePaths.add(path);
                } catch (IOException e) {
                    System.out.println("Exception here");
                    e.printStackTrace();
                }
            }
        }
        return filePaths.toArray(new String[0]);
    }


    @GetMapping("/downloadUser")
    @ResponseBody
    public UserEntity downloadUser(UserEntity userEntity){
        String[] filePath = userEntity.getPic();
        List<String> fileExtends = new ArrayList<>();
        List<String> fileNames = new ArrayList<>();
        List<byte[]> fileDatas = new ArrayList<>();
        if(null!=filePath) {
            for (int i = 0; i < filePath.length; i++) {
                String fileExtend = filePath[i].substring(filePath[i].lastIndexOf("."));
                fileExtends.add(fileExtend);
                String fileName = filePath[i].substring(0, filePath[i].lastIndexOf("."));
                fileNames.add(fileName);
                try {
                    byte[] fileData = Files.readAllBytes(new File(filePath[i]).toPath());
                    fileDatas.add(fileData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        userEntity.setFileExtend(fileExtends.toArray(new String[0]));
        userEntity.setFileName(fileNames.toArray(new String[0]));
        userEntity.setFileData(fileDatas.toArray(new byte[0][]));

        return userEntity;
    }

    @GetMapping("/downloadMission")
    public MissionEntity downloadMission(MissionEntity missionEntity){
        String[] filePath = missionEntity.getFileAddressArray();
        List<String> fileExtends = new ArrayList<>();
        List<String> fileNames = new ArrayList<>();
        List<byte[]> fileDatas = new ArrayList<>();
        for(int i=0;i<filePath.length;i++){
            String fileExtend = filePath[i].substring(filePath[i].lastIndexOf("."));
            fileExtends.add(fileExtend);
            String fileName = filePath[i].substring(0, filePath[i].lastIndexOf("."));
            fileNames.add(fileName);
            try {
                byte[] fileData = Files.readAllBytes(new File(filePath[i]).toPath());
                fileDatas.add(fileData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        missionEntity.setFileExtend(fileExtends.toArray(new String[0]));
        missionEntity.setFileName(fileNames.toArray(new String[0]));
        missionEntity.setFileData(fileDatas.toArray(new byte[0][]));

        return missionEntity;
    }

    @GetMapping("/downloadMissionRecord")
    @ResponseBody
    public MissionRecordEntity downloadMissionRecord(MissionRecordEntity missionRecordEntity){
        String[] filePath = missionRecordEntity.getMisfileAddressArray();
        List<String> fileExtends = new ArrayList<>();
        List<String> fileNames = new ArrayList<>();
        List<byte[]> fileDatas = new ArrayList<>();
        for(int i=0;i<filePath.length;i++){
            String fileExtend = filePath[i].substring(filePath[i].lastIndexOf("."));
            fileExtends.add(fileExtend);
            String fileName = filePath[i].substring(0, filePath[i].lastIndexOf("."));
            fileNames.add(fileName);
            try {
                byte[] fileData = Files.readAllBytes(new File(filePath[i]).toPath());
                fileDatas.add(fileData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        missionRecordEntity.setFileExtend(fileExtends.toArray(new String[0]));
        missionRecordEntity.setFileName(fileNames.toArray(new String[0]));
        missionRecordEntity.setFileData(fileDatas.toArray(new byte[0][0]));

        return missionRecordEntity;
    }

    @GetMapping("/downloadMarket")
    @ResponseBody
    public MarketEntity downloadMarket(MarketEntity marketEntity){
        String[] filePath = marketEntity.getFileAddress();
        List<String> fileExtends = new ArrayList<>();
        List<String> fileNames = new ArrayList<>();
        List<byte[]> fileDatas = new ArrayList<>();
        for(int i=0;i<filePath.length;i++){
            String fileExtend = filePath[i].substring(filePath[i].lastIndexOf("."));
            fileExtends.add(fileExtend);
            String fileName = filePath[i].substring(0, filePath[i].lastIndexOf("."));
            fileNames.add(fileName);
            try {
                byte[] fileData = Files.readAllBytes(new File(filePath[i]).toPath());
                fileDatas.add(fileData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        marketEntity.setFileExtend(fileExtends.toArray(new String[0]));
        marketEntity.setFileName(fileNames.toArray(new String[0]));
        marketEntity.setFileData(fileDatas.toArray(new byte[0][0]));

        return marketEntity;
    }

    @GetMapping("/downloadMoment")
    @ResponseBody
    public MomentEntity downloadMoment(MomentEntity momentEntity){
        String[] filePath = momentEntity.getFileAddressArray();
        List<String> fileExtends = new ArrayList<>();
        List<String> fileNames = new ArrayList<>();
        List<byte[]> fileDatas = new ArrayList<>();
        for(int i=0;i<filePath.length;i++){
            String fileExtend = filePath[i].substring(filePath[i].lastIndexOf("."));
            fileExtends.add(fileExtend);
            String fileName = filePath[i].substring(0, filePath[i].lastIndexOf("."));
            fileNames.add(fileName);
            try {
                byte[] fileData = Files.readAllBytes(new File(filePath[i]).toPath());
                fileDatas.add(fileData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        momentEntity.setFileExtend(fileExtends.toArray(new String[0]));
        momentEntity.setFileName(fileNames.toArray(new String[0]));
        momentEntity.setFileData(fileDatas.toArray(new byte[0][0]));

        return momentEntity;
    }

    @GetMapping("/downloadMessage")
    @ResponseBody
    public MessageEntity downloadMessage(MessageEntity messageEntity){
        String[] filePath = messageEntity.getFileAddressArray();
        List<String> fileExtends = new ArrayList<>();
        List<String> fileNames = new ArrayList<>();
        List<byte[]> fileDatas = new ArrayList<>();
        for(int i=0;i<filePath.length;i++){
            String fileExtend = filePath[i].substring(filePath[i].lastIndexOf("."));
            fileExtends.add(fileExtend);
            String fileName = filePath[i].substring(0, filePath[i].lastIndexOf("."));
            fileNames.add(fileName);
            try {
                byte[] fileData = Files.readAllBytes(new File(filePath[i]).toPath());
                fileDatas.add(fileData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        messageEntity.setFileExtend(fileExtends.toArray(new String[0]));
        messageEntity.setFileName(fileNames.toArray(new String[0]));
        messageEntity.setFileData(fileDatas.toArray(new byte[0][0]));

        return messageEntity;
    }
}
