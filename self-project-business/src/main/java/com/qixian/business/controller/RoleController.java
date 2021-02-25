package com.qixian.business.controller;

import com.qixian.business.entity.SysRole;
import com.qixian.business.service.RoleService;
import com.qixian.tool.util.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Xing
 * @Date 2021/2/5-17:12
 * @Version 1.0
 */
@RestController
@RequestMapping("role")
@Api(tags = "角色接口")
public class RoleController {

    @Resource
    private RoleService roleService;

    @GetMapping("get")
    @ApiOperation("获取某个角色")
    public BaseResult<SysRole> get(@RequestParam(value = "roleId", required = true) long roleId) {
        return roleService.get(roleId);
    }

    @PostMapping("list")
    @ApiOperation("搜索查询角色列表")
    public BaseResult<Page<SysRole>> list(@RequestBody SysRole sysRole) {
        return roleService.list(sysRole);
    }

    @GetMapping("delete")
    @ApiOperation("删除某个角色")
    public BaseResult<SysRole> delete(@RequestParam(value = "roleId", required = true) long roleId) {
        return roleService.delete(roleId);
    }
}
