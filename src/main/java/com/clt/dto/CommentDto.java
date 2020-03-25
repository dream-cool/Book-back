package com.clt.dto;

import com.clt.entity.Comment;
import com.clt.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：clt
 * @Date ：Created in 20:37 2020/03/24
 */
public class CommentDto {
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
    private boolean userName;

    /**
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    private boolean avatar;

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

    /**
     * 正在评论
     */
    @ApiModelProperty("正在评论")
    private boolean replaying;

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
}
