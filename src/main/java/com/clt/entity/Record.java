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
 * (Record)实体类
 *
 * @author makejava
 * @since 2020-02-25 19:05:06
 */
@ApiModel("浏览记录实体类")
@Getter
@Setter
@ToString
public class Record implements Serializable {
    private static final long serialVersionUID = 385869734048860757L;
    /**
     * 记录id
     */
    @ApiModelProperty("记录id")
    private String recordId;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;
    /**
     * 书籍id
     */
    @ApiModelProperty("书籍id")
    private String bookId;
    /**
     * 浏览时间
     */
    @ApiModelProperty("浏览时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date browsingTime;
    /**
     * 书籍封面
     */
    @ApiModelProperty("书籍封面")
    private String bookImg;
    /**
     * 书籍名称
     */
    @ApiModelProperty("书籍名称")
    private String bookName;

}