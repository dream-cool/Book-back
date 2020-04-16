package com.clt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author ：clt
 * @Date ：Created in 18:25 2020/04/16
 */
@Getter
@Setter
@ToString
@ApiModel("日志实体")
public class WebLog {

    /**
     * id
     */
    @ApiModelProperty("id")
    private String id;
    /**
     * 操作用户
     */
    @ApiModelProperty("操作用户")
    private String userName;

    /**
     * 操作描述
     */
    @ApiModelProperty("id")
    private String operation;

    /**
     * 操作类型
     */
    @ApiModelProperty("操作类型")
    private String type;

    /**
     * 操作时间
     */
    @ApiModelProperty("id")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 消耗时间
     */
    @ApiModelProperty("id")
    private Long spendTime;

    /**
     * URL
     */
    @ApiModelProperty("id")
    private String url;

    /**
     * 请求类型
     */
    @ApiModelProperty("id")
    private String method;

    /**
     * IP地址
     */
    @ApiModelProperty("id")
    private String ip;

    /**
     *  请求参数
     */
    @ApiModelProperty("id")
    private String parameter;

    /**
     *  返回结果
     */
    @ApiModelProperty("id")
    private String result;

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

}
