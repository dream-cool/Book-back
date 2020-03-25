package com.clt.service.impl;

import com.clt.dao.BookDao;
import com.clt.dao.UserCollectionDao;
import com.clt.entity.Book;
import com.clt.entity.UserCollection;
import com.clt.service.UserCollectionService;
import com.clt.utils.DateUtils;
import com.clt.utils.ResultUtil;
import com.clt.utils.UUIDUtil;
import com.google.common.collect.Lists;
import org.apache.commons.collections.ListUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.*;

/**
 * (UserCollection)表服务实现类
 *
 * @author makejava
 * @since 2020-03-15 15:52:39
 */
@Service("userCollectionService")
public class UserCollectionServiceImpl implements UserCollectionService {
    @Resource
    private UserCollectionDao userCollectionDao;

    @Resource
    private BookDao bookDao;

    /**
     * 通过ID查询单条数据
     *
     * @param collectionId 主键
     * @return 实例对象
     */
    @Override
    public UserCollection queryById(String collectionId) {
        return this.userCollectionDao.queryById(collectionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserCollection> queryAllByLimit(int offset, int limit) {
        return this.userCollectionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userCollection 实例对象
     * @return 实例对象
     */
    @Override
    public UserCollection insert(UserCollection userCollection) {
        this.userCollectionDao.insert(userCollection);
        return userCollection;
    }

    /**
     * 修改数据
     *
     * @param userCollection 实例对象
     * @return 实例对象
     */
    @Override
    public ResultUtil<UserCollection> update(UserCollection userCollection) {
        final UserCollection userCollectionResult = queryById(userCollection.getCollectionId());
        if (userCollectionResult == null) {
            return ResultUtil.failed("操作失败，没有找到对应信息");
        }
        /**
         *  添加收藏
         */
        if (!userCollectionResult.getIsCollect() && userCollection.getIsCollect()){
            userCollection.setCollectionTime(new Date());
        }
        if (!userCollectionResult.getIsLike().equals(userCollection.getIsLike())){
            final Book bookResult = this.bookDao.queryById(userCollection.getBookId());
            if (userCollection.getIsLike()){
                bookResult.increaseZanNumber();
            } else {
                bookResult.decreaseZanNumber();
            }
            bookDao.update(bookResult);
        }
        this.userCollectionDao.update(userCollection);
        final UserCollection updateResult = this.queryById(userCollection.getCollectionId());
        if (updateResult != null) {
            return ResultUtil.success(updateResult, "修改成功");
        } else {
            return ResultUtil.failed("操作失败");
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param collectionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String collectionId) {
        return this.userCollectionDao.deleteById(collectionId) > 0;
    }

    @Override
    public List<UserCollection> queryAllByCondition(UserCollection userCollection) {
        return this.userCollectionDao.queryAllByCondition(userCollection);
    }

    @Override
    public Map<String,List<UserCollection>> queryAllGroupCollectTime(UserCollection userCollection) {
        final List<UserCollection> userCollections = queryAllByCondition(userCollection);
        Map<String, List<UserCollection>> data = new LinkedHashMap<>(16);
        userCollections.stream().forEach(userCollectionResult -> {
            String key = DateUtils.standardTimeToStringTime(userCollectionResult.getCollectionTime());
            final List<UserCollection> userCollectionsResultByDay = data.get(key);
            if (userCollectionsResultByDay == null || userCollectionsResultByDay.isEmpty()){
                List<UserCollection> userCollectionsByDay = new ArrayList<>();
                userCollectionsByDay.add(userCollectionResult);
                data.put(key, userCollectionsByDay);
            } else {
                userCollectionsResultByDay.add(userCollectionResult);
            }
        });
        return data;
    }

    @Override
    public UserCollection queryAllByUserIdAndBookId(String userId, String bookId) {
        UserCollection userCollection = new UserCollection();
        userCollection.setUserId(userId);
        userCollection.setBookId(bookId);
        final List<UserCollection> userCollections = queryAllByCondition(userCollection);
        if (userCollections == null || userCollections.isEmpty()) {
            final Book bookResult = bookDao.queryById(userCollection.getBookId());
            userCollection.setCollectionId(UUIDUtil.getUUID());
            userCollection.setBookImg(bookResult.getImg());
            userCollection.setBookName(bookResult.getBookName());
            userCollection.setDescr(bookResult.getBookDescribe());
            userCollection.setIsLike(false);
            userCollection.setIsCollect(false);
            final UserCollection insertUserCollection = insert(userCollection);
            return insertUserCollection;
        }
        return userCollections.get(0);
    }
}