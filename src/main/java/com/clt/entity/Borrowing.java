package com.clt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (Borrowing)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:03:35
 */
@Getter
@Setter
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
    * 用户姓名
    */
    @ApiModelProperty("用户姓名")
    private String userName;
    /**
    * 申请时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @ApiModelProperty("申请时间")
    private Date applicationTime;
    /**
    * 借阅时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @ApiModelProperty("借阅时间")
    private Date borrowingTime;
    /**
    * 归还时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @ApiModelProperty("归还时间")
    private Date returnTime;
    /**
    * 状态  申请、驳回、已借、逾期、归还
    */
    @ApiModelProperty("状态")
    private String status;
    /**
    * 操作人
    */
    @ApiModelProperty("操作人")
    private String operator;

}