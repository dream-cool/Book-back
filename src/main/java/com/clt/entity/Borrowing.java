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
 * (Borrowing)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:03:35
 */
@Getter
@Setter
@ToString
@ApiModel("借阅信息实体")
public class Borrowing implements Serializable {
    private static final long serialVersionUID = -84104176779408312L;
    /**
     * 借阅id
     */
    @ApiModelProperty("借阅id")
    private String borrowingId;
    /**
     * 书籍id
     */
    @ApiModelProperty("书籍id")
    private String bookId;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;
    /**
     * 书籍名称
     */
    @ApiModelProperty("书籍名称")
    private String bookName;

    /**
     * 书籍图片
     */
    @ApiModelProperty("书籍图片")
    private String bookImg;
    /**
     * 用户姓名
     */
    @ApiModelProperty("用户姓名")
    private String userName;

    /**
     * 用户实体
     */
    @ApiModelProperty("用户实体")
    private User user;

    /**
     * 借阅时长
     */
    @ApiModelProperty("借阅时长")
    private Integer duration;

    /**
     * 申请时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("申请时间")
    private Date applicationTime;

    /**
     * 取消时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("取消时间")
    private Date cancelTime;

    /**
     * 处理时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("处理时间")
    private Date handleTime;

    /**
     * 借阅时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("借阅时间")
    private Date borrowingTime;
    /**
     * 归还时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("归还时间")
    private Date returnTime;
    /**
     * 状态  申请、驳回、已借、逾期、归还
     */
    @ApiModelProperty("状态")
    private String borrowingStatus;

    /**
     * 借阅操作人
     */
    @ApiModelProperty("操作人")
    private String borrowingOperator;


    /**
     * 归还操作人
     */
    @ApiModelProperty("归还操作人")
    private String returnOperator;


    /**
     * 逾期天数
     */
    @ApiModelProperty("逾期天数")
    private Integer overdueDays;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String note;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updateTime;


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