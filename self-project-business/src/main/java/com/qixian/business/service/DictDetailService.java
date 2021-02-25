package com.qixian.business.service;

import com.qixian.business.entity.SysDictDetail;
import com.qixian.business.repo.DictDetailRepo;
import com.qixian.tool.entity.Errors;
import com.qixian.tool.util.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Xing
 * @Date 2021/2/7-11:22
 * @Version 1.0
 */
@Service
@Slf4j
public class DictDetailService {

    @Resource
    private DictDetailRepo dictDetailRepo;

    public BaseResult<List<SysDictDetail>> get(long dictId) {
        List<SysDictDetail> details = dictDetailRepo.findByDictId(dictId);
        Errors.NOT_FOUND_ERROR.ifNull(details, "查询的字典详情不存在:{}" + dictId);
        log.info("调用完成,返回值为:{}", details);
        return BaseResult.success(details);
    }
}
