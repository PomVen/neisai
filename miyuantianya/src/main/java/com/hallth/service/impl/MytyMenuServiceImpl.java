package com.hallth.service.impl;

import com.hallth.domain.MytyMenu;
import com.hallth.domain.MytyUser;
import com.hallth.mapper.MytyMenuMapper;
import com.hallth.service.MytyMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MytyMenuServiceImpl implements MytyMenuService {

    @Resource
    private MytyMenuMapper menuMapper;

    @Override
    public List<MytyMenu> getMenuListByUserRole(MytyMenu menu) {
        List<MytyMenu> list = menuMapper.getListByUserRole(menu);
        List<MytyMenu> returnList = new ArrayList<>();
        int index = menu.getMenuOrder().indexOf("1");
        for(MytyMenu item : list){
            String flag = item.getMenuOrder().substring(index,index + 1);
            if(flag.equals("1") || "0000".equals(item.getMenuOrder())){
                returnList.add(item);
            }
        }
        return returnList;
    }
}
