package com.clt.controller;

import com.clt.entity.CommentLike;
import com.clt.service.CommentLikeService;
import com.clt.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CommentLike)表控制层
 *
 * @author makejava
 * @since 2020-03-15 20:11:45
 */
@RestController
@RequestMapping("commentLike")
public class CommentLikeController {
    /**
     * 服务对象
     */
    @Resource
    private CommentLikeService commentLikeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CommentLike selectOne(String id) {
        return this.commentLikeService.queryById(id);
    }

    /**
     * 通过实体数据更新单条数据
     *
     * @param commentLike 评论实体
     * @return 更新的结果
     */
    @PutMapping("")
    @ApiOperation("通过实体数据更新单条数据")
    public ResultUtil<Integer> update(@RequestBody CommentLike commentLike) {
        return commentLikeService.update(commentLike);
    }
}