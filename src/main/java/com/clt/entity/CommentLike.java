package com.clt.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * (CommentLike)实体类
 *
 * @author makejava
 * @since 2020-03-15 20:08:26
 */
@Getter
@Setter
@ToString
@ApiModel
public class CommentLike implements Serializable {
    private static final long serialVersionUID = 364850368142316699L;
    /**
    * id
    */
    private String commentLikeId;
    /**
    * 评论id
    */
    private String commentId;
    /**
    * 用户id
    */
    private String userId;
    
    private Boolean isLike;
    
    private String remark1;
    
    private String remark2;
    
    private String remark3;
    
    private String remark4;
    
    private String remark5;

}