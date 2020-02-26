package com.clt.enums;

import com.clt.constant.Const;

/**
 * @author ：clt
 * @Date ：Created in 19:06 2020/02/25
 */
public enum UserEnum {
    USER_SEX_MALE(Const.USER_SEX_MALE, "1"),

    USER_SEX_FEMALE(Const.USER_SEX_FEMALE, "0"),

    USER_ROLE_READER(Const.USER_ROLE_READER, "1"),

    USER_ROLE_ADMIN(Const.USER_ROLE_ADMIN, "2"),

    USER_SUPER_ADMIN(Const.USER_ROLE_SUPER_ADMIN, "3");


    private String message;

    private String code;


    UserEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }


    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
