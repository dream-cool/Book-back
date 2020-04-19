package com.clt.schedule;

import com.clt.dao.SchedulingTaskDao;
import com.clt.utils.ScheduledTaskUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author ：clt
 * @Date ：Created in 11:14 2020/04/18
 */
@Configuration
public class InsertYesterdayStatisticsScheduleTask implements SchedulingConfigurer {

    private static Logger logger = LoggerFactory.getLogger(InsertYesterdayStatisticsScheduleTask.class);

    @Autowired
    private ScheduledTaskUtil scheduledTaskUtil;

    @Resource
    private SchedulingTaskDao schedulingTaskDao;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> {
                    logger.info("开始执行新增昨天统计信息的定时任务: " + LocalDateTime.now().toLocalTime());
                    scheduledTaskUtil.insertYesterdayStatisticsService();
                },
                triggerContext -> {
                    String cron = schedulingTaskDao.queryById(5).getCronExpr();
                    if (StringUtils.isEmpty(cron)) {
                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
