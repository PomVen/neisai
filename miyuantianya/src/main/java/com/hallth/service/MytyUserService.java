package com.hallth.service;

import com.hallth.domain.MytyUser;

public interface MytyUserService {
    boolean loginCheck(MytyUser user);

    MytyUser getUserInfo(MytyUser user);

    int insert(MytyUser user);

    int changePassword(MytyUser user);
}
