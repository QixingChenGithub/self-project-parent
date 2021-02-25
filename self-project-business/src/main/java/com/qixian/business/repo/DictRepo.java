package com.qixian.business.repo;

import com.qixian.business.entity.SysDict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Xing
 * @Date 2021/2/7-9:43
 * @Version 1.0
 */
public interface DictRepo extends JpaRepository<SysDict, Long> {
    SysDict findByDictId(long dictId);

    Page<SysDict> findAll(Specification specification, Pageable pageable);
}
