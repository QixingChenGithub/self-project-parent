package com.qixian.business.service;

import com.qixian.business.entity.SysUser;
import com.qixian.business.repo.UserRepo;
import com.qixian.tool.entity.Errors;
import com.qixian.tool.util.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Xing
 * @Date 2021/2/2-18:29
 * @Version 1.0
 */
@Service
@Slf4j
public class UserService {

    @Resource
    private UserRepo userRepo;

    public BaseResult<SysUser> get(String userId) {
        SysUser user = userRepo.findByUserId(userId);
        Errors.NOT_FOUND_ERROR.ifNull(user, "用户不存在");
        log.info("调用完成，返回值为{}", user);
        return BaseResult.success(user);
    }

    public BaseResult<Boolean> delete(String userIds) {
        String[] userArr = userIds.split(",");
        for (String id : userArr) {
            if (6 != id.length()) {
                Errors.ILLEGAL_ERROR.illegal("用户id:" + id + "不符合字符串长度为6");
            }
        }
        List<SysUser> deleteList = userRepo.findByUserIdIn(userArr);
        userRepo.deleteInBatch(deleteList);
        return BaseResult.success(true);
    }

    public BaseResult<SysUser> add(SysUser user) {
        SysUser result = userRepo.save(user);
        return BaseResult.success("新增成功", result);
    }
}
