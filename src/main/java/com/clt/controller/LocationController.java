package com.clt.controller;

import com.clt.entity.Location;
import com.clt.service.LocationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Location)表控制层
 *
 * @author makejava
 * @since 2020-04-11 11:23:29
 */
@RestController
@RequestMapping("location")
public class LocationController {
    /**
     * 服务对象
     */
    @Resource
    private LocationService locationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Location selectOne(String id) {
        return this.locationService.queryById(id);
    }

}