package com.clt.controller;

import com.clt.entity.Comment;
import com.clt.service.CommentService;
import com.clt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comment)表控制层
 *
 * @author makejava
 * @since 2020-02-26 09:34:57
 */
@RestController
@RequestMapping("comment")
@Api("评论实体接口")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过主键查询单条数据")
    public ResultUtil<Comment> selectOne(
            @ApiParam("id")
            @PathVariable String id) {
        Comment comment = this.commentService.queryById(id);
        if (comment != null) {
            return ResultUtil.success(comment);
        } else {
            return ResultUtil.failed("没有找到对应信息");
        }
    }

    /**
     * 分页查询数据
     *
     * @param offset 起始
     * @param limit  条数
     * @return 多条数据
     */
    @GetMapping("")
    @ApiOperation("分页查询数据")
    public ResultUtil<List<Comment>> selectAllByLimit(
            @ApiParam("起始") Integer offset,
            @ApiParam("条数") Integer limit
    ) {
        offset = (offset == null || offset < 0) ? 0 : offset;
        limit = (limit == null || limit < 0) ? 10 : limit;
        List<Comment> comments = this.commentService.queryAllByLimit(offset, limit);
        if (comments != null) {
            return ResultUtil.success(comments, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    /**
     * 通过实体数据新增单条数据
     *
     * @param comment 评论实体
     * @return 新增的数据
     */
    @PostMapping("")
    @ApiOperation("通过实体数据新增单条数据")
    public ResultUtil<Comment> insert(@RequestBody Comment comment) {
        Comment insertComment = this.commentService.insert(comment);
        if (insertComment != null) {
            return ResultUtil.success(insertComment, "新增成功");
        } else {
            return ResultUtil.failed("新增失败");
        }
    }

    /**
     * 通过实体数据更新单条数据
     *
     * @param comment 评论实体
     * @return 更新的数据
     */
    @PutMapping("")
    @ApiOperation("通过实体数据更新单条数据")
    public ResultUtil<Comment> update(@RequestBody Comment comment) {
        if (this.commentService.queryById(comment.getCommentId()) == null){
            return ResultUtil.failed("修改失败，没有找到对应信息");
        }
        Comment updateComment = this.commentService.update(comment);
        if (updateComment != null) {
            return ResultUtil.success(updateComment, "修改成功");
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
    @ApiOperation("通过主键删除单条数据")
    public ResultUtil<Boolean> delete(@PathVariable String id) {
        if (this.commentService.queryById(id) == null){
            return ResultUtil.failed("删除失败，没有找到对应信息");
        }
        boolean flag = this.commentService.deleteById(id);
        if (flag) {
            return ResultUtil.success(true, "删除成功");
        } else {
            return ResultUtil.failed("删除失败");
        }
    }


}