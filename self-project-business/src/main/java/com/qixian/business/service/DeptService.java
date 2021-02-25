package com.qixian.business.service;

import com.github.wenhao.jpa.Specifications;
import com.qixian.business.entity.SysDept;
import com.qixian.business.entity.dto.DeptDto;
import com.qixian.business.repo.DeptRepo;
import com.qixian.tool.entity.Errors;
import com.qixian.tool.util.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @Author Xing
 * @Date 2021/2/7-10:26
 * @Version 1.0
 */
@Service
@Slf4j
public class DeptService {

    @Resource
    private DeptRepo deptRepo;

    public BaseResult<SysDept> get(long deptId) {
        SysDept dept = deptRepo.findByDeptId(deptId);
        Errors.NOT_FOUND_ERROR.ifNull(dept, "该" + deptId + "id的部门不存在");
        log.info("调用完成result:{}", dept);
        return BaseResult.success(dept);
    }

    public BaseResult<Page<SysDept>> list(DeptDto deptDto) {
        Specification<SysDept> spec = Specifications.<SysDept>and()
                .between(Objects.nonNull(deptDto.getStartTime()) && Objects.nonNull(deptDto.getEndTime()), "createTime", deptDto.getStartTime(), deptDto.getEndTime())
                .like(StringUtils.isNotBlank(deptDto.getDeptName()), "name", "%" + deptDto.getDeptName() + "%")
                .eq(Objects.nonNull(deptDto.getEnabled()), "enabled", deptDto.getEnabled())
                .build();
        Page<SysDept> pageDepts = deptRepo.findAll(spec, PageRequest.of(0, 10));
        return BaseResult.success(pageDepts);
    }
}
