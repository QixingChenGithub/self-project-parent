package com.qixian.business.entity;

import com.qixian.business.config.ValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author Xing
 * @Date 2021/2/5-17:03
 * @Version 1.0
 */
@Entity
@Table(name = "sys_user", schema = "eladmin")
public class SysUser implements Serializable {
    @NotNull(groups = {ValidationGroup.UserAddGroup.class, ValidationGroup.UserUpdateGroup.class})
    private Long userId;
    @NotNull(groups = {ValidationGroup.UserAddGroup.class})
    private Long deptId;
    @NotBlank(groups = {ValidationGroup.UserAddGroup.class})
    private String username;
    private String nickName;
    @NotBlank(groups = {ValidationGroup.UserAddGroup.class})
    private String gender;
    @NotBlank(groups = {ValidationGroup.UserAddGroup.class})
    private String phone;
    private String email;
    private String avatarName;
    private String avatarPath;
    private String password;
    private Boolean isAdmin;
    private Long enabled;
    private String createBy;
    private String updateBy;
    private Timestamp pwdResetTime;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "dept_id")
    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "avatar_name")
    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

    @Basic
    @Column(name = "avatar_path")
    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "is_admin")
    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Basic
    @Column(name = "enabled")
    public Long getEnabled() {
        return enabled;
    }

    public void setEnabled(Long enabled) {
        this.enabled = enabled;
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
    @Column(name = "pwd_reset_time")
    public Timestamp getPwdResetTime() {
        return pwdResetTime;
    }

    public void setPwdResetTime(Timestamp pwdResetTime) {
        this.pwdResetTime = pwdResetTime;
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
        SysUser sysUser = (SysUser) o;
        return userId == sysUser.userId && Objects.equals(deptId, sysUser.deptId) && Objects.equals(username, sysUser.username) && Objects.equals(nickName, sysUser.nickName) && Objects.equals(gender, sysUser.gender) && Objects.equals(phone, sysUser.phone) && Objects.equals(email, sysUser.email) && Objects.equals(avatarName, sysUser.avatarName) && Objects.equals(avatarPath, sysUser.avatarPath) && Objects.equals(password, sysUser.password) && Objects.equals(isAdmin, sysUser.isAdmin) && Objects.equals(enabled, sysUser.enabled) && Objects.equals(createBy, sysUser.createBy) && Objects.equals(updateBy, sysUser.updateBy) && Objects.equals(pwdResetTime, sysUser.pwdResetTime) && Objects.equals(createTime, sysUser.createTime) && Objects.equals(updateTime, sysUser.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, deptId, username, nickName, gender, phone, email, avatarName, avatarPath, password, isAdmin, enabled, createBy, updateBy, pwdResetTime, createTime, updateTime);
    }
}
