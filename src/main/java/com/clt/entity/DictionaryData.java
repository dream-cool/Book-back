package com.clt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * (DictionaryData)实体类
 *
 * @author makejava
 * @since 2020-03-30 19:07:22
 */
@Getter
@Setter
@ApiModel
public class DictionaryData implements Serializable {
    private static final long serialVersionUID = 181603672119353424L;
    /**
    * 字典数据id
    */
    private String id;
    /**
    * 字典数据编号
    */
    private Integer number;
    /**
    * 字典数据标签
    */
    private String label;
    /**
    * 字典数据键值
    */
    private String value;
    /**
    * 排序号
    */
    private Integer sort;
    /**
    * 状态
    */
    private Integer status;
    /**
    * 备注
    */
    private String note;
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
    * 备用字段1
    */
    private String remark1;
    /**
    * 备用字段2
    */
    private String remark2;
    /**
    * 被用字段3
    */
    private String remark3;
    /**
    * 被用字段4
    */
    private String remark4;

}