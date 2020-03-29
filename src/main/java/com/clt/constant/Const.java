package com.clt.constant;

/**
 * @author ：clt
 * @Date ：Created in 19:10 2020/02/25
 */

public class Const {


    private Const() {
    }

    public static final int DEFAULT_CREDIT = 80;

    public static final long BYTE = 1024;

    public static final long KB = 1024 * 1024L;

    public static final long MB = 1024 * 1024 * 1024L;

    public static final long GB = 1024 * 1024 * 1024 * 1024L;

    public static final String BORROWING_STATUS_CANCEL = "已取消";

    public static final String BORROWING_STATUS_APPLYING = "申请中";

    public static final String BORROWING_STATUS_REFUSED = "已驳回";

    public static final String BORROWING_STATUS_LENT = "已借出";

    public static final String BORROWING_STATUS_OVERDUE = "已逾期";

    public static final String BORROWING_STATUS_OVERDUE_RETURN = "逾期归还";

    public static final String BORROWING_STATUS_NORMAL_RETURN = "正常归还";

    public static final String BOOK_IN_LIBRARY_STATUS = "在库";

    public static final String BOOK_LEND_STATUS = "借出";

    public static final String BOOK_DAMAGE = "损坏";

    public static final String BOOK_EBOOK = "电子书";

    public static final String BOOK_PAPER = "纸质书";

    public static final String COMMENT_ZAN = "点赞";

    public static final String COMMENT_CANCEL_ZAN = "取消";

    public static final String MESSAGE_READ = "已读";

    public static final String MESSAGE_UNREAD = "未读";

    public static final String USER_SEX_MALE = "男";

    public static final String USER_SEX_FEMALE = "女";

    public static final String USER_DEFAULT_AVATAR = "userDefaultAvatar.png";

    public static final String USER_ROLE_READER = "读者";

    public static final String USER_ROLE_STUDENT = "学生";

    public static final String USER_ROLE_TEACHER = "老师";

    public static final String USER_ROLE_ADMIN = "管理员";

    public static final String USER_ROLE_SUPER_ADMIN = "超级管理员";

    public static final String USER_STATUS_LOCKED = "锁定";

    public static final String USER_STATUS_NORMAL = "正常";

    public static final String INITIAL_PASSWORD = "888888";

    public static final String DEAFULT_COLLECTION = "默认收藏夹";

    public static final String OPERATION_FAILED = "操作失败";

    public static final String OPERATION_SUCCESS = "操作成功";

    public static final String ERROR_MESSAGE = "error";

    public static final String BOOK_CATEGORY = "type";

    public static final String ITME_LEVEL = "timeSlot";

    public static final String NUMBERS = "numbers";

    public static final String PORT = "8090";

    public static final String SERVER_URL = "http://localhost:" + PORT;

    public static final String ENCRYPTION_ALGORITHM = "MD5";

    public static final int ENCRYPTION_TIMES = 1024;

}
