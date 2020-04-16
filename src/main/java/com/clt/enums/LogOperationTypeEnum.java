package com.clt.enums;

/**
 * @author ：clt
 * @Date ：Created in 19:31 2020/04/16
 */
public enum  LogOperationTypeEnum {

    QUERY("查询"),

    LOGIN("登录"),

    UPDATE("修改"),

    INSERT("新增"),

    DELETE("删除");

    private String message;

    LogOperationTypeEnum(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
