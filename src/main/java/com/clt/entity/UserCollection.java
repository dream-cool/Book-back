package com.clt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserCollection)实体类
 *
 * @author makejava
 * @since 2020-03-15 15:21:22
 */
@Getter
@Setter
@ApiModel
public class UserCollection implements Serializable {
    private static final long serialVersionUID = -95239092807829042L;
    /**
    * 收藏id
    */
    @ApiModelProperty(value = "收藏id")
    private String collectionId;
    /**
    * 用户id
    */
    @ApiModelProperty(value = "用户id")
    private String userId;
    /**
    * 书籍id
    */
    @ApiModelProperty(value = "书籍id")
    private String bookId;
    /**
    * 收藏时间
    */
    @ApiModelProperty(value = "收藏时间")
    private Date collectionTime;
    /**
    * 书籍名称
    */
    @ApiModelProperty(value = "书籍名称")
    private String bookName;
    /**
    * 书籍描述
    */
    @ApiModelProperty(value = "书籍描述")
    private String descr;
    /**
    * 书籍图片
    */
    @ApiModelProperty(value = "书籍图片")
    private String bookImg;
    /**
    * 赞标志
    */
    @ApiModelProperty(value = "赞标志")
    private Boolean isLike;
    /**
    * 收藏标志
    */
    @ApiModelProperty(value = "收藏标志")
    private Boolean isCollect;
    /**
    * 备用字段1
    */
    @ApiModelProperty(value = "备用字段1")
    private String remark1;
    /**
    * 备用字段2
    */
    @ApiModelProperty(value = "备用字段2")
    private String remark2;
    /**
    * 备用字段3
    */
    @ApiModelProperty(value = "备用字段3")
    private String remark3;

}