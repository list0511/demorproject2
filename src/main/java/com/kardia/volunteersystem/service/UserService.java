package com.kardia.volunteersystem.service;

import com.kardia.volunteersystem.dao.entity.UserEntity;
import com.kardia.volunteersystem.dao.mapper.UserEntityMapper;
import com.kardia.volunteersystem.utils.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class UserService {
    private final UserEntityMapper userEntityMapper;

    public UserService(UserEntityMapper userEntityMapper) {
        this.userEntityMapper = userEntityMapper;
    }

    /**
     * 查询项目列表
     */
    public List<UserEntity> queryUserList(UserEntity userEntity)
    {
        List<UserEntity> result = userEntityMapper.queryUserList(userEntity);
        System.out.println("列表"+result);
        return result;
    }

    public List<UserEntity> searchUserById(UserEntity userEntity)
    {
        List<UserEntity> result;
        result=userEntityMapper.selectUserById(userEntity);
        System.out.println("ById:"+result);
        return result;
    }

    /**
     * 修改项目信息
     */
    public UserEntity ModifyMsg(UserEntity userEntity)
    {
        List<UserEntity> userEntities=userEntityMapper.selectUserById(userEntity);

        try{
            int modifyResult = userEntityMapper.modifyUser(userEntity);
            return userEntities.get(0);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        userEntities.get(0).setDescription("fail");

        return userEntities.get(0);
    }

    /**
     * 删除项目
     */
    public int deleteUser(UserEntity userEntity)
    {
        int deleteResult = userEntityMapper.deleteUser(userEntity);
        return deleteResult;
    }

    /**
     * 新增项目
     */
    public UserEntity NewTheUser(UserEntity userEntity)
    {
        userEntity.setId(UUIDUtil.getOneUUID());

        userEntityMapper.insertUser(userEntity);

        return userEntity;
    }

    public UserEntity IfHasTheUser(UserEntity userEntity)
    {

        List<UserEntity> userEntities= userEntityMapper.selectUserByAccount(userEntity);
        if(userEntities.isEmpty()){
            UserEntity userEntity1 = new UserEntity();
            userEntity1.setId("-1");
            return userEntity1;
        }
        return userEntities.get(0);
    }
    public UserEntity IfPwdCorrect(UserEntity userEntity1,String Pwd)
    {

        if(userEntity1.getPassword().equals(Pwd)){
            return userEntity1;
        }
        UserEntity userEntity2 = new UserEntity();
        userEntity2.setId("-1");
        return userEntity2;

    }

    public List<UserEntity> getAllC()
    {
        List<UserEntity> allChild = userEntityMapper.getallChild();
        return allChild;
    }

    public List<UserEntity> getMyC(UserEntity userEntity)
    {
        List<UserEntity> myChild = userEntityMapper.getmyChild(userEntity);
        return myChild;
    }

    public UserEntity getTheC(UserEntity userEntity)
    {
        UserEntity theChild = userEntityMapper.gettheChild(userEntity);
        return  theChild;
    }

    public List<UserEntity> GetAllFriend(UserEntity userEntity){
        String[] friend=userEntity.getBindArray();
        List<UserEntity> friendlist = new ArrayList<>();

        for(int i=0;i<friend.length;i++){
            UserEntity user=new UserEntity();
            user.setId(friend[i]);
            user=userEntityMapper.selectUserById(user).get(0);
            System.out.println(user.toString());
            if (user != null) {
                friendlist.add(user);
            }
        }
        return friendlist;
    }

}
