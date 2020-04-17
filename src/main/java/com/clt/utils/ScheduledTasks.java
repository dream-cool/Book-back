package com.clt.utils;

import com.clt.constant.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author ：clt
 * @Date ：Created in 19:31 2020/04/12
 */
@Component
public class ScheduledTasks {
    private  static  Logger logger = LoggerFactory.getLogger(Scheduled.class);

    private static final String firstMethodCronExpr = "0/5 * * * * ?";

    public void test(){
        try {
            final Field firstMethodCronExpr = ScheduledTasks.class.getField("firstMethodCronExpr");
            firstMethodCronExpr.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Async
    @Scheduled(cron = "0 0 0 * * ?")  //间隔1秒
    public void scheduledBackupDatabase(){
        backup("root", "123456", "library", "/data/mysql/", "libar");
    }

    /**
     * @param userName 数据库的用户名
     * @param password 数据库的密码
     * @param savePath 备份的路径
     * @param fileName 备份的文件名
     * @param databaseName 需要备份的数据库的名称
     * @return
     */
    public static void backup(
                                 @Value("${spring.datasource.username}") String userName,
                                 @Value("${spring.datasource.password}") String password,
                                 @Value("${spring.datasource.database}") String databaseName,
                                 String savePath,
                                 String fileName) {
        fileName += databaseName + "_";
        fileName = DateUtils.getDateString(new Date());
        fileName +=".sql";
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
                .append(" > ").append( "/data/mysql/library_$(date +%Y%m%d).sql");
        InputStream in = null;
        try {
            String[] cmds =  {"/bin/bash", "-c", stringBuilder.toString()};
            Process pro = Runtime.getRuntime().exec(cmds);
            if (pro.waitFor() == 0) {
                logger.info("备份成功");
            }
            in = pro.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            String result = read.readLine();
            logger.error("备份失败，{}", result);
        } catch (Exception e) {
            logger.error("备份失败，{}", e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
