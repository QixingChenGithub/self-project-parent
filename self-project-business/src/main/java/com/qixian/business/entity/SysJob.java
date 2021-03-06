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
@Table(name = "sys_job", schema = "eladmin")
public class SysJob {
    private long jobId;
    private String name;
    private boolean enabled;
    private Integer jobSort;
    private String createBy;
    private String updateBy;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "job_id")
    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
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
    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "job_sort")
    public Integer getJobSort() {
        return jobSort;
    }

    public void setJobSort(Integer jobSort) {
        this.jobSort = jobSort;
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
        SysJob sysJob = (SysJob) o;
        return jobId == sysJob.jobId && enabled == sysJob.enabled && Objects.equals(name, sysJob.name) && Objects.equals(jobSort, sysJob.jobSort) && Objects.equals(createBy, sysJob.createBy) && Objects.equals(updateBy, sysJob.updateBy) && Objects.equals(createTime, sysJob.createTime) && Objects.equals(updateTime, sysJob.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, name, enabled, jobSort, createBy, updateBy, createTime, updateTime);
    }
}
