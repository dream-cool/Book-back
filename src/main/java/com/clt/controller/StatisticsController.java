package com.clt.controller;

import com.clt.entity.IncreaseBook;
import com.clt.entity.Statistics;
import com.clt.enums.LogOperationTypeEnum;
import com.clt.service.StatisticsService;
import com.clt.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (Statistics)表控制层
 *
 * @author makejava
 * @since 2020-04-18 21:05:37
 */
@RestController
@RequestMapping("statistics")
public class StatisticsController {
    /**
     * 服务对象
     */
    @Resource
    private StatisticsService statisticsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Statistics selectOne(String id) {
        return this.statisticsService.queryById(id);
    }

    /**
     * 获取昨天的统计数据
     *
     * @return 单条数据
     */
    @GetMapping("query/yesterdayInfo")
    public ResultUtil<Statistics> queryYesterdayInfo() {
        final Statistics info = this.statisticsService.queryYesterdayInfo();
        if (info != null){
            return ResultUtil.success(info, "查询成功");
        } else {
            return ResultUtil.failed("查询信息失败");
        }
    }

    /**
     * 查询所有数据
     *
     * @return 多条数据
     */
    @PostMapping("/all")
    @ApiOperation("查询所有数据")
    public ResultUtil<List<Statistics>> selectAllByLimit(
    ) {
        List<Statistics> info = this.statisticsService.queryAllByCondition(null);
        if (info != null) {
            return ResultUtil.success(info, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }

    @GetMapping("/bookBorrowingRatio")
    @ApiOperation("统计书籍借阅比例")
    public ResultUtil<List<Map<Object, Object>>> bookBorrowingRatio() {
        return ResultUtil.success(statisticsService.bookBorrowingRatio());
    }

    @GetMapping("/bookStorageByTime")
    @ApiOperation("根据时间统计藏量")
    public ResultUtil<List<IncreaseBook>> bookStorageByTime(
            @ApiParam(value = "timeSlot", required = true, defaultValue = "day")
            @RequestParam(value = "timeSlot") String timeSlot,
            @ApiParam(value = "start")
            @RequestParam(value = "start", required = false) String start,
            @ApiParam(value = "end")
            @RequestParam(value = "end", required = false) String end
    ) {
        Date startTime = null;
        Date endTime = null;
        if (start != null && !start.equals("undefined") && end != null && !end.equals("undefined")){
            startTime = new Date(Long.valueOf(start));
            endTime = new Date(Long.valueOf(end));
        }
        return ResultUtil.success(statisticsService.bookStorageByTime(timeSlot, startTime, endTime));
    }


    @GetMapping("/bookStorageByCategory")
    @ApiOperation("根据类别统计藏量")
    public ResultUtil<List<Map<Object, Object>>> bookStorageByCategory() {
        return ResultUtil.success(statisticsService.bookStorageByCategory());
    }


    @ApiOperation("统计读者变化趋势")
    @GetMapping("/readerNumbersByTime")
    public ResultUtil<List<Map<Object, Object>>> readerNumbersByTime(@ApiParam(value = "timeSlot", required = true, defaultValue = "day")
                                                                     @RequestParam(value = "timeSlot", required = false) String timeSlot) {
        return ResultUtil.success(statisticsService.readerNumbersByTime(timeSlot));
    }

}