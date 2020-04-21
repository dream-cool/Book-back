package com.clt.schedule;

import com.clt.dao.SchedulingTaskDao;
import com.clt.entity.SchedulingTask;
import com.clt.enums.ScheduleTaskEnum;
import com.clt.utils.ResultUtil;
import com.clt.utils.ScheduledTaskUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.ScheduledFuture;

/**
 * @author ：clt
 * @Date ：Created in 19:03 2020/04/21
 */
@RestController
public class IntegralSettlementScheduleTask {
    private static Logger logger = LoggerFactory.getLogger(IntegralSettlementScheduleTask.class);

    @Autowired
    private ScheduledTaskUtil scheduledTaskUtil;

    @Resource
    private SchedulingTaskDao schedulingTaskDao;

    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future;

    private SchedulingTask schedulingTask;


    /**
     * /**
     * 启动定时器
     *
     * @return
     */
    @RequestMapping("/integralSettlement/startTask")
    public ResultUtil<Boolean> startTask() {
        /**
         * task:定时任务要执行的方法
         * trigger:定时任务执行的时间
         */
        schedulingTask = schedulingTaskDao.queryById(Integer.valueOf(ScheduleTaskEnum.INTEGRAL_SETTLEMENT.getCode()));
        if ("1".equals(schedulingTask.getStatus())) {
            future = threadPoolTaskScheduler.schedule(new myRunable(), new CronTrigger(schedulingTask.getCronExpr()));
            return ResultUtil.success(true, "启用成功");
        } else {
            return ResultUtil.success(false, "该任务已禁用");
        }
    }

    /**
     * 停止定时任务
     *
     * @return
     */
    @RequestMapping("/integralSettlement/endTask")
    public ResultUtil<Boolean> endTask() {
        if (future != null) {
            future.cancel(true);
        }
        return ResultUtil.success(true, "任务停用成功");
    }

    /**
     * 改变调度的时间
     * 步骤：
     * 1,先停止定时器
     * 2,在启动定时器
     */
    @RequestMapping("/integralSettlement/changeTask")
    public ResultUtil<Boolean> changeTask() {
        //停止定时器
        endTask();
        //定义新的执行时间
        schedulingTask = schedulingTaskDao.queryById(Integer.valueOf(ScheduleTaskEnum.INTEGRAL_SETTLEMENT.getCode()));
        future = threadPoolTaskScheduler.schedule(new myRunable(), new CronTrigger(schedulingTask.getCronExpr()));
        //启动定时器
        startTask();
        return ResultUtil.success(true, "任务调度更改成功");
    }

    @RequestMapping("/integralSettlement/executeOnce")
    public ResultUtil<Boolean> executeOnceTask() {
        new Thread(new myRunable()).start();
        return ResultUtil.success(true, "任务执行成功");
    }

    /**
     * 定义定时任务执行的方法
     *
     * @author Admin
     */
    public class myRunable implements Runnable {
        @Override
        public void run() {
            logger.info("开始执行积分清算定时任务: " + LocalDateTime.now().toLocalTime());
            scheduledTaskUtil.integralCalculate();
        }
    }
}
