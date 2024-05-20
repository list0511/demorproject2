package com.kardia.volunteersystem.service;



import com.kardia.volunteersystem.dao.entity.MomentEntity;
import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.dao.mapper.MomentEntityMapper;
import com.kardia.volunteersystem.dao.mapper.UserEntityMapper;
import com.kardia.volunteersystem.utils.UUIDUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MomentService {
    private final MomentEntityMapper momentEntityMapper;
    private final UserEntityMapper userEntityMapper;

    public MomentService(MomentEntityMapper momentEntityMapper, UserEntityMapper userEntityMapper){
        this.momentEntityMapper =momentEntityMapper;
        this.userEntityMapper = userEntityMapper;
    }

    /**
     *将志愿者新建的任务存入数据库
     */
    public  MomentEntity  AddMoment(MomentEntity momentEntity){
        try{
            momentEntity.setId(UUIDUtil.getOneUUID());
            momentEntityMapper.insertMoment(momentEntity);
            return momentEntity;
        }catch (Exception e){
            MomentEntity momentEntity1 = new MomentEntity();
            momentEntity1.setId("-1");
            e.printStackTrace();
            return momentEntity1;
        }
    }

    public  MomentEntity  ModifyMoment(MomentEntity momentEntity){
        try{
            momentEntityMapper.modifyMoment(momentEntity);
            return momentEntity;
        }catch (Exception e){
            MomentEntity momentEntity1 = new MomentEntity();
            momentEntity1.setId("-1");
            e.printStackTrace();
            return momentEntity1;
        }
    }

    public  MomentEntity  DeleteMoment(MomentEntity momentEntity){
        try{
            momentEntityMapper.deleteMoment(momentEntity);
            return momentEntity;
        }catch (Exception e){
            MomentEntity momentEntity1 = new MomentEntity();
            momentEntity1.setId("-1");
            e.printStackTrace();
            return momentEntity1;
        }
    }

    //通过用户id,查询该用户的帖子列表
    public List<MomentEntity>  SelectByUserId(UserEntity userEntity){

        List<MomentEntity> list = momentEntityMapper.selectMomentByUserId(userEntity);
        System.out.println(userEntity.getId());
        System.out.println(list.size());
//        System.out.println(list.get(0).toString());
        return list;
    }

    public List<MomentEntity>  QueryMoment(MomentEntity momentEntity){

        List<MomentEntity> list = momentEntityMapper.queryMomentList(momentEntity);
        return list;
    }
    public List<MomentEntity>  SortMomentByTime(List<MomentEntity> momentEntityList){

        momentEntityList.sort(Comparator.comparing(MomentEntity::getTime).reversed());
        return momentEntityList;
    }


    public int getScore(String momentEntity,String userEntity)
    {
        MomentEntity momentEntity1 = new MomentEntity();
        momentEntity1.setId(momentEntity);

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setId(userEntity);

        MomentEntity momentEntity2 = momentEntityMapper.selectCheckedMoment(momentEntity1);
        UserEntity userEntity2 = userEntityMapper.selectCheckMomentChild(userEntity1);

        UserEntity userEntity3 = new UserEntity();
        userEntity3.setId(userEntity2.getId());
        userEntity3.setScoreTotal(momentEntity2.getScore());

        int result = userEntityMapper.addMomentScore(userEntity3);

        return result;
    }

    /**
     * 添加评论
     */
    public int addTheComment(String MomentId,String UserID,String comment){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UserID);
        List<UserEntity> userList = userEntityMapper.selectUserById(userEntity);
        MomentEntity momentEntity = new MomentEntity();
        momentEntity.setId(MomentId);
        MomentEntity moment = momentEntityMapper.selectMomentById(momentEntity);
        List<String[]> commentList = moment.getCommentsArray();
        if (commentList == null) {
            commentList = new ArrayList<>();
        }
        commentList.add(new String[]{userList.get(0).getNickname(), comment});
        moment.setCommentsArray(commentList);
        int result = momentEntityMapper.modifyMoment(moment);
        if(result !=0){
            return 1;
        }
        else {
            return 0;
        }
    }

    

}

