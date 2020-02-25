package com.clt.enums;

/**
 * @author ：clt
 * @Date ：Created in 19:12 2020/02/25
 */
public enum ResultEnum {

    SUCCESS("操作成功",200),
    FAIL("操作失败",500),
    NOTFOUND("找不到资源",404),
    NOAUTHENTICATION("没有认证",401);


    private String message;

    private Integer code;

    ResultEnum(String message, Integer code){
        this.message = message;
        this.code = code;
    }

    public String getMessage(){
        return message;
    }

    public Integer getCode(){
        return code;
    }

}
