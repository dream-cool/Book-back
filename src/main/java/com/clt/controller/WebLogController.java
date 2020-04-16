package com.clt.controller;

import com.clt.entity.WebLog;
import com.clt.service.WebLogService;
import com.clt.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WebLog)表控制层
 *
 * @author makejava
 * @since 2020-04-16 20:45:50
 */
@RestController
@RequestMapping("webLog")
public class WebLogController {
    /**
     * 服务对象
     */
    @Resource
    private WebLogService webLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public WebLog selectOne(String id) {
        return this.webLogService.queryById(id);
    }

    /**
     * 分页查询数据
     *
     * @param pageNum  起始
     * @param pageSize 条数
     * @return 多条数据
     */
    @PostMapping("/all")
    @ApiOperation("分页查询数据")
    public ResultUtil<PageInfo<WebLog>> selectAllByLimit(
            @ApiParam("页码") @RequestParam(required = false) Integer pageNum,
            @ApiParam("每页大小") @RequestParam(required = false) Integer pageSize,
            @RequestBody(required = false) WebLog log
    ) {
        pageNum = (pageNum == null || pageNum < 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize < 0) ? 10 : pageSize;
        Page page = PageHelper.startPage(pageNum,pageSize);
        List<WebLog> logs = this.webLogService.queryAllByCondition(log);
        PageInfo<WebLog> pageInfo = new PageInfo<>(page);
        if (pageInfo != null) {
            return ResultUtil.success(pageInfo, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }
}