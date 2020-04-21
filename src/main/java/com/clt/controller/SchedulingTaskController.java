package com.clt.controller;

import com.clt.annotation.Log;
import com.clt.entity.SchedulingTask;
import com.clt.enums.LogOperationTypeEnum;
import com.clt.service.SchedulingTaskService;
import com.clt.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @PostMapping("/all")
    @ApiOperation("分页查询定时任务列表")
    @Log(value = "分页查询定时任务列表", method = LogOperationTypeEnum.QUERY)
    public ResultUtil<PageInfo<SchedulingTask>> selectAllByPage(
            @ApiParam("页码") @RequestParam(required = false) Integer pageNum,
            @ApiParam("每页大小") @RequestParam(required = false) Integer pageSize,
            @RequestBody SchedulingTask schedulingTask
    ) {
        pageNum = (pageNum == null || pageNum < 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize < 0) ? 10 : pageSize;
        Page page = PageHelper.startPage(pageNum, pageSize);
        this.schedulingTaskService.queryAllByCondition(schedulingTask);
        PageInfo<SchedulingTask> pageInfo = new PageInfo<>(page);
        if (pageInfo != null) {
            return ResultUtil.success(pageInfo, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    /**
     * 通过实体数据更新单条数据
     *
     * @param SchedulingTask 定时任务实体
     * @return 更新的数据
     */
    @PutMapping("")
    @ApiOperation("修改定时任务")
    @Log(value = "修改定时任务", method = LogOperationTypeEnum.UPDATE)
    public ResultUtil<SchedulingTask> update(@RequestBody SchedulingTask schedulingTask) {
        if (this.schedulingTaskService.queryById(schedulingTask.getId()) == null) {
            return ResultUtil.failed("修改失败，没有找到对应信息");
        }
        SchedulingTask updateSchedulingTask = this.schedulingTaskService.update(schedulingTask);
        if (updateSchedulingTask != null) {
            return ResultUtil.success(updateSchedulingTask, "修改成功");
        } else {
            return ResultUtil.failed("修改失败");
        }
    }

}