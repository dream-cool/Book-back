package com.clt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * (Message)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:04:45
 */
@Getter
@Setter
@ToString
@ApiModel("信息实体")
public class Message implements Serializable {
    private static final long serialVersionUID = -71244208830908192L;
    /**
     * 信息id
     */
    @ApiModelProperty("信息id")
    private String messageId;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;
    /**
     * 发送时间
     */
    @ApiModelProperty("发送时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendingTime;
    /**
     * 信息内容
     */
    @ApiModelProperty("信息内容")
    private String content;
    /**
     * 信息状态  已读、未读
     */
    @ApiModelProperty("信息状态  已读、未读")
    private Integer status;

}