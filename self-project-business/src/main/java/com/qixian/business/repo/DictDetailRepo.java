package com.qixian.business.repo;

import com.qixian.business.entity.SysDictDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author Xing
 * @Date 2021/2/7-11:22
 * @Version 1.0
 */
public interface DictDetailRepo extends JpaRepository<SysDictDetail, Long> {
    List<SysDictDetail> findByDictId(long dictDetailId);
}
