package com.clt.service;

import com.clt.entity.CommentLike;
import com.clt.utils.ResultUtil;

import java.util.List;

/**
 * (CommentLike)表服务接口
 *
 * @author makejava
 * @since 2020-03-15 20:11:44
 */
public interface CommentLikeService {

    /**
     * 通过ID查询单条数据
     *
     * @param commentLikeId 主键
     * @return 实例对象
     */
    CommentLike queryById(String commentLikeId);

    /**
     * 通过用户id和评论id查询单条数据
     *
     * @param userId 用户id
     * @param commentId 评论id
     * @return 实例对象
     */
    CommentLike queryByUserIdAndCommentId(String userId, String commentId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CommentLike> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param commentLike 实例对象
     * @return 实例对象
     */
    CommentLike insert(CommentLike commentLike);

    /**
     * 修改数据
     *
     * @param commentLike 实例对象
     * @return 实例对象
     */
    ResultUtil<Integer> update(CommentLike commentLike);

    /**
     * 通过主键删除数据
     *
     * @param commentLikeId 主键
     * @return 是否成功
     */
    boolean deleteById(String commentLikeId);

}