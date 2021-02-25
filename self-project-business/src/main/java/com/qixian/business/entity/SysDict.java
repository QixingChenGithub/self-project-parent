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
@Table(name = "sys_dict", schema = "eladmin")
public class SysDict {
    private long dictId;
    private String name;
    private String description;
    private String createBy;
    private String updateBy;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "dict_id")
    public long getDictId() {
        return dictId;
    }

    public void setDictId(long dictId) {
        this.dictId = dictId;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysDict sysDict = (SysDict) o;
        return dictId == sysDict.dictId && Objects.equals(name, sysDict.name) && Objects.equals(description, sysDict.description) && Objects.equals(createBy, sysDict.createBy) && Objects.equals(updateBy, sysDict.updateBy) && Objects.equals(createTime, sysDict.createTime) && Objects.equals(updateTime, sysDict.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dictId, name, description, createBy, updateBy, createTime, updateTime);
    }
}
