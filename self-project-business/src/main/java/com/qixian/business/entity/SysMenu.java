package com.qixian.business.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author Xing
 * @Date 2021/2/5-17:07
 * @Version 1.0
 */
@Entity
@Table(name = "sys_menu", schema = "eladmin")
public class SysMenu {
    private long menuId;
    private Long pid;
    private Integer subCount;
    private Integer type;
    private String title;
    private String name;
    private String component;
    private Integer menuSort;
    private String icon;
    private String path;
    private Boolean iFrame;
    private Boolean cache;
    private Boolean hidden;
    private String permission;
    private String createBy;
    private String updateBy;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "menu_id")
    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "pid")
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "sub_count")
    public Integer getSubCount() {
        return subCount;
    }

    public void setSubCount(Integer subCount) {
        this.subCount = subCount;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "component")
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @Basic
    @Column(name = "menu_sort")
    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "i_frame")
    public Boolean getiFrame() {
        return iFrame;
    }

    public void setiFrame(Boolean iFrame) {
        this.iFrame = iFrame;
    }

    @Basic
    @Column(name = "cache")
    public Boolean getCache() {
        return cache;
    }

    public void setCache(Boolean cache) {
        this.cache = cache;
    }

    @Basic
    @Column(name = "hidden")
    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    @Basic
    @Column(name = "permission")
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Basic
    @Column(name = "create_by")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysMenu sysMenu = (SysMenu) o;
        return menuId == sysMenu.menuId && Objects.equals(pid, sysMenu.pid) && Objects.equals(subCount, sysMenu.subCount) && Objects.equals(type, sysMenu.type) && Objects.equals(title, sysMenu.title) && Objects.equals(name, sysMenu.name) && Objects.equals(component, sysMenu.component) && Objects.equals(menuSort, sysMenu.menuSort) && Objects.equals(icon, sysMenu.icon) && Objects.equals(path, sysMenu.path) && Objects.equals(iFrame, sysMenu.iFrame) && Objects.equals(cache, sysMenu.cache) && Objects.equals(hidden, sysMenu.hidden) && Objects.equals(permission, sysMenu.permission) && Objects.equals(createBy, sysMenu.createBy) && Objects.equals(updateBy, sysMenu.updateBy) && Objects.equals(createTime, sysMenu.createTime) && Objects.equals(updateTime, sysMenu.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, pid, subCount, type, title, name, component, menuSort, icon, path, iFrame, cache, hidden, permission, createBy, updateBy, createTime, updateTime);
    }
}
