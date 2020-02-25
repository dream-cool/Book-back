package com.clt.enums;

import com.clt.constant.Const;

/**
 * @author ：clt
 * @Date ：Created in 19:07 2020/02/25
 */
public enum BookEnum {

    BOOK_IN_LIBRARY(Const.BOOK_IN_LIBRARY_STATUS,"0"),

    BOOK_LEND(Const.BOOK_LEND_STATUS,"1"),

    BOOK_DAMAGE(Const.BOOK_DAMAGE,"2");


    private String message;

    private String code;


    BookEnum(String message,String code){
        this.message = message;
        this.code = code;
    }


    public String getCode(){
        return code;
    }

}
