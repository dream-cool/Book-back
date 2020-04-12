package com.clt.controller;

import com.clt.entity.SchedulingTask;
import com.clt.service.SchedulingTaskService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SchedulingTask)表控制层
 *
 * @author makejava
 * @since 2020-04-12 19:21:14
 */
@RestController
@RequestMapping("schedulingTask")
public class SchedulingTaskController {
    /**
     * 服务对象
     */
    @Resource
    private SchedulingTaskService schedulingTaskService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SchedulingTask selectOne(Integer id) {
        return this.schedulingTaskService.queryById(id);
    }

}