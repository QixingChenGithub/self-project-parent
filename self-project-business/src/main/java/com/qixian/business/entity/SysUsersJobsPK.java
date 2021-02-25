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
public class SysUsersJobsPK implements Serializable {
    private long userId;
    private long jobId;

    @Column(name = "user_id")
    @Id
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "job_id")
    @Id
    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUsersJobsPK that = (SysUsersJobsPK) o;
        return userId == that.userId && jobId == that.jobId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, jobId);
    }
}
