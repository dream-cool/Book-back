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
 * (Type)实体类
 *
 * @author makejava
 * @since 2020-02-28 20:31:34
 */
@Setter
@Getter
@ToString
@ApiModel("书籍分类实体")
public class Type implements Serializable {
    private static final long serialVersionUID = 599543200797582581L;

    /**
     * 分类id
     */
    @ApiModelProperty("分类id")
    private String id;

    /**
     * 父id
     */
    @ApiModelProperty("父id")
    private String pid;

    /**
     * 类别名称
     */
    @ApiModelProperty("类别名称")
    private String name;

    /**
     * 类别级别
     */
    @ApiModelProperty("类别级别")
    private Integer level;

    /**
     * 排序号
     */
    @ApiModelProperty("排序号")
    private Integer sort;

    /**
     * 类别标题
     */
    @ApiModelProperty("类别标题")
    private String title;

    /**
     * 类别图标
     */
    @ApiModelProperty("类别图标")
    private String icon;

    /**
     * 是否隐藏
     */
    @ApiModelProperty("是否隐藏")
    private Integer hidden;

    /**
     * 类别创建时间
     */
    @ApiModelProperty("类别创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 父类名称
     */
    @ApiModelProperty("父类名称")
    private String pName;

    /**
     * 子类数组
     */
    @ApiModelProperty("子类数组")
    private List<Type> children = new ArrayList<>(0);

}