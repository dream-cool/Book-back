package com.clt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Category)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:04:25
 */

@Getter
@Setter
@ToString
@ApiModel("书籍类别实体")
public class Category implements Serializable {
    private static final long serialVersionUID = -18433112059573873L;
    /**
     * 类别id
     */
    @ApiModelProperty("类别id")
    private String categoryId;
    /**
     * 一级分类
     */
    @ApiModelProperty("一级分类")
    private String firstType;
    /**
     * 二级分类
     */
    @ApiModelProperty("二级分类")
    private String secondType;
    /**
     * 三级分类
     */
    @ApiModelProperty("三级分类")
    private String thirdType;

    /**
     * 判断当前类别是否是最后一类
     */
    public boolean isParent(int level) {
        checkLevel(level);
        switch (level) {
            case 1:
                return secondType != null;
            case 2:
                return thirdType != null;
            default:
                return false;
        }
    }

    /**
     * 根据级别查询类别名称
     */
    public String getCategoryNameByLevel(int level) {
        checkLevel(level);
        switch (level) {
            case 1:
                return firstType;
            case 2:
                return secondType;
            case 3:
                return thirdType;
            default:
                return null;
        }

    }

    private boolean checkLevel(int level) {
        if (level <= 0 || level > 3) {
            throw new IllegalArgumentException("类别错误");
        }
        return true;
    }

    /**
     * 根据级别查编号
     */
    public String getCategoryIdByLevel(int level) {
        checkLevel(level);
        switch (level) {
            case 1:
                return categoryId.substring(0, 2).concat("000000");
            case 2:
                return categoryId.substring(0, 5).concat("000");
            case 3:
                return categoryId.substring(0, 8);
            default:
                return null;
        }
    }

}