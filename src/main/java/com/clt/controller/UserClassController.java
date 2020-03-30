package com.clt.controller;

import com.clt.entity.UserClass;
import com.clt.service.UserClassService;
import com.clt.utils.ResultUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (UserClass)表控制层
 *
 * @author makejava
 * @since 2020-03-04 15:18:26
 */
@RestController
@RequestMapping("userClass")
public class UserClassController {
    /**
     * 服务对象
     */
    @Resource
    private UserClassService userClassService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserClass selectOne(String id) {
        return this.userClassService.queryById(id);
    }


}