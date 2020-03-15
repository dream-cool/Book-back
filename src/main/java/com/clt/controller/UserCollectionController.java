package com.clt.controller;

import com.clt.entity.UserCollection;
import com.clt.service.UserCollectionService;
import com.clt.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (UserCollection)表控制层
 *
 * @author makejava
 * @since 2020-03-15 15:52:39
 */
@RestController
@RequestMapping("userCollection")
public class UserCollectionController {
    /**
     * 服务对象
     */
    @Resource
    private UserCollectionService userCollectionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserCollection selectOne(String id) {
        return this.userCollectionService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param userId 用户id
     * @param bookId 书籍id
     * @return 单条数据
     */
    @GetMapping("/{userId}/{bookId}")
    public ResultUtil<UserCollection>queryByUserIdAndBookId(
            @ApiParam("userId") @PathVariable String userId,
            @ApiParam("bookId") @PathVariable String bookId
            ) {
        final UserCollection userCollection = this.userCollectionService.queryAllByUserIdAndBookId(userId, bookId);
        return ResultUtil.success(userCollection, "");
    }

    /**
     * 通过实体数据更新单条数据
     *
     * @param userCollection 信息实体
     * @return 更新的数据
     */
    @PutMapping("")
    @ApiOperation("更新单条数据")
    public ResultUtil<UserCollection> update(@RequestBody UserCollection userCollection) {
        return this.userCollectionService.update(userCollection);
    }
}