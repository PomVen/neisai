package com.hallth.service.impl;

import com.hallth.domain.MytyMenu;
import com.hallth.domain.MytyUser;
import com.hallth.mapper.MytyMenuMapper;
import com.hallth.service.MytyMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MytyMenuServiceImpl implements MytyMenuService {

    @Resource
    private MytyMenuMapper menuMapper;

    @Override
    public List<MytyMenu> getMenuListByUserRole(MytyUser user) {
        List<MytyMenu> list = menuMapper.getListByUserRole(user);
        return list;
    }
}
