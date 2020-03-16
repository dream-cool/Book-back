package com.clt.service.impl;

import com.clt.dao.CommentDao;
import com.clt.dao.CommentLikeDao;
import com.clt.dao.UserDao;
import com.clt.entity.Comment;
import com.clt.entity.CommentLike;
import com.clt.entity.User;
import com.clt.service.CommentLikeService;
import com.clt.service.CommentService;
import com.clt.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2020-02-26 09:34:56
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;

    @Resource
    private UserDao userDao;

    @Resource
    private CommentLikeDao commentLikeDao;

    @Resource
    private CommentLikeService commentLikeService;

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Override
    public Comment queryById(String commentId) {
        return this.commentDao.queryById(commentId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Comment> queryAllByLimit(int offset, int limit) {
        return this.commentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment insert(Comment comment) {
        comment.setCommentId(UUIDUtil.getUUID());
        if (!StringUtils.isBlank(comment.getReplyId())) {
            comment.setReplyFlag(1);
        }
        comment.setCommentTime(new Date());
        comment.setZanNumber(0);
        this.commentDao.insert(comment);
        return comment;
    }

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment update(Comment comment) {
        this.commentDao.update(comment);
        return this.queryById(comment.getCommentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String commentId) {
        commentLikeDao.deleteByCommentId(commentId);
        return this.commentDao.deleteById(commentId) > 0;
    }

    @Override
    public List<Comment> queryAll() {
        return this.commentDao.queryAll();
    }

    @Override
    public List<Comment> queryAllByCondition(Comment comment,String userId) {
        List<Comment> comments = this.commentDao.queryAllByCondition(comment);
        comments = comments.stream().map(commentResult -> {
            final User commentUser = userDao.queryById(commentResult.getUserId());
            if (userId != null) {
                CommentLike commentLike = commentLikeService.queryByUserIdAndCommentId(userId, commentResult.getCommentId());
                if (commentLike != null){
                    commentResult.setIsLike(commentLike.getIsLike());
                }
            }
            commentResult.setUser(commentUser);
            return commentResult;
        }).collect(Collectors.toList());
        return comments;
    }
}