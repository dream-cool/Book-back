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
 * (Comment)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:04:35
 */
@Getter
@Setter
@ToString
@ApiModel("评论信息实体")
public class Comment implements Serializable {
    private static final long serialVersionUID = 796800846076565731L;
    /**
     * 评论id
     */
    @ApiModelProperty("评论id")
    private String commentId;
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
     * 评论时间
     */
    @ApiModelProperty("评论时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentTime;

    /**
     * 评论内容
     */
    @ApiModelProperty("评论内容")
    private String content;
    /**
     * 评分
     */
    @ApiModelProperty("评分")
    private Integer score;
    /**
     * 是否是回复评论
     */
    @ApiModelProperty("是否是回复评论")
    private Integer replyFlag;

    /**
     * 回复id
     */
    @ApiModelProperty("回复id")
    private String replyId;

    /**
     * sortWay
     */
    @ApiModelProperty("回复id")
    private String sortWay;

    /**
     * 点赞数量
     */
    @ApiModelProperty("点赞数量")
    private Integer zanNumber;

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

    /**
     * 用户实体信息
     */
    @ApiModelProperty("用户实体信息")
    private User user;

    /**
     * 用户是否对该评论点赞
     */
    @ApiModelProperty("用户是否对该评论点赞")
    private Boolean isLike;

    public void increaseZanNumber(){
        this.zanNumber++;
    }

    public void decreaseZanNumber(){
        this.zanNumber--;
    }
}