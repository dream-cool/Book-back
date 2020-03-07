package com.clt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Permission)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:04:55
 */
@Getter
@Setter
@ToString
@ApiModel("权限实体类")
public class Permission implements Serializable {
    private static final long serialVersionUID = -67106146224368569L;



    public Permission() {
        this.bookR = false;
        this.bookW = false;
        this.userR = false;
        this.userW = false;
        this.borrowingR = false;
        this.borrowingW = false;
        this.categoryW = false;
        this.statisticsR = false;
        this.privilege = false;
        this.admin = false;
    }

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;
    /**
     * 书籍信息读权限
     */
    @ApiModelProperty("书籍信息读权限")
    private Boolean bookR;
    /**
     * 书籍信息写权限
     */
    @ApiModelProperty("书籍信息写权限")
    private Boolean bookW;
    /**
     * 用户信息读权限
     */
    @ApiModelProperty("用户信息读权限")
    private Boolean userR;
    /**
     * 用户信息写权限
     */
    @ApiModelProperty("用户信息写权限")
    private Boolean userW;
    /**
     * 借阅信息读权限
     */
    @ApiModelProperty("借阅信息读权限")
    private Boolean borrowingR;
    /**
     * 借阅信息写权限
     */
    @ApiModelProperty("借阅信息写权限")
    private Boolean borrowingW;
    /**
     * 类别信息写权限
     */
    @ApiModelProperty("类别信息写权限")
    private Boolean categoryW;
    /**
     * 统计信息读权限
     */
    @ApiModelProperty("统计信息读权限")
    private Boolean statisticsR;

    /**
     * 后台管理权限
     */
    @ApiModelProperty("后台管理权限")
    private Boolean admin;

    /**
     * 权限管理权限
     */
    @ApiModelProperty("权限管理权限")
    private Boolean privilege;

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
     * 备用字段3
     */
    @ApiModelProperty("备用字段3")
    private String remark3;
}