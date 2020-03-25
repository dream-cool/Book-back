package com.clt.controller;

import com.clt.entity.Comment;
import com.clt.entity.UserCollection;
import com.clt.service.UserCollectionService;
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

    @PostMapping("/all")
    @ApiOperation("分页查询数据")
    public ResultUtil<PageInfo<Comment>> selectAllByPage(
            @ApiParam("页码") @RequestParam(required = false) Integer pageNum,
            @ApiParam("每页大小") @RequestParam(required = false) Integer pageSize,
            @RequestBody UserCollection userCollection
    ) {
        pageNum = (pageNum == null || pageNum < 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize < 0) ? 10 : pageSize;
        Page page = PageHelper.startPage(pageNum,pageSize);
        this.userCollectionService.queryAllByCondition(userCollection);
        PageInfo<Comment> pageInfo = new PageInfo<>(page);
        if (pageInfo != null) {
            return ResultUtil.success(pageInfo, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    @PostMapping("/queryAllGroupCollectTime")
    @ApiOperation("分页查询数据")
    public ResultUtil<Map<String, List<UserCollection>>> queryAllGroupCollectTime(
            @RequestBody UserCollection userCollection
    ) {
        return ResultUtil.success(this.userCollectionService.queryAllGroupCollectTime(userCollection), "success");
    }
}