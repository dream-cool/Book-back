package com.clt.service.impl;

import com.clt.dao.BookDao;
import com.clt.dao.CommentDao;
import com.clt.dao.CommentLikeDao;
import com.clt.dao.UserDao;
import com.clt.entity.Book;
import com.clt.entity.Comment;
import com.clt.entity.CommentLike;
import com.clt.service.CommentLikeService;
import com.clt.service.CommentService;
import com.clt.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
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
    private BookDao bookDao;

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
            comment.setReplyFlag(true);
        } else {
            comment.setReplyFlag(false);
        }
        if (comment.getScore() != null) {
            final Book bookResult = bookDao.queryById(comment.getBookId());
            if (bookResult != null) {
                bookResult.calculateScore(comment.getScore());
            }
            bookDao.update(bookResult);
        }
        comment.setCommentTime(new Date());
        comment.setZanNumber(0);
        this.commentDao.insert(comment);
        return comment;
    }

    @Override
    public int insertBatch(List<Comment> commentList) {
        return commentDao.insertBatch(commentList);
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
        final Comment commentResult = queryById(commentId);
        if (commentResult != null) {
            /**
             *  根据评分判断是否是楼主评论
             */
            if (commentResult.getScore() != null) {
                final Book bookResult = bookDao.queryById(commentResult.getBookId());
                if (bookResult != null) {
                    /**
                     *  重新计算书籍评分
                     */
                    bookResult.setScore((bookResult.getScore() * 2) - commentResult.getScore());
                    bookDao.update(bookResult);
                }
                /**
                 *  删除楼层评论的子评论
                 */
                commentDao.deleteByCommentPid(commentResult.getCommentId());
            }
        }
        commentLikeDao.deleteByCommentId(commentId);
        return this.commentDao.deleteById(commentId) > 0;
    }

    @Override
    public List<Comment> queryAll() {
        return this.commentDao.queryAll();
    }

    @Override
    public List<Comment> queryAllByCondition(Comment comment, String userId) {
        comment.setReplyFlag(false);
        List<Comment> comments = this.commentDao.queryAllByCondition(comment);
        comments = setCommentIsLike(comments, userId);
        addChildrenComment(comments, userId);
        handleChildrenComment(comments);
        return comments;
    }

    private List<Comment> setCommentIsLike(List<Comment> comments, String userId) {
        return comments.stream().map(commentResult -> {
            if (userId != null) {
                CommentLike commentLike = commentLikeService.queryByUserIdAndCommentId(userId, commentResult.getCommentId());
                if (commentLike != null) {
                    commentResult.setIsLike(commentLike.getIsLike());
                }
            }
            return commentResult;
        }).collect(Collectors.toList());
    }

    /**
     * 再查评论下的子评论
     */
    private void addChildrenComment(List<Comment> comments, String userId) {
        List<Comment> allComments = commentDao.queryAllByCondition(null);
        for (Comment comment : comments) {
            allComments.stream().forEach(commentResult -> {
                if (comment.getCommentId().equals(commentResult.getCommentPid())) {
                    comment.getChildren().add(commentResult);
                }
            });
        }
    }

    /**
     * 处理评论顺序
     */
    private void handleChildrenComment(List<Comment> comments) {
        comments.stream().forEach(comment -> {
            final List<Comment> childrenComments = comment.getChildren();
            Collections.sort(childrenComments);
            Map<String, Integer> commentIdData = new LinkedHashMap<>(16);
            Map<String, Integer> replyIdData = new LinkedHashMap<>(16);
            int total = childrenComments.size();
            for (int i = 0; i < total; i++) {
                commentIdData.put(childrenComments.get(i).getCommentId(), i);
                if (childrenComments.get(i).getReplyUserName() != null) {
                    if (replyIdData.get(childrenComments.get(i).getReplyId()) != null) {
                        replyIdData.put(childrenComments.get(i).getReplyId(), i);
                    }
                }
            }
            for (Map.Entry<String, Integer> data : replyIdData.entrySet()) {
                final Integer index = commentIdData.get(data.getKey());
                if (index == null) {
                    return;
                }
                int insertIndex = index.intValue() + 1;
                childrenComments.add(insertIndex, childrenComments.get(data.getValue()));
                if (data.getValue() > index + 1) {
                    childrenComments.remove(data.getValue() + 1);
                } else {
                    childrenComments.remove((int) data.getValue());
                }
            }
        });
    }

}