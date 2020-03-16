package com.clt.dao;

import com.clt.entity.CommentLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (CommentLike)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-15 20:11:43
 */
@Mapper
public interface CommentLikeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param commentLikeId 主键
     * @return 实例对象
     */
    CommentLike queryById(String commentLikeId);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CommentLike> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param commentLike 实例对象
     * @return 对象列表
     */
    List<CommentLike> queryAllByCondition(CommentLike commentLike);

    /**
     * 新增数据
     *
     * @param commentLike 实例对象
     * @return 影响行数
     */
    int insert(CommentLike commentLike);

    /**
     * 修改数据
     *
     * @param commentLike 实例对象
     * @return 影响行数
     */
    int update(CommentLike commentLike);

    /**
     * 通过主键删除数据
     *
     * @param commentLikeId 主键
     * @return 影响行数
     */
    int deleteById(String commentLikeId);

    /**
     * 删除某条评论的所有点赞数据
     *
     * @param commentId 主键
     * @return 影响行数
     */
    int deleteByCommentId(String commentId);


}