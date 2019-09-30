package com.anyang.management.platform.controller;

import com.alibaba.fastjson.JSONObject;
import com.anyang.management.platform.domain.Login;
import com.anyang.management.platform.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录业务
 */
@RestController("login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("login")
    public JSONObject loginSys(Login login){

        return loginService.login(login);
    }

    @RequestMapping("logout")
    public String logout(){
        //应该根据传过来的ID，然后消除他的登录信息
        return loginService.logout().toJSONString();
    }

    /**
     * 注册操作
     * @return
     */
    @PostMapping("registry")
    public JSONObject registry(){
        return null;
    }
}
