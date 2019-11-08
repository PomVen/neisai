package com.hallth.service.impl;

import com.hallth.domain.MytyUser;
import com.hallth.mapper.MytyUserMapper;
import com.hallth.service.MytyUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MytyUserServiceImpl implements MytyUserService {

    @Resource
    private MytyUserMapper userMapper;
    @Override
    public boolean loginCheck(MytyUser user) {
        MytyUser userCheck = userMapper.loginCheck(user);
        return userCheck == null ? false : true;
    }

    @Override
    public MytyUser getUserInfo(MytyUser user) {
        MytyUser userCheck = userMapper.getUserInfo(user);
        return userCheck;
    }

    @Override
    public int insert(MytyUser user) {
        return userMapper.insert(user);
    }

    @Override
    public int changePassword(MytyUser user) {
        return userMapper.changePassword(user);
    }
}
