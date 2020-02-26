package com.clt.enums;

import com.clt.constant.Const;

/**
 * @author ：clt
 * @Date ：Created in 19:08 2020/02/25
 */
public enum MessageEnum {

    MESSAGE_READ(Const.MESSAGE_READ, "1"),

    MESSAGE_UNREAD(Const.MESSAGE_UNREAD, "0");

    private String message;

    private String code;


    MessageEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }


    public String getCode() {
        return code;
    }

    public String getMessage(){
        return message;
    }

}
