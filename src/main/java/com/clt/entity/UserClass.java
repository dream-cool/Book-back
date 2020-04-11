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
    private String gradeNo;

    /**
     * 院系编号
     */
    @ApiModelProperty("")
    private String departNo;

    /**
     * 专业编号
     */
    @ApiModelProperty("")
    private String majorNo;

    /**
     * 班级编号
     */
    @ApiModelProperty("班级编号")
    private String classNumberNo;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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