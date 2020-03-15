package com.clt.service.impl;

import com.clt.dao.CommentDao;
import com.clt.entity.Comment;
import com.clt.entity.CommentLike;
import com.clt.dao.CommentLikeDao;
import com.clt.service.CommentLikeService;
import com.clt.utils.ResultUtil;
import com.clt.utils.UUIDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CommentLike)表服务实现类
 *
 * @author makejava
 * @since 2020-03-15 20:11:44
 */
@Service("commentLikeService")
public class CommentLikeServiceImpl implements CommentLikeService {
    @Resource
    private CommentLikeDao commentLikeDao;

    @Resource
    private CommentDao commentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param commentLikeId 主键
     * @return 实例对象
     */
    @Override
    public CommentLike queryById(String commentLikeId) {
        return this.commentLikeDao.queryById(commentLikeId);
    }

    @Override
    public CommentLike queryByUserIdAndCommentId(String userId, String commentId) {
        CommentLike entiy = new CommentLike();
        entiy.setCommentId(commentId);
        entiy.setUserId(userId);
        final List<CommentLike> commentLikes = commentLikeDao.queryAllByCondition(entiy);
        if (commentLikes != null && !commentLikes.isEmpty()){
            return commentLikes.get(0);
        }
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CommentLike> queryAllByLimit(int offset, int limit) {
        return this.commentLikeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param commentLike 实例对象
     * @return 实例对象
     */
    @Override
    public CommentLike insert(CommentLike commentLike) {
        this.commentLikeDao.insert(commentLike);
        return commentLike;
    }

    /**
     * 修改数据
     *
     * @param commentLike 实例对象
     * @return 实例对象
     */
    @Override
    public ResultUtil<Integer> update(CommentLike commentLike) {
        final Comment commentResult = commentDao.queryById(commentLike.getCommentId());
        if (commentLike.getIsLike()){
            commentResult.increaseZanNumber();
        } else {
            commentResult.decreaseZanNumber();
        }
        commentDao.update(commentResult);
        final CommentLike commentLikeResult = queryByUserIdAndCommentId(commentLike.getUserId(), commentLike.getCommentId());
        if (commentLikeResult == null) {
            commentLike.setCommentLikeId(UUIDUtil.getUUID());
            commentLike.setIsLike(true);
            insert(commentLike);
            return ResultUtil.success(null,"操作成功");
        }
        commentLikeResult.setIsLike(commentLike.getIsLike());
        final int updateResult = this.commentLikeDao.update(commentLikeResult);
        if (updateResult == 1) {
            return ResultUtil.success(updateResult, "操作成功");
        } else {
            return ResultUtil.failed("操作失败");
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param commentLikeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String commentLikeId) {
        return this.commentLikeDao.deleteById(commentLikeId) > 0;
    }

}