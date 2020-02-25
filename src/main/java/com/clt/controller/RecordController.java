package com.clt.controller;

import com.clt.entity.Record;
import com.clt.service.RecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Record)表控制层
 *
 * @author makejava
 * @since 2020-02-25 19:05:06
 */
@RestController
@RequestMapping("record")
public class RecordController {
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
    @GetMapping("selectOne")
    public Record selectOne(String id) {
        return this.recordService.queryById(id);
    }

}