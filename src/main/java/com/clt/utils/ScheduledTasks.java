package com.clt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author ：clt
 * @Date ：Created in 19:31 2020/04/12
 */
@Component
public class ScheduledTasks {
    Logger logger = LoggerFactory.getLogger(Scheduled.class);

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
//    @Scheduled(cron = firstMethodCronExpr)  //间隔1秒
    public void first() throws InterruptedException {
        logger.info("我执行了");
        Thread.sleep(1000 * 10);
    }
}
