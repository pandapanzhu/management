package com.anyang.management.platform.controller;

import com.anyang.management.platform.domain.Login;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录业务
 */
@RestController("login")
public class LoginController {

    @PostMapping("login")
    public Login loginSys(Login login){



        return login;
    }

    @RequestMapping("logout")
    public String logout(){
        return null;
    }
}
