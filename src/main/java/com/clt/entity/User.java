package com.clt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:05:15
 */
@ApiModel("用户实体类")
public class User implements Serializable {
    private static final long serialVersionUID = -99310267942812814L;
    /**
    * 用户ID
    */
    @ApiModelProperty("用户ID")
    private String userId;
    /**
    * 用户姓名
    */
    @ApiModelProperty("用户姓名")
    private String userName;
    /**
    * 用户密码
    */
    @ApiModelProperty("用户密码")
    private String password;
    /**
    * 用户性别
    */
    @ApiModelProperty("用户性别")
    private String sex;
    /**
    * 身份证号码
    */
    @ApiModelProperty("身份证号码")
    private String idcard;
    /**
    * 电话
    */
    @ApiModelProperty("电话")
    private String tel;
    /**
    * 邮箱
    */
    @ApiModelProperty("邮箱")
    private String email;
    /**
    * 信用分
    */
    @ApiModelProperty("信用分")
    private Integer credit;
    /**
    * 用户状态
    */
    @ApiModelProperty("用户状态")
    private String status;
    /**
    * 角色
    */
    @ApiModelProperty("角色")
    private String role;
    /**
    * 注册时间
    */
    @ApiModelProperty("注册时间")
    private Date registerTime;
    /**
    * 最后登录时间
    */
    @ApiModelProperty("最后登录时间")
    private Date lastLoginTime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

}