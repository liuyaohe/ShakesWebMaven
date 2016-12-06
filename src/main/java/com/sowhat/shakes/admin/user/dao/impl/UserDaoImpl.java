package com.sowhat.shakes.admin.user.dao.impl;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sowhat.shakes.admin.user.dao.UserDao;
import com.sowhat.shakes.admin.user.mapper.UserMapper;
import com.sowhat.shakes.base.mode.UserInfo;

/**
 * Created by liu on 2016/8/7.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private Log log = LogFactory.getLog(UserDaoImpl.class);
    @Autowired
    private UserMapper userMapper;

    public List<UserInfo> getUserList(UserInfo userInfo) {
        log.info("====进入获取用户列表方法==");
        List<UserInfo> users = userMapper.find(userInfo);

        log.info("====进入获取用户列表方法=="+users);
        return users;
    }

    public UserInfo getUser(String seq) {
        return userMapper.findBySeq(seq);
    }
    
    @Override
    public UserInfo getUserByUserId(String userId) {
    	return userMapper.findByUserId(userId);
    }

    public void saveUserInfo(UserInfo userInfo) {
        userMapper.insertUser(userInfo);
    }

    public void updateUserInfo(UserInfo userInfo) {
        userMapper.updateUser(userInfo);
    }
}
