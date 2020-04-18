package com.clt.utils;

import com.clt.constant.Const;
import com.clt.dao.BookDao;
import com.clt.dao.UserDao;
import com.clt.entity.Book;
import com.clt.entity.Borrowing;
import com.clt.entity.User;
import com.clt.enums.BookEnum;
import com.clt.enums.BorrowingEnum;
import com.clt.service.BorrowingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author ：clt
 * @Date ：Created in 19:31 2020/04/12
 */
@Component
public class ScheduledTaskUtil {
    private static Logger logger = LoggerFactory.getLogger(Scheduled.class);

    @Autowired
    private static UserDao userDao;

    @Autowired
    private static BookDao bookDao;

    @Autowired
    private static BorrowingService borrowingService;

    /**
     * @param userName     数据库的用户名
     * @param password     数据库的密码
     * @param savePath     备份的路径
     * @param fileName     备份的文件名
     * @param databaseName 需要备份的数据库的名称
     * @return
     */
    public static void backupDatabase(
            @Value("${spring.datasource.username}") String userName,
            @Value("${spring.datasource.password}") String password,
            @Value("${spring.datasource.database}") String databaseName,
            String savePath,
            String fileName) {
        fileName += databaseName + "_";
        fileName = DateUtils.getDateString(new Date());
        fileName += ".sql";
        savePath = Const.filePath + File.separator + "backup";
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }
        StringBuilder stringBuilder = new StringBuilder("docker exec mysql mysqldump -u");
        stringBuilder.append(userName).append(" -p").append(password).append("  ").append(databaseName)
                .append(" > ").append("/data/mysql/library_$(date +%Y-%m-%d %H:%M:%S).sql");
        InputStream in = null;
        try {
            String[] cmds = {"/bin/bash", "-c", stringBuilder.toString()};
            Process pro = Runtime.getRuntime().exec(cmds);
            if (pro.waitFor() == 0) {
                logger.info("备份成功");
            }
            in = pro.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            String result = read.readLine();
            if (result != null) {
                logger.error("备份失败，{}", result);
            }
        } catch (Exception e) {
            logger.error("备份失败，{}", e.getMessage());
            e.printStackTrace();
        }
    }

    public static void bookImgFileCleanup() {
        final List<Book> theAllBook = bookDao.queryAllByCondition(null);
        final List<User> theAllUser = userDao.queryAllByCondition(null);
        int cleanupNumber = 0;
        File theAllFile = new File(Const.filePath);
        for (String file : theAllFile.list()) {
            boolean fileIsUsed = false;
            for (Book book : theAllBook) {
                if (file.equals(book.getImg()) || file.equals(book.getLocation())){
                    fileIsUsed = true;
                }
            }
            for (User user : theAllUser) {
                if (user.getAvatar() != null && user.getAvatar().equals(file)){
                    fileIsUsed = true;
                }
            }
            if (!fileIsUsed){
                File fileResources = new File(file);
                fileResources.delete();
                cleanupNumber++;
            }
        }
        logger.info("文件清理完成,共清理{}个文件" + cleanupNumber);
    }

    public static void userAvatarFileCleanup(){
        List<User> theAllUser = userDao.queryAllByCondition(null);
        File theAllFile = new File(Const.filePath);
        for (String file : theAllFile.list()) {
            boolean fileIsUsed = false;
            for (User user : theAllUser) {
                if (user.getAvatar() != null && user.getAvatar().equals(file)){
                    fileIsUsed = true;
                }
            }
            if (!fileIsUsed){
                File fileResources = new File(file);
                fileResources.delete();
            }
        }
    }

    public static void ebookFileCleanup(){

    }

    public static void integralCalculate() {
        List<User> theAllUser = userDao.queryAllByCondition(null);
        Borrowing condition = new Borrowing();
        condition.setBorrowingStatus(BorrowingEnum.BORROWING_STATUS_LENT.getCode());
        final List<Borrowing> theAllLentBorrowingInfo = borrowingService.queryAllByCondition(condition);

        Set<String> overReturnUser = new HashSet<>();
        //针对所有已借的书籍，如果存在一条逾期记录，则扣除对应用户1点credit
        theAllLentBorrowingInfo.forEach(borrowing -> {
            if (borrowing.getOverdueDays() != null){
                overReturnUser.add(borrowing.getUserId());
                final User user = userDao.queryById(borrowing.getUserId());
                user.decreaseCredit(1);
                userDao.update(user);
            }
        });

        //针对不存在逾期记录的用户且信誉低于90的，给予信誉恢复，即新增1点credit
        theAllUser.stream().forEach(user -> {
            if (!overReturnUser.contains(user.getUserId())){
                user.increaseCredit(1);
                userDao.update(user);
            }
        });
        logger.info("积分清算完成");
    }


    public static void main(String[] args) {
    }
}
