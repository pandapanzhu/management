package com.anyang.management.platform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录信息
 * 客人和管理员同时使用这张表进行登录操作
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login extends BaseEntity{

    private Long id;

    private String loginName;

    private String password;

    /**
     * 重置密码需他们点击链接进来，并校验重置码是否正确
     */
    private String resetString;


}
