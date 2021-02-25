package com.qixian.business.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author Xing
 * @Date 2021/2/5-17:07
 * @Version 1.0
 */
@Entity
@Table(name = "sys_users_jobs", schema = "eladmin", catalog = "")
@IdClass(SysUsersJobsPK.class)
public class SysUsersJobs {
    private Long id;
    private long userId;
    private long jobId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "job_id")
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
        SysUsersJobs that = (SysUsersJobs) o;
        return userId == that.userId && jobId == that.jobId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, jobId);
    }
}
