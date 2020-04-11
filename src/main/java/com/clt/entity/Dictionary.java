package com.clt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (Dictionary)实体类
 *
 * @author makejava
 * @since 2020-03-30 19:06:56
 */
@Getter
@Setter
@ApiModel()
public class Dictionary implements Serializable {
    private static final long serialVersionUID = 162013928593318573L;
    /**
    * 字典id
    */
    private String id;
    /**
    * 字典编号
    */
    private String number;
    /**
    * 字典名称
    */
    private String name;
    /**
    * 字典类型
    */
    private String type;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 备注
    */
    private String note;
    /**
     * 排序号
     */
    private Integer sort;
    /**
    * 创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
    * 修改时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
    * 备用字段2
    */
    private String remark2;
    /**
    * 备用字段3
    */
    private String remark3;
    /**
    * 备用字段4
    */
    private String remark4;

}