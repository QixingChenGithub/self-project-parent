package com.qixian.business.controller;

import com.qixian.business.config.ValidationGroup;
import com.qixian.business.entity.SysUser;
import com.qixian.business.service.UserService;
import com.qixian.tool.util.BaseResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

/**
 * @Author Xing
 * @Date 2021/2/2-18:28
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
@Slf4j
@Validated
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("get")
    public BaseResult<SysUser> get(@RequestParam(value = "userId", required = true) @Length(min = 6, max = 6) @NotBlank() String userId) {
        log.info("调用get方法,参数为{}", userId);
        return userService.get(userId);
    }

    @GetMapping("list")
    public BaseResult<Page<SysUser>> list(@RequestBody SysUser user) {
        return null;
    }

    @GetMapping("delete")
    public BaseResult<Boolean> delete(@RequestParam(value = "userIds", required = true) @NotBlank String userIds) {
        log.info("调用delete方法,参数为{}", userIds);
        return userService.delete(userIds);
    }

    @PostMapping("add")
    @ApiOperation("新增用户")
    public BaseResult<SysUser> add(@Validated({ValidationGroup.UserAddGroup.class}) @RequestBody SysUser user) {
        log.info("调用add方法,参数为:{}", user);
        return userService.add(user);
    }
}
