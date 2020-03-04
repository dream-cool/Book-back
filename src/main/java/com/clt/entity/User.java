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
     * 备用字段1
     */
    @ApiModelProperty("备用字段1")
    private String remark1;

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

}