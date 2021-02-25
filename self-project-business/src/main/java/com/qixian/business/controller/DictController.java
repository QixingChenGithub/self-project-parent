package com.qixian.business.controller;

import com.qixian.business.entity.SysDict;
import com.qixian.business.service.DictService;
import com.qixian.tool.util.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Xing
 * @Date 2021/2/7-9:42
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "dict")
@Api(tags = "字典接口")
public class DictController {

    @Resource
    private DictService dictService;

    @GetMapping("get")
    @ApiOperation("获取某个字典数据")
    public BaseResult<SysDict> get(@RequestParam(value = "dictId", required = true) long dictId) {
        log.info("调用字典查询get:{}", dictId);
        return dictService.get(dictId);
    }

    @ApiOperation("条件搜索查询字典数据")
    @PostMapping("list")
    public BaseResult<Page<SysDict>> list(@RequestBody SysDict sysDict) {
        log.info("调用字典搜索接口list:{}", sysDict);
        return dictService.list(sysDict);
    }
}
