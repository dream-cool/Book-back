package com.clt.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ：clt
 * @Date ：Created in 19:29 2020/02/25
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("邮件信息实体")
public class Email {
    private static final long serialVersionUID = -2116367492649751914L;

    /**
     *邮件接收人
     */
    @ApiModelProperty("邮件接收人")
    private String recipient;

    /**
     *邮件主题
     */
    @ApiModelProperty("邮件主题")
    private String subject;

    /**
     *邮件内容
     */
    @ApiModelProperty("邮件内容")
    private String content;
}
