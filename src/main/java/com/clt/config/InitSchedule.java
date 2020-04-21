package com.clt.config;

import com.clt.schedule.BackupDatabaseScheduleTask;
import com.clt.schedule.FileCleanupScheduleTask;
import com.clt.schedule.InsertYesterdayStatisticsScheduleTask;
import com.clt.schedule.IntegralSettlementScheduleTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author ：clt
 * @Date ：Created in 20:20 2020/04/21
 */
@Component
public class InitSchedule implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitSchedule.class);

    @Autowired
    private BackupDatabaseScheduleTask backupDatabaseScheduleTask;

    @Autowired
    private FileCleanupScheduleTask fileCleanupScheduleTask;

    @Autowired
    private InsertYesterdayStatisticsScheduleTask insertYesterdayStatisticsScheduleTask;

    @Autowired
    private IntegralSettlementScheduleTask integralSettlementScheduleTask;



    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("==========init schedule task===========");
        backupDatabaseScheduleTask.startTask();
        fileCleanupScheduleTask.startTask();
        insertYesterdayStatisticsScheduleTask.startTask();
        integralSettlementScheduleTask.startTask();
    }
}
