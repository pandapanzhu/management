package com.anyang.management.platform.service;

import com.alibaba.fastjson.JSONObject;
import com.anyang.management.platform.domain.Login;

public interface LoginService {
    JSONObject login(Login login);

    JSONObject logout();

}
