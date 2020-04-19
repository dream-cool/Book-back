package com.clt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Statistics)实体类
 *
 * @author makejava
 * @since 2020-04-18 21:05:35
 */
@Getter
@Setter
@ToString
@ApiModel("统计数据实体")
public class Statistics implements Serializable {
    private static final long serialVersionUID = -78880555354100539L;
    /**
    * id
    */
    @ApiModelProperty("id")
    private String id;
    /**
    * 时间段
    */
    @ApiModelProperty("时间段")
    private String period;
    /**
    * 用户总量
    */
    @ApiModelProperty("用户总量")
    private Long totalUser;
    /**
    * 纸质书总量
    */
    @ApiModelProperty("纸质书总量")
    private Long totalPaperBook;
    /**
    * 借出书籍总量
    */
    @ApiModelProperty("借出书籍总量")
    private Long totalLentBook;
    /**
    * 昨天处理借阅数量
    */
    @ApiModelProperty("昨天处理借阅数量")
    private Integer yesterdayHandle;
    /**
    * 昨天归还书籍数量
    */
    @ApiModelProperty("昨天归还书籍数量")
    private Integer yesterdayReturn;
    /**
    * 昨天申请借阅数量
    */
    @ApiModelProperty("昨天申请借阅数量")
    private Integer yesterdayApply;
    /**
     * 备用字段1
     */
    @ApiModelProperty("备用字段1")
    private String remark1;

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

}