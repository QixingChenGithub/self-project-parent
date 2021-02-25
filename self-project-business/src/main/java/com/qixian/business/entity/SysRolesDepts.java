package com.qixian.business.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author Xing
 * @Date 2021/2/5-17:07
 * @Version 1.0
 */
@Entity
@Table(name = "sys_roles_depts", schema = "eladmin", catalog = "")
@IdClass(SysRolesDeptsPK.class)
public class SysRolesDepts {
    private Long id;
    private long roleId;
    private long deptId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "role_id")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "dept_id")
    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRolesDepts that = (SysRolesDepts) o;
        return roleId == that.roleId && deptId == that.deptId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, deptId);
    }
}
