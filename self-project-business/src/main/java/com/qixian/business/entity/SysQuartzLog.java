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
@Table(name = "sys_quartz_log", schema = "eladmin")
public class SysQuartzLog {
    private long logId;
    private String beanName;
    private Timestamp createTime;
    private String cronExpression;
    private String exceptionDetail;
    private Boolean isSuccess;
    private String jobName;
    private String methodName;
    private String params;
    private Long time;

    @Id
    @Column(name = "log_id")
    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
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
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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
    @Column(name = "exception_detail")
    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }

    @Basic
    @Column(name = "is_success")
    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
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
    @Column(name = "time")
    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysQuartzLog that = (SysQuartzLog) o;
        return logId == that.logId && Objects.equals(beanName, that.beanName) && Objects.equals(createTime, that.createTime) && Objects.equals(cronExpression, that.cronExpression) && Objects.equals(exceptionDetail, that.exceptionDetail) && Objects.equals(isSuccess, that.isSuccess) && Objects.equals(jobName, that.jobName) && Objects.equals(methodName, that.methodName) && Objects.equals(params, that.params) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, beanName, createTime, cronExpression, exceptionDetail, isSuccess, jobName, methodName, params, time);
    }
}
