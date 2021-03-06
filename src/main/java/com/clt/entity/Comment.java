package com.clt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class Comment implements Serializable, Comparable<Comment> {
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
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    private String avatar;


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
     * 评论内容
     */
    @ApiModelProperty("待提交的评论内容")
    private String commitContent;

    /**
     * 评分
     */
    @ApiModelProperty("评分")
    private Integer score;

    /**
     * 是否是回复评论
     */
    @ApiModelProperty("是否是回复评论")
    private Boolean replyFlag;

    /**
     * 回复id
     */
    @ApiModelProperty("回复id")
    private String replyId;

    /**
     * sortWay
     */
    @ApiModelProperty("排序方式")
    private String sortWay;

    /**
     * 点赞数量
     */
    @ApiModelProperty("点赞数量")
    private Integer zanNumber;

    /**
     * 评论父id
     */
    @ApiModelProperty("评论父id")
    private String commentPid;

    /**
     * 回复用户名
     */
    @ApiModelProperty("备用字段3")
    private String replyUserName;

    /**
     * 用户是否对该评论点赞
     */
    @ApiModelProperty("用户是否对该评论点赞")
    private Boolean isLike;

    /**
     * 正在评论
     */
    @ApiModelProperty("正在评论")
    private boolean replaying;

    /**
     * 显示多少条数据
     */
    @ApiModelProperty("显示多少条数据")
    private int showNumbers = 5;

    /**
     * 子评论
     */
    @ApiModelProperty("子评论")
    private List<Comment> children = new ArrayList<>();

    public void increaseZanNumber(){
        this.zanNumber++;
    }

    public void decreaseZanNumber(){
        this.zanNumber--;
    }

    @Override
    public int compareTo(Comment comment) {
        long time = this.getCommentTime().getTime() - comment.getCommentTime().getTime();
        if (time == 0) {
            return 1;
        }
        return (int)time;
    }
}