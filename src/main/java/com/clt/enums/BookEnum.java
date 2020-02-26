package com.clt.enums;

import com.clt.constant.Const;

/**
 * @author ：clt
 * @Date ：Created in 19:07 2020/02/25
 */
public enum BookEnum {

    BOOK_STATUS_IN_LIBRARY(Const.BOOK_IN_LIBRARY_STATUS,"0"),

    BOOK_STATUS_LEND(Const.BOOK_LEND_STATUS,"1"),

    BOOK_STATUS_DAMAGE(Const.BOOK_DAMAGE,"2"),

    BOOK_TYPE_EBOOK(Const.BOOK_EBOOK,"1"),

    BOOK_TPYE_PAPER(Const.BOOK_PAPER,"0");


    private String message;

    private String code;


    BookEnum(String message,String code){
        this.message = message;
        this.code = code;
    }


    public String getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
