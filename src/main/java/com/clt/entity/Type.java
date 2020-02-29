package com.clt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
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
@ApiModel
public class Type implements Serializable {
    private static final long serialVersionUID = 599543200797582581L;
    
    private Integer id;
    
    private Integer pid;
    
    private String name;
    
    private Integer level;
    
    private Integer sort;
    
    private String title;
    
    private String icon;
    
    private Integer hidden;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    private String pName;

    private List<Type> child = new ArrayList<>(0);

}