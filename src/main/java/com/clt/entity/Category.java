package com.clt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * (Category)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:04:25
 */

@Getter
@Setter
@ApiModel("书籍类别实体")
public class Category implements Serializable {
    private static final long serialVersionUID = -18433112059573873L;
    /**
     * 类别id
     */
    @ApiModelProperty("类别id")
    private Integer categoryId;
    /**
     * 一级分类
     */
    @ApiModelProperty("一级分类")
    private String firstCategory;
    /**
     * 二级分类
     */
    @ApiModelProperty("二级分类")
    private String secondCategory;
    /**
     * 三级分类
     */
    @ApiModelProperty("三级分类")
    private String thirdCategory;
}