package com.kardia.volunteersystem;

import com.kardia.volunteersystem.controller.*;
import com.kardia.volunteersystem.dao.entity.*;
import com.kardia.volunteersystem.utils.HttpsResponseEntity;
import com.kardia.volunteersystem.utils.UUIDUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class VolunteerSystemApplicationTests {

    @Autowired
    private UserController userController;

    @Autowired
    private MissionController missionController;

    @Autowired
    private MissionRecordController missionRecordController;

    @Autowired
    private MarketController marketController;

    @Autowired
    private MessageController messageController;

    @Autowired
    private MomentController momentController;

    @Test
    void contextLoads() {
    }


    Logger log = LogManager.getLogger(VolunteerSystemApplicationTests.class);


    @Test
    public void testUserSelect(){
        UserEntity userEntity = new UserEntity();
        userEntity.setNickname("你是");
        HttpsResponseEntity httpsResponseEntity = userController.queryUserList(userEntity);
        log.info("---结果（queryUserList)---");
        log.info(httpsResponseEntity.toString());
    }

    @Test
    public void testAddTheUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId("testUser");
        HttpsResponseEntity httpsResponseEntity = userController.AddTheUser(userEntity);
        log.info("---结果（AddTheUser)---");
        log.info(httpsResponseEntity.toString());
    }

    @Test
    public void testUserLoginNotExist(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUIDUtil.getOneUUID());
        userEntity.setAccount("notExist");
        HttpsResponseEntity httpsResponseEntity = userController.UserLogin(userEntity);
        log.info("---结果（UserLoginNotExist)---");
        log.info(httpsResponseEntity.toString());
    }

    @Test
    public void testUserLoginWrongPwd(){
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("wrongPassword");
        HttpsResponseEntity httpsResponseEntity = userController.UserLogin(userEntity);
        log.info("---结果（UserLoginWrongPwd)---");
        log.info(httpsResponseEntity.toString());
    }

    @Test
    public void testUserLoginPass(){
        UserEntity userEntity = new UserEntity();
        HttpsResponseEntity httpsResponseEntity = userController.UserLogin(userEntity);
        log.info("---结果（UserLoginPass)---");
        log.info(httpsResponseEntity.toString());
    }

    @Test
    public void testAddTheMission(){
        //添加成功
        String[] exampleArray = {"apple"};
        MissionEntity missionEntity = new MissionEntity();
        missionEntity.setId(UUIDUtil.getOneUUID());
        HttpsResponseEntity httpsResponseEntity = missionController.AddTheMission(missionEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.getData().toString());
    }

    @Test
    public void testViewOpenMissions(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId("missioncreator");
        HttpsResponseEntity httpsResponseEntity = missionController.ViewOpenMissions(userEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.getData().toString());
    }

    @Test
    public void testViewClosedMissions(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId("missioncreator");
        HttpsResponseEntity httpsResponseEntity = missionController.ViewClosedMissions(userEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.getData());
    }

    @Test
    public void testViewPreMissions(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId("missioncreator");
        HttpsResponseEntity httpsResponseEntity = missionController.ViewPreMissions(userEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.getData());
    }


    @Test
    public void testAddTheRecord(){
        MissionRecordEntity missionRecord = new MissionRecordEntity();
        missionRecord.setId(UUIDUtil.getOneUUID());
        missionRecord.setVolunteerId("10");
        missionRecord.setChildId("10");

        HttpsResponseEntity httpsResponseEntity = missionRecordController.AddTheRecord(missionRecord);
        log.info("结果是："+httpsResponseEntity.getMessage());

    }

    @Test
    public void testModifyTheRecord(){
        MissionRecordEntity missionRecord = new MissionRecordEntity();
        missionRecord.setId("bc9d3a96b7bd4202a12471dc723f93fc");
        missionRecord.setVolunteerId("20");
        missionRecord.setChildId("6");

        HttpsResponseEntity httpsResponseEntity = missionRecordController.ModifyTheRecord(missionRecord);
        log.info("结果是："+httpsResponseEntity.getMessage());
    }


    @Test
    public void testZViewReadyRecord(){
        MissionEntity missionEntity = new MissionEntity();
        missionEntity.setId("missionid");
        HttpsResponseEntity httpsResponseEntity = missionRecordController.ZViewReadyRecord(missionEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.getData());
    }

    @Test
    public void testZViewAlreadyRecord(){
        MissionEntity missionEntity = new MissionEntity();
        missionEntity.setId("missionid");
        HttpsResponseEntity httpsResponseEntity = missionRecordController.ZViewAlreadyRecord(missionEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.getData());
    }

    //修改前的MarkTheRecord方法测试，已通过
//    @Test
//    public void testMarkTheRecord(){
//        MissionRecordEntity missionRecordEntity = new MissionRecordEntity();
//        missionRecordEntity.setStatus(3);
//        missionRecordEntity.setId("bc9d3a96b7bd4202a12471dc723f93fc");
//        missionRecordEntity.setEvaluationContent("好");
//        HttpsResponseEntity httpsResponseEntity = missionRecordController.MarkTheRecord(missionRecordEntity);
//        log.info("---结果---");
//        log.info(httpsResponseEntity.getData());
//    }

    @Test
    public void testSeeSelectMissions(){

        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUIDUtil.getOneUUID());
        userEntity.setType(1);
        userEntity.setAccount("1");
        userEntity.setPassword("1");
        userEntity.setBindArray(new String[]{"a"});

        HttpsResponseEntity httpsResponseEntity = missionController.SeeSelectMissions(userEntity);
        log.info("结果是："+httpsResponseEntity.getMessage());

    }

    @Test
    public void testSeeAcceptMissions(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId("1");
        userEntity.setType(1);
        userEntity.setAccount("1");
        userEntity.setPassword("1");

        HttpsResponseEntity httpsResponseEntity = missionRecordController.SeeAcceptMissions(userEntity);

        log.info("结果是："+httpsResponseEntity.getMessage());
    }

    @Test
    public void testSeeHistoryMissions(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId("1");
        userEntity.setType(1);
        userEntity.setAccount("1");
        userEntity.setPassword("1");

        HttpsResponseEntity httpsResponseEntity = missionRecordController.SeeHistoryMissions(userEntity);

        log.info("结果是："+httpsResponseEntity.getMessage());
    }

    @Test
    public void testQueryRecords(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUIDUtil.getOneUUID());
        userEntity.setType(1);
        userEntity.setAccount("1");
        userEntity.setPassword("1");

        HttpsResponseEntity httpsResponseEntity = missionRecordController.QueryRecordList(userEntity);
    }

    @Test
    public void testaddTheProduct(){
        MarketEntity marketEntity = new MarketEntity();
        marketEntity.setId(UUIDUtil.getOneUUID());
        HttpsResponseEntity httpsResponseEntity = marketController.addTheProduct(marketEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.getData());

    }
    @Test
    public void testviewAllProduct(){
        UserEntity userEntity =new UserEntity();
        HttpsResponseEntity httpsResponseEntity = marketController.viewAllProduct(userEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.getData());
    }

    @Test
    public void testaddTheOrder(){
        MarketOrderEntity marketOrderEntity = new MarketOrderEntity(UUIDUtil.getOneUUID(),"a","a","a",new Date(),0);
        HttpsResponseEntity httpsResponseEntity = marketController.addTheOrder(marketOrderEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.getData());
    }

    @Test
    public void testprocessTheOrder(){
        MarketOrderEntity marketOrderEntity = new MarketOrderEntity("65e673e6572a4cb085a61047d3a8c569","a","a","a",null,1);
        HttpsResponseEntity httpsResponseEntity = marketController.processTheOrder(marketOrderEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.getData());
    }

    @Test
    public void testviewAllOrder(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId("b");
        HttpsResponseEntity httpsResponseEntity = marketController.viewAllOrder(userEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.getData());
    }

    @Test
    public void testviewAlreadyOrder(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId("a");
        HttpsResponseEntity httpsResponseEntity = marketController.viewAlreadyOrder(userEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.toString());
    }

    @Test
    public void testGetAllChildren(){
        UserEntity userEntity = new UserEntity();
        HttpsResponseEntity httpsResponseEntity =userController.getAllChildren();
        log.info("---结果是---");
        log.info(httpsResponseEntity.getData());

    }


    @Test
    public void testGetMYChildren(){

        UserEntity userEntity = new UserEntity();
        userEntity.setId("b87d224935de42168ca986ab921196cb");
        HttpsResponseEntity httpsResponseEntity =userController.getMyChildren(userEntity);
        log.info("---结果是---");
        log.info(httpsResponseEntity.getData());

    }

    @Test
    public void testGetTheChild(){

        UserEntity userEntity = new UserEntity();
        userEntity.setId("1");
        HttpsResponseEntity httpsResponseEntity =userController.getTheChild(userEntity);
        log.info("---结果是---");
        log.info(httpsResponseEntity.toString());

    }

    @Test
    public void testMark(){
        MissionRecordEntity missionRecordEntity = new MissionRecordEntity();
        missionRecordEntity.setId("9d9fd7b2289049b08bbbc86e370d62ec");
        missionRecordEntity.setStatus(2);
        missionRecordEntity.setEvaluationContent("干得漂亮");
        missionRecordEntity.setObtainScore(100);

        HttpsResponseEntity httpsResponseEntity = missionRecordController.MarkTheRecord(missionRecordEntity);

        log.info("---结果是---");
        log.info(httpsResponseEntity.getMessage());
    }

    @Test
    public void testAddTheMessage(){
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setId(UUIDUtil.getOneUUID());
        messageEntity.setUserSend("7458");
        messageEntity.setUserReceive("7125");
        messageEntity.setType(1);
        messageEntity.setText("hello");
        messageEntity.setFileAddressArray(new String[]{"4125"});
        HttpsResponseEntity httpsResponseEntity = messageController.AddTheMessage(messageEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.getData());
    }

    @Test
    public void testQueryMessage(){
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setUserSend("7458");
        messageEntity.setUserReceive("7125");
        HttpsResponseEntity httpsResponseEntity = messageController.queryMessageList(messageEntity);
        log.info("---结果---");
        log.info(httpsResponseEntity.getData());
    }

    @Test
    public void testAddMoment(){
        MomentEntity momentEntity = new MomentEntity();
        momentEntity.setUserSend("9d2e57bfd3584e838f661dc70bd28653");
        HttpsResponseEntity httpsResponseEntity = momentController.AddMoment(momentEntity);
        log.info("---结果（AddMoment)---");
        log.info(httpsResponseEntity.toString());
    }

    @Test
    public void testMomentQuery(){
        MomentEntity momentEntity = new MomentEntity();
        HttpsResponseEntity httpsResponseEntity = momentController.QueryMoment(momentEntity);
        log.info("---结果（QueryMoment)---");
        log.info(httpsResponseEntity.toString());
    }

    @Test
    public void testMomentSelect(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId("9d2e57bfd3584e838f661dc70bd28653");
        userEntity.setBindArray(new String[]{"b4b45b3e867d4e58b765ba505cbeab75","354c028927f44199ba6c5e20e5e6305d"});
        HttpsResponseEntity httpsResponseEntity = momentController.SelectMoment(userEntity);
        log.info("---结果（SelectMoment)---");
        log.info(httpsResponseEntity.toString());
    }

    @Test
    public void testModifyMoment(){
        MomentEntity momentEntity = new MomentEntity();
        momentEntity.setId("momentid");
        momentEntity.setType(1);
        HttpsResponseEntity httpsResponseEntity = momentController.ModifyMoment(momentEntity);
        log.info("---结果（ModifyMoment)---");
        log.info(httpsResponseEntity.toString());
    }

    @Test
    public void testDeleteMoment(){
        MomentEntity momentEntity = new MomentEntity();
        momentEntity.setId("testdelete");
        HttpsResponseEntity httpsResponseEntity = momentController.DeleteMoment(momentEntity);
        log.info("---结果（DeleteMoment)---");
        log.info(httpsResponseEntity.toString());
    }

    @Test
    public void testAddTheComment(){
        HttpsResponseEntity httpsResponseEntity = momentController.AddTheComment("0f22c19e781a4faabe53235fae1373dc"
                ,"9d2e57bfd3584e838f661dc70bd28653","哈哈哈2");
        log.info("---结果（AddTheMoment)---");
        log.info(httpsResponseEntity.toString());
    }


}
