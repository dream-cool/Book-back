package com.clt.controller;

import com.clt.entity.Borrowing;
import com.clt.service.BorrowingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Borrowing)表控制层
 *
 * @author makejava
 * @since 2020-02-25 19:03:35
 */
@RestController
@RequestMapping("borrowing")
public class BorrowingController {
    /**
     * 服务对象
     */
    @Resource
    private BorrowingService borrowingService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Borrowing selectOne(String id) {
        return this.borrowingService.queryById(id);
    }

}