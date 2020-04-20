package com.clt.dao;

import com.clt.entity.UserCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (UserCollection)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-15 15:52:39
 */
@Mapper
public interface UserCollectionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param collectionId 主键
     * @return 实例对象
     */
    UserCollection queryById(String collectionId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserCollection> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userCollection 实例对象
     * @return 对象列表
     */
    List<UserCollection> queryAllByCondition(UserCollection userCollection);

    /**
     * 新增数据
     *
     * @param userCollection 实例对象
     * @return 影响行数
     */
    int insert(UserCollection userCollection);

    /**
     * 修改数据
     *
     * @param userCollection 实例对象
     * @return 影响行数
     */
    int update(UserCollection userCollection);

    /**
     * 通过主键删除数据
     *
     * @param collectionId 主键
     * @return 影响行数
     */
    int deleteById(String collectionId);

    int deleteByUserCollectionGroup(@Param("userId")String userId, @Param("groupName")String groupName);
}