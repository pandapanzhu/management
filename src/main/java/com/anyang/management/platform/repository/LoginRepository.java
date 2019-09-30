package com.anyang.management.platform.repository;

import com.anyang.management.platform.domain.Login;

import java.util.List;

public interface LoginRepository extends BaseRepository<Login>{
    /**
     * 根据登录名查看是不是有这个人
     * @param loginName
     * @return
     */
    List<Login> getLoginsByLoginNameEquals(String loginName);

    Login getLoginByLoginNameEqualsAAndAndPassword(String loginName,String password);

}
