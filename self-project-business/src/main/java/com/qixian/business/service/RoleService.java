package com.qixian.business.service;

import com.qixian.business.entity.SysRole;
import com.qixian.business.repo.RoleRepo;
import com.qixian.tool.entity.Errors;
import com.qixian.tool.util.BaseResult;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @Author Xing
 * @Date 2021/2/5-17:14
 * @Version 1.0
 */
@Service
public class RoleService {

    @Resource
    private RoleRepo roleRepo;

    public BaseResult<SysRole> get(long roleId) {
        SysRole role = roleRepo.findByRoleId(roleId);
        Errors.NOT_FOUND_ERROR.ifNull(role);
        return BaseResult.success(role);
    }

    public BaseResult<Page<SysRole>> list(SysRole sysRole) {
        Page<SysRole> pageRoles = roleRepo.findAll(new Specification<SysRole>() {
            @Override
            public Predicate toPredicate(Root<SysRole> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        }, null);
        return BaseResult.success(pageRoles);
    }

    public BaseResult<SysRole> delete(long roleId) {
        SysRole role = roleRepo.findByRoleId(roleId);
        Errors.NOT_FOUND_ERROR.ifNull(role, "角色id:" + roleId + "不存在,删除失败");
        roleRepo.deleteByRoleId(roleId);
        return BaseResult.success("删除成功", role);
    }
}
