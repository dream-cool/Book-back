package com.clt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (Book)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:03:24
 */
@Getter
@Setter
@ApiModel("书籍实体")
public class Book implements Serializable {
    private static final long serialVersionUID = -35522362005481450L;
    /**
    * 书籍id
    */
    @ApiModelProperty("书籍id")
    private String bookId;
    /**
    * 类别id
    */
    @ApiModelProperty("类别id")
    private String categoryId;
    /**
    * 书籍名称
    */
    @ApiModelProperty("书籍名称")
    private String bookName;
    /**
    * 书籍描述
    */
    @ApiModelProperty("书籍描述")
    private String bookDescribe;
    /**
    * 书籍作者
    */
    @ApiModelProperty("书籍作者")
    private String author;
    /**
    * 出版社
    */
    @ApiModelProperty("出版社")
    private String published;
    /**
    * 价格
    */
    @ApiModelProperty("价格")
    private Double price;
    /**
    * 书籍状态  在库 已借
    */
    @ApiModelProperty("书籍状态  在库 已借")
    private String bookStatus;
    /**
    * 书籍封面
    */
    @ApiModelProperty("书籍封面")
    private String img;
    /**
    * 是否是电子书
    */
    @ApiModelProperty("是否是电子书")
    private Integer ebook;
    /**
    * 书籍位置
    */
    @ApiModelProperty("书籍位置")
    private String location;
    /**
    * 点赞数量
    */
    @ApiModelProperty("点赞数量")
    private Integer zanNumber;
    /**
    * 得分
    */
    @ApiModelProperty("得分")
    private Integer score;
    /**
    * 录入时间
    */
    @ApiModelProperty("录入时间")
    private Date inputTime;
    /**
    * 修改时间
    */
    @ApiModelProperty("修改时间")
    private Date updateTime;

}