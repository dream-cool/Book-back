package com.clt.controller;

import com.clt.entity.IncreaseBook;
import com.clt.service.StatisticsService;
import com.clt.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * (Statistics)表控制层
 *
 * @author makejava
 * @since 2020-03-05 09:36:20
 */
@RestController
@RequestMapping("statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/bookBorrowingRatio")
    @ApiOperation("统计书籍借阅比例")
    public ResultUtil<List<Map<Object, Object>>> bookBorrowingRatio() {
        return ResultUtil.success(statisticsService.bookBorrowingRatio());
    }

    @GetMapping("/bookStorageByTime")
    @ApiOperation("根据时间统计藏量")
    public ResultUtil<List<IncreaseBook>> bookStorageByTime(@ApiParam(value = "timeSlot", required = true, defaultValue = "day")
                                                                   @RequestParam(value = "timeSlot", required = false) String timeSlot) {
        return ResultUtil.success(statisticsService.bookStorageByTime(timeSlot));
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