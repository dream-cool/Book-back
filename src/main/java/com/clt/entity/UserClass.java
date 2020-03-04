package com.clt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Class)实体类
 *
 * @author makejava
 * @since 2020-03-04 15:13:30
 */
@Getter
@Setter
@ToString
@ApiModel("班级实体")
public class UserClass implements Serializable {
    private static final long serialVersionUID = 693364963917158866L;

    /**
     * 班级id
     */
    @ApiModelProperty("")
    private String classId;

    /**
     * 年级编号
     */
    @ApiModelProperty("")
    private String grade;

    /**
     * 院系编号
     */
    @ApiModelProperty("")
    private String depart;

    /**
     * 专业编号
     */
    @ApiModelProperty("")
    private String major;

    /**
     * 班级编号
     */
    @ApiModelProperty("班级编号")
    private String number;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private String createTime;


    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private String updateTime;


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