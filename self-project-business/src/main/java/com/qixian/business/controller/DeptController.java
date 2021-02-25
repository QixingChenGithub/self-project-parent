package com.qixian.business.controller;

import com.qixian.business.entity.SysDept;
import com.qixian.business.entity.dto.DeptDto;
import com.qixian.business.service.DeptService;
import com.qixian.tool.util.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author Xing
 * @Date 2021/2/7-10:26
 * @Version 1.0
 */
@RestController
@RequestMapping("dept")
@Slf4j
@Api(tags = "部门接口")
public class DeptController {

    @Resource
    private DeptService deptService;

    @GetMapping("get")
    @ApiOperation("根据部门id获取某个部门")
    public BaseResult<SysDept> get(@RequestParam(value = "deptId", required = true) long deptId) {
        log.info("调用部门get方法:{}", deptId);
        return deptService.get(deptId);
    }

    @PostMapping("list")
    @ApiOperation("根据部门id获取某个部门")
    public BaseResult<Page<SysDept>> list(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestBody @NotNull DeptDto deptDto) {
        log.info("调用部门list方法:{},{},{}", page, size, deptDto);
        return deptService.list(deptDto);
    }

}
