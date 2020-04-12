package com.clt.service.impl;

import com.clt.entity.SchedulingTask;
import com.clt.dao.SchedulingTaskDao;
import com.clt.service.SchedulingTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SchedulingTask)表服务实现类
 *
 * @author makejava
 * @since 2020-04-12 19:21:14
 */
@Service("schedulingTaskService")
public class SchedulingTaskServiceImpl implements SchedulingTaskService {
    @Resource
    private SchedulingTaskDao schedulingTaskDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SchedulingTask queryById(Integer id) {
        return this.schedulingTaskDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SchedulingTask> queryAllByLimit(int offset, int limit) {
        return this.schedulingTaskDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param schedulingTask 实例对象
     * @return 实例对象
     */
    @Override
    public SchedulingTask insert(SchedulingTask schedulingTask) {
        this.schedulingTaskDao.insert(schedulingTask);
        return schedulingTask;
    }

    /**
     * 修改数据
     *
     * @param schedulingTask 实例对象
     * @return 实例对象
     */
    @Override
    public SchedulingTask update(SchedulingTask schedulingTask) {
        this.schedulingTaskDao.update(schedulingTask);
        return this.queryById(schedulingTask.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.schedulingTaskDao.deleteById(id) > 0;
    }
}