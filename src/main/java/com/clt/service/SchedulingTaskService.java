package com.clt.service;

import com.clt.entity.SchedulingTask;
import org.springframework.scheduling.config.ScheduledTask;

import java.util.List;

/**
 * (SchedulingTask)表服务接口
 *
 * @author makejava
 * @since 2020-04-12 19:21:14
 */
public interface SchedulingTaskService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SchedulingTask queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SchedulingTask> queryAllByLimit(int offset, int limit);

    List<SchedulingTask> queryAllByCondition(SchedulingTask schedulingTask);

    /**
     * 新增数据
     *
     * @param schedulingTask 实例对象
     * @return 实例对象
     */
    SchedulingTask insert(SchedulingTask schedulingTask);

    /**
     * 修改数据
     *
     * @param schedulingTask 实例对象
     * @return 实例对象
     */
    SchedulingTask update(SchedulingTask schedulingTask);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


}