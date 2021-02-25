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
@Table(name = "sys_quartz_job", schema = "eladmin")
public class SysQuartzJob {
    private long jobId;
    private String beanName;
    private String cronExpression;
    private Boolean isPause;
    private String jobName;
    private String methodName;
    private String params;
    private String description;
    private String personInCharge;
    private String email;
    private String subTask;
    private Boolean pauseAfterFailure;
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
    @Column(name = "bean_name")
    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Basic
    @Column(name = "cron_expression")
    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @Basic
    @Column(name = "is_pause")
    public Boolean getPause() {
        return isPause;
    }

    public void setPause(Boolean pause) {
        isPause = pause;
    }

    @Basic
    @Column(name = "job_name")
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Basic
    @Column(name = "method_name")
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Basic
    @Column(name = "params")
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
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
    @Column(name = "person_in_charge")
    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "sub_task")
    public String getSubTask() {
        return subTask;
    }

    public void setSubTask(String subTask) {
        this.subTask = subTask;
    }

    @Basic
    @Column(name = "pause_after_failure")
    public Boolean getPauseAfterFailure() {
        return pauseAfterFailure;
    }

    public void setPauseAfterFailure(Boolean pauseAfterFailure) {
        this.pauseAfterFailure = pauseAfterFailure;
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
        SysQuartzJob that = (SysQuartzJob) o;
        return jobId == that.jobId && Objects.equals(beanName, that.beanName) && Objects.equals(cronExpression, that.cronExpression) && Objects.equals(isPause, that.isPause) && Objects.equals(jobName, that.jobName) && Objects.equals(methodName, that.methodName) && Objects.equals(params, that.params) && Objects.equals(description, that.description) && Objects.equals(personInCharge, that.personInCharge) && Objects.equals(email, that.email) && Objects.equals(subTask, that.subTask) && Objects.equals(pauseAfterFailure, that.pauseAfterFailure) && Objects.equals(createBy, that.createBy) && Objects.equals(updateBy, that.updateBy) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, beanName, cronExpression, isPause, jobName, methodName, params, description, personInCharge, email, subTask, pauseAfterFailure, createBy, updateBy, createTime, updateTime);
    }
}
