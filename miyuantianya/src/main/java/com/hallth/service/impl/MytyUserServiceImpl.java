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
}
