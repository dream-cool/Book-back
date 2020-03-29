package com.clt.service;

import com.clt.entity.UserCollection;
import com.clt.utils.ResultUtil;

import java.util.List;
import java.util.Map;

/**
 * (UserCollection)表服务接口
 *
 * @author makejava
 * @since 2020-03-15 15:52:39
 */
public interface UserCollectionService {

    /**
     * 通过ID查询单条数据
     *
     * @param collectionId 主键
     * @return 实例对象
     */
    UserCollection queryById(String collectionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserCollection> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userCollection 实例对象
     * @return 实例对象
     */
    UserCollection insert(UserCollection userCollection);

    /**
     * 修改数据
     *
     * @param userCollection 实例对象
     * @return 实例对象
     */
    ResultUtil<UserCollection> update(UserCollection userCollection);

    /**
     * 通过主键删除数据
     *
     * @param collectionId 主键
     * @return 是否成功
     */
    boolean deleteById(String collectionId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param userCollection 实例对象
     * @return 对象列表
     */
    List<UserCollection> queryAllByCondition(UserCollection userCollection);


    /**
     * 将查询结果按照时间分类
     *
     * @param userCollection 实例对象
     * @return 对象列表
     */
    Map<String, List<UserCollection>> queryAllGroupCollectTime(UserCollection userCollection);

    /**
     * 查询对应用户对应书籍的对象列表
     *
     * @param userId 用户id
     * @param bookId 书籍id
     * @return 对象列表
     */
    UserCollection queryAllByUserIdAndBookId(String userId, String bookId);

}