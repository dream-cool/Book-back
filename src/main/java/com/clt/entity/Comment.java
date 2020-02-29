package com.clt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (Comment)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:04:35
 */
@Getter
@Setter
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date commentTime;
    /**
    * 赞标志
    */
    @ApiModelProperty("赞标志")
    private Integer zanFlag;
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
}