package com.clt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (Borrowing)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:03:35
 */
@ApiModel("借阅信息实体")
public class Borrowing implements Serializable {
    private static final long serialVersionUID = -84104176779408312L;
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
    @ApiModelProperty("申请时间")
    private Date applicationTime;
    /**
    * 借阅时间
    */
    @ApiModelProperty("借阅时间")
    private Date borrowingTime;
    /**
    * 归还时间
    */
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


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Date getBorrowingTime() {
        return borrowingTime;
    }

    public void setBorrowingTime(Date borrowingTime) {
        this.borrowingTime = borrowingTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}