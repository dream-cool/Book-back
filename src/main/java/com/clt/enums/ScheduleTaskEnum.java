package com.clt.enums;

/**
 * @author ：clt
 * @Date ：Created in 19:16 2020/04/21
 */
public enum ScheduleTaskEnum {
    CLEANUP_FILE("清理文件","2"),
    INTEGRAL_SETTLEMENT("信誉分清算","3"),
    BACKUP_DATABASE("数据库备份","4"),
    INSERT_YESTERDAY_STATISTICS("持久化统计信息","5");

    private String message;

    private String code;

    ScheduleTaskEnum(String message,String code){
        this.message = message;
        this.code = code;
    }

    public String getMessage(){
        return this.message;
    }

    public String getCode(){
        return this.code;
    }
}
