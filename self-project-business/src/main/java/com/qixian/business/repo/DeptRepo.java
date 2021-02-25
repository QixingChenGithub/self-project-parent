package com.qixian.business.repo;


import com.qixian.business.entity.SysDept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author Xing
 * @Date 2021/2/7-10:27
 * @Version 1.0
 */
public interface DeptRepo extends JpaRepository<SysDept, Long>, JpaSpecificationExecutor<SysDept> {
    SysDept findByDeptId(long deptId);
}
