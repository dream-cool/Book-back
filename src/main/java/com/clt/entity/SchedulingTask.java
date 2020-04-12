package com.clt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (SchedulingTask)实体类
 *
 * @author makejava
 * @since 2020-04-12 19:21:14
 */
@Getter
@Setter
@ApiModel("定时任务实体")
public class SchedulingTask implements Serializable {
    private static final long serialVersionUID = 829893157659973142L;
    /**
    * 任务编号
    */
    @ApiModelProperty("任务编号")
    private Integer id;
    /**
    * 任务名称
    */
    @ApiModelProperty("任务名称")
    private String taskName;
    /**
    * cron表达式
    */
    @ApiModelProperty("cron表达式")
    private String cronExpr;
    /**
    * 执行方法
    */
    @ApiModelProperty("执行方法")
    private String excuteMethod;
    /**
    * 状态
    */
    @ApiModelProperty("状态")
    private Integer status;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
    * 修改时间
    */
    @ApiModelProperty("修改时间")
    private Date updateTime;
    /**
    * 说明
    */
    @ApiModelProperty("说明")
    private String note;

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


}