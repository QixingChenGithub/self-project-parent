package com.qixian.business.service;

import com.qixian.business.config.NacosConfig;
import com.qixian.business.entity.SysDept;
import com.qixian.business.entity.SysUser;
import com.qixian.business.export.ExportExcelServiceImpl;
import com.qixian.business.repo.DeptRepo;
import com.qixian.business.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Xing
 * @Date 2021/2/7-15:00
 * @Version 1.0
 */
@Service
@Slf4j
public class ExportExcelService {

    @Resource
    private UserRepo userRepo;

    @Autowired
    private ExportExcelServiceImpl exportExcelService;

    @Resource
    private DeptRepo deptRepo;

    @Resource
    private NacosConfig nacosConfig;

    public void exportUsers(HttpServletRequest req, HttpServletResponse response, String titleName, String sheetName, String fileName) {
        List<SysUser> listUsers = userRepo.findAll();
        exportExcelService.exportExcelWithSimple(req, response, titleName, sheetName, fileName, listUsers, nacosConfig.getUserMap());
    }

    public void exportDepts(HttpServletRequest req, HttpServletResponse response, String titleName, String sheetName, String fileName) {
        List<SysDept> listDepts = deptRepo.findAll();
        exportExcelService.exportExcelWithSimple(req, response, titleName, sheetName, fileName, listDepts, nacosConfig.getDeptMap());
    }
}
