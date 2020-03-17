package com.clt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("收藏夹分组实体")
public class CollectionGroup implements Serializable {
    private static final long serialVersionUID = 496583690550169230L;
    /**
    * 收藏分组id
    */
    @ApiModelProperty("收藏分组id")
    private String collectionGroupId;
    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    private String userId;
    /**
    * 分组名称
    */
    @ApiModelProperty("分组名称")
    private String name;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

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
     * 备用字段4
     */
    @ApiModelProperty("备用字段4")
    private String remark4;

    /**
     * 备用字段5
     */
    @ApiModelProperty("备用字段5")
    private String remark5;

    /**
     * 备用字段6
     */
    @ApiModelProperty("备用字段6")
    private String remark6;
}