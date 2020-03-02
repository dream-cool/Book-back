package com.clt.controller;

import com.clt.entity.Record;
import com.clt.service.RecordService;
import com.clt.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Record)表控制层
 *
 * @author makejava
 * @since 2020-02-26 09:36:22
 */
@RestController
@RequestMapping("record")
public class RecordController {

    private static final Logger logger = LoggerFactory.getLogger(RecordController.class);
    /**
     * 服务对象
     */
    @Resource
    private RecordService recordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过主键查询单条数据")
    public ResultUtil<Record> selectOne(
            @ApiParam("id")
            @PathVariable String id) {
        Record Record = this.recordService.queryById(id);
        if (Record != null) {
            return ResultUtil.success(Record);
        } else {
            return ResultUtil.failed("没有找到对应信息");
        }
    }

    /**
     * 分页查询数据
     *
     * @param pageNum  起始
     * @param pageSize 条数
     * @return 多条数据
     */
    @GetMapping("")
    @ApiOperation("分页查询数据")
    public ResultUtil<PageInfo<Record>> selectAllByLimit(
            @ApiParam("页码") @RequestParam(required = false) Integer pageNum,
            @ApiParam("每页大小") @RequestParam(required = false) Integer pageSize,
            Record record
    ) {
        pageNum = (pageNum == null || pageNum < 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize < 0) ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Record> records = this.recordService.queryAllByCondition(record);
        PageInfo<Record> pageInfo = new PageInfo<>(records);
        if (records != null) {
            return ResultUtil.success(pageInfo, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    /**
     * 通过实体数据新增单条数据
     *
     * @param record 记录实体
     * @return 新增的数据
     */
    @PostMapping("")
    @ApiOperation("新增单条数据")
    public ResultUtil<Record> insert(@RequestBody Record record) {
        Record insertRecord = this.recordService.insert(record);
        if (insertRecord != null) {
            return ResultUtil.success(insertRecord, "新增成功");
        } else {
            return ResultUtil.failed("新增失败");
        }
    }

    /**
     * 通过实体数据更新单条数据
     *
     * @param record 记录实体
     * @return 更新的数据
     */
    @PutMapping("")
    @ApiOperation("更新单条数据")
    public ResultUtil<Record> update(@RequestBody Record record) {
        if (this.recordService.queryById(record.getRecordId()) == null) {
            return ResultUtil.failed("修改失败，没有找到对应信息");
        }
        Record updateRecord = this.recordService.update(record);
        if (updateRecord != null) {
            return ResultUtil.success(updateRecord, "修改成功");
        } else {
            return ResultUtil.failed("修改失败");
        }
    }

    /**
     * 通过主键删除单条数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    @ApiOperation("删除单条数据")
    public ResultUtil<Boolean> delete(@PathVariable String id) {
        if (this.recordService.queryById(id) == null) {
            return ResultUtil.failed("删除失败，没有找到对应信息");
        }
        boolean flag = this.recordService.deleteById(id);
        if (flag) {
            return ResultUtil.success(true, "删除成功");
        } else {
            return ResultUtil.failed("删除失败");
        }
    }
}