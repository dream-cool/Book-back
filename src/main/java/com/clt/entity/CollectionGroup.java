package com.clt.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * (CollectionGroup)实体类
 *
 * @author makejava
 * @since 2020-03-16 20:36:51
 */
@Getter
@Setter
@ApiModel
public class CollectionGroup implements Serializable {
    private static final long serialVersionUID = 496583690550169230L;
    /**
    * 收藏分组id
    */
    private String collectionGroupId;
    /**
    * 用户id
    */
    private String userId;
    /**
    * 分组名称
    */
    private String name;

    private Date createTime;
    
    private String remark2;
    
    private String remark3;
    
    private String remark4;
    
    private String remark5;
    
    private String remark6;
}