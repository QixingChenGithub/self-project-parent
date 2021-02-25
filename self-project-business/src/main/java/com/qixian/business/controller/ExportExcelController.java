package com.qixian.business.controller;

import com.alibaba.nacos.api.exception.NacosException;
import com.qixian.business.config.NacosConfig;
import com.qixian.business.export.ExportExcelServiceImpl;
import com.qixian.business.service.ExportExcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @Author Xing
 * @Date 2021/2/7-14:59
 * @Version 1.0
 */
@RestController
@Api(tags = "excel导出")
@RequestMapping("export")
@Slf4j
@RefreshScope
public class ExportExcelController {

    @Resource
    private ExportExcelService exportExcelService;

    @PostMapping("user")
    @ApiOperation("导出用户Excel")
    public void exportUsers(HttpServletRequest req, HttpServletResponse response, @RequestParam String titleName, @RequestParam String sheetName, @RequestParam String fileName)  {
        exportExcelService.exportUsers(req, response, titleName, sheetName, fileName);
    }

    @PostMapping("dept")
    @ApiOperation("导出部门Excel")
    public void exportDepts(HttpServletRequest req, HttpServletResponse response, @RequestParam String titleName, @RequestParam String sheetName, @RequestParam String fileName)  {
        exportExcelService.exportDepts(req, response, titleName, sheetName, fileName);
    }
}
