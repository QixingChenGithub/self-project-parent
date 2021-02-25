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
public class SysRolesMenusPK implements Serializable {
    private long menuId;
    private long roleId;

    @Column(name = "menu_id")
    @Id
    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    @Column(name = "role_id")
    @Id
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRolesMenusPK that = (SysRolesMenusPK) o;
        return menuId == that.menuId && roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, roleId);
    }
}
