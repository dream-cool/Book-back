package com.clt.enums;

import com.clt.constant.Const;

/**
 * @author ：clt
 * @Date ：Created in 19:07 2020/02/25
 */
public enum BorrowingEnum {

    BORROWING_STATUS_CANCEL(Const.BORROWING_STATUS_CANCEL, "0"),

    BORROWING_STATUS_APPLYING(Const.BORROWING_STATUS_APPLYING, "1"),

    BORROWING_STATUS_REFUSED(Const.BORROWING_STATUS_REFUSED, "2"),

    BORROWING_STATUS_LENT(Const.BORROWING_STATUS_LENT, "3"),

//    BORROWING_STATUS_OVERDUE(Const.BORROWING_STATUS_OVERDUE, "4"),

    BORROWING_STATUS_OVERDUE_RETURN(Const.BORROWING_STATUS_OVERDUE_RETURN, "5"),

    BORROWING_STATUS_NORMAL_RETURN(Const.BORROWING_STATUS_NORMAL_RETURN, "6");

    private String message;

    private String code;


    BorrowingEnum(String message, String code) {
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
