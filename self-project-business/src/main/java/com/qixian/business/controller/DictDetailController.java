package com.qixian.business.controller;

import com.qixian.business.entity.SysDictDetail;
import com.qixian.business.service.DictDetailService;
import com.qixian.tool.util.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Xing
 * @Date 2021/2/7-11:21
 * @Version 1.0
 */
@RestController
@Api(tags = "字典详细数据接口")
@Slf4j
@RequestMapping("dictDetail")
public class DictDetailController {

    @Resource
    private DictDetailService dictDetailService;

    @ApiOperation("字典详情查询")
    @GetMapping("get")
    public BaseResult<List<SysDictDetail>> get(@RequestParam(value = "dictId", required = true) long dictId) {
        log.info("调用字典详细get接口:{}", dictId);
        return dictDetailService.get(dictId);
    }

}
