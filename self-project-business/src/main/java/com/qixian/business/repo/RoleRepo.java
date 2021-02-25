package com.qixian.business.repo;

import com.qixian.business.entity.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

/**
 * @Author Xing
 * @Date 2021/2/5-17:10
 * @Version 1.0
 */
public interface RoleRepo extends JpaRepository<SysRole, Long> {

    /**
    *  查询某个角色
    * @param roleId
    * @return com.qixian.business.entity.SysRole
    * @throws
    * @author Xing
    * @date 2021/11/05 17:11
    */
    SysRole findByRoleId(long roleId);

    /**
     * 条件分页查询角色
     * @param specification：查询条件
     * @param pageable: 分页参数
     * @return org.springframework.data.domain.Page<com.qixian.business.entity.SysRole>
     * @author Xing
     * @date 2021-2-8 14:37
     */
    Page<SysRole> findAll(Specification<SysRole> specification, Pageable pageable);

    /**
     * 删除角色
     * @param roleId：
     * @return void
     * @author Xing
     * @date 2021-2-8 14:38
     */
    @Modifying
    @Transactional
    void deleteByRoleId(long roleId);
}
