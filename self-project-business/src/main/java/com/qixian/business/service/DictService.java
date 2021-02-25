package com.qixian.business.service;

import com.qixian.business.entity.SysDict;
import com.qixian.business.repo.DictRepo;
import com.qixian.tool.entity.Errors;
import com.qixian.tool.util.BaseResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Xing
 * @Date 2021/2/7-9:43
 * @Version 1.0
 */
@Service
public class DictService {

    @Resource
    private DictRepo dictRepo;

    public BaseResult<SysDict> get(long dictId) {
        SysDict dict = dictRepo.findByDictId(dictId);
        Errors.NOT_FOUND_ERROR.ifNull(dict, "该字典数据不存在:" + dictId);
        return BaseResult.success(dict);
    }

    public BaseResult<Page<SysDict>> list(SysDict sysDict) {
        Page<SysDict> pages = dictRepo.findAll((Specification<SysDict>) (root, query, cb) -> null, PageRequest.of(0, 10));
        return BaseResult.success(pages);
    }
}
