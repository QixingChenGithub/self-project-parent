package com.qixian.business.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Author Xing
 * @Date 2021/2/5-17:07
 * @Version 1.0
 */
public class SysRolesDeptsPK implements Serializable {
    private long roleId;
    private long deptId;

    @Column(name = "role_id")
    @Id
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Column(name = "dept_id")
    @Id
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
        SysRolesDeptsPK that = (SysRolesDeptsPK) o;
        return roleId == that.roleId && deptId == that.deptId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, deptId);
    }
}
