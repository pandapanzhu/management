package com.anyang.management.platform.repository;

import com.anyang.management.platform.domain.Login;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LoginRepository extends BaseRepository<Login>{
    /**
     * 根据登录名查看是不是有这个人
     * @param loginName
     * @return
     */
    List<Login> getLoginsByLoginNameEquals(String loginName);

    Login getLoginByLoginNameEqualsAndAndPassword(String loginName,String password);

}
