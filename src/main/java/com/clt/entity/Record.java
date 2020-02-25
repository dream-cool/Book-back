package com.clt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (Record)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:05:06
 */
@ApiModel("浏览记录实体类")
public class Record implements Serializable {
    private static final long serialVersionUID = 385869734048860757L;
    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    private String userId;
    /**
    * 书籍id
    */
    @ApiModelProperty("书籍id")
    private String bookId;
    /**
    * 浏览时间
    */
    @ApiModelProperty("浏览时间")
    private Date browsingTime;
    /**
    * 书籍封面
    */
    @ApiModelProperty("书籍封面")
    private String bookImg;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getBrowsingTime() {
        return browsingTime;
    }

    public void setBrowsingTime(Date browsingTime) {
        this.browsingTime = browsingTime;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

}