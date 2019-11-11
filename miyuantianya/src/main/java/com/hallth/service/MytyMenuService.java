package com.hallth.service;

import com.hallth.domain.MytyMenu;
import com.hallth.domain.MytyUser;

import java.util.List;

public interface MytyMenuService {
    List<MytyMenu> getMenuListByUserRole(MytyUser user);
}
