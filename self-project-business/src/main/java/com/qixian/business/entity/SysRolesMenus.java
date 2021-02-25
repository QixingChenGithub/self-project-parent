package com.qixian.business.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author Xing
 * @Date 2021/2/5-17:07
 * @Version 1.0
 */
@Entity
@Table(name = "sys_roles_menus", schema = "eladmin", catalog = "")
@IdClass(SysRolesMenusPK.class)
public class SysRolesMenus {
    private Long id;
    private long menuId;
    private long roleId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "menu_id")
    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    @Id
    @Column(name = "role_id")
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
        SysRolesMenus that = (SysRolesMenus) o;
        return menuId == that.menuId && roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, roleId);
    }
}
