package com.qixian.business.repo;

import com.qixian.business.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author Xing
 * @Date 2021/2/2-18:29
 * @Version 1.0
 */
public interface UserRepo extends JpaRepository<SysUser, Long> {

    SysUser findByUserId(String userId);

    List<SysUser> findByUserIdIn(String[] userArr);
}
