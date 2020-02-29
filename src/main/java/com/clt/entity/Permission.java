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
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;
    /**
     * 书籍信息读权限
     */
    @ApiModelProperty("书籍信息读权限")
    private Integer bookR;
    /**
     * 书籍信息写权限
     */
    @ApiModelProperty("书籍信息写权限")
    private Integer bookW;
    /**
     * 用户信息读权限
     */
    @ApiModelProperty("用户信息读权限")
    private Integer userR;
    /**
     * 用户信息写权限
     */
    @ApiModelProperty("用户信息写权限")
    private Integer userW;
    /**
     * 借阅信息读权限
     */
    @ApiModelProperty("借阅信息读权限")
    private Integer borrowingR;
    /**
     * 借阅信息写权限
     */
    @ApiModelProperty("借阅信息写权限")
    private Integer borrowingW;
    /**
     * 类别信息写权限
     */
    @ApiModelProperty("类别信息写权限")
    private Integer categoryW;
    /**
     * 统计信息读权限
     */
    @ApiModelProperty("统计信息读权限")
    private Integer statisticsR;
}