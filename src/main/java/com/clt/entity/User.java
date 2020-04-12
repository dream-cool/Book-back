package com.clt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:05:15
 */
@Getter
@Setter
@ToString
@ApiModel("用户实体类")
public class User implements Serializable {
    private static final long serialVersionUID = -99310267942812814L;
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;

    /**
     * 用户编号
     */
    @ApiModelProperty("用户编号")
    private String stuNo;
    /**
     * 用户姓名
     */
    @ApiModelProperty("用户姓名")
    private String userName;
    /**
     * 班级id
     */
    @ApiModelProperty("班级id")
    private String classId;
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
     * 地址
     */
    @ApiModelProperty("地址")
    private String address;

    /**
     * 信用分
     */
    @ApiModelProperty("信用分")
    private Integer credit;

    /**
     * 几星信用
     */
    @ApiModelProperty("几星信用")
    private  Integer creditStars;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registerTime;
    /**
     * 最后登录时间
     */
    @ApiModelProperty("最后登录时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    private Date createTime;


    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("修改时间")
    private Date updateTime;


    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 备用字段2
     */
    @ApiModelProperty("备用字段2")
    private String remark2;

    /**
     * 备用字段1
     */
    @ApiModelProperty("备用字段3")
    private String remark3;
    /**
     * 权限记录
     */
    @ApiModelProperty("权限记录")
    private Permission permission;

    public void increaseCredit(int score){
        this.credit += score;
    }

    public void decreaseCredit(int score){
        this.credit -=score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (stuNo != null ? !stuNo.equals(user.stuNo) : user.stuNo != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (classId != null ? !classId.equals(user.classId) : user.classId != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (idcard != null ? !idcard.equals(user.idcard) : user.idcard != null) return false;
        if (tel != null ? !tel.equals(user.tel) : user.tel != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (credit != null ? !credit.equals(user.credit) : user.credit != null) return false;
        if (creditStars != null ? !creditStars.equals(user.creditStars) : user.creditStars != null) return false;
        if (status != null ? !status.equals(user.status) : user.status != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (registerTime != null ? !registerTime.equals(user.registerTime) : user.registerTime != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(user.lastLoginTime) : user.lastLoginTime != null)
            return false;
        if (createTime != null ? !createTime.equals(user.createTime) : user.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(user.updateTime) : user.updateTime != null) return false;
        if (avatar != null ? !avatar.equals(user.avatar) : user.avatar != null) return false;
        if (remark2 != null ? !remark2.equals(user.remark2) : user.remark2 != null) return false;
        if (remark3 != null ? !remark3.equals(user.remark3) : user.remark3 != null) return false;
        return permission != null ? permission.equals(user.permission) : user.permission == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (stuNo != null ? stuNo.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (classId != null ? classId.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (idcard != null ? idcard.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (credit != null ? credit.hashCode() : 0);
        result = 31 * result + (creditStars != null ? creditStars.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (remark2 != null ? remark2.hashCode() : 0);
        result = 31 * result + (remark3 != null ? remark3.hashCode() : 0);
        result = 31 * result + (permission != null ? permission.hashCode() : 0);
        return result;
    }
}