package com.anyang.management.platform.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.anyang.management.platform.domain.Login;
import com.anyang.management.platform.repository.CustomerRespostory;
import com.anyang.management.platform.repository.LoginRepository;
import com.anyang.management.platform.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginRepository loginRepository;

    @Resource
    private CustomerRespostory customerRespostory;

    @Override
    public JSONObject login(Login login) {
        JSONObject jsonObject =new JSONObject();
        List<Login> loginNameList = loginRepository.getLoginsByLoginNameEquals(login.getLoginName());
       if(CollectionUtils.isEmpty(loginNameList)){ //证明没找到对应的登录名
           jsonObject.put("msg","登录名不正确");
           return jsonObject;
       }
        Login login1 = loginRepository.getLoginByLoginNameEqualsAAndAndPassword(login.getLoginName(),login.getPassword());
       if(!ObjectUtils.isEmpty(login1)){ //不为空，证明登录成功
           jsonObject.put("msg","success");
           return jsonObject;
       }

        return null;
    }

    @Override
    public JSONObject logout() {
        return null;
    }
}
