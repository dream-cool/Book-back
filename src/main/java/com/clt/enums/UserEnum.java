package com.clt.enums;

import com.clt.constant.Const;

/**
 * @author ：clt
 * @Date ：Created in 19:06 2020/02/25
 */
public enum UserEnum {
    USER_SEX_MALE(Const.USER_SEX_MALE, "1"),

    USER_SEX_FEMALE(Const.USER_SEX_FEMALE, "0"),

    USER_STATUS_LOCKED(Const.USER_STATUS_LOCKED, "0"),

    USER_STATUS_NORMAL(Const.USER_STATUS_NORMAL, "1"),

    USER_ROLE_STUDENT(Const.USER_ROLE_STUDENT, "0"),

    USER_ROLE_TEACHER(Const.USER_ROLE_TEACHER, "1"),

    USER_ROLE_ADMIN(Const.USER_ROLE_ADMIN, "2"),

    USER_POLE_SUPER_ADMIN(Const.USER_ROLE_SUPER_ADMIN, "3");

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
