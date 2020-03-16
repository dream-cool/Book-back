package com.clt.dao;

import com.clt.entity.CollectionGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (CollectionGroup)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-16 20:36:51
 */
@Mapper
public interface CollectionGroupDao {

    /**
     * 通过ID查询单条数据
     *
     * @param collectionGroupId 主键
     * @return 实例对象
     */
    CollectionGroup queryById(String collectionGroupId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CollectionGroup> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param collectionGroup 实例对象
     * @return 对象列表
     */
    List<CollectionGroup> queryAll(CollectionGroup collectionGroup);

    /**
     * 新增数据
     *
     * @param collectionGroup 实例对象
     * @return 影响行数
     */
    int insert(CollectionGroup collectionGroup);

    /**
     * 修改数据
     *
     * @param collectionGroup 实例对象
     * @return 影响行数
     */
    int update(CollectionGroup collectionGroup);

    /**
     * 通过主键删除数据
     *
     * @param collectionGroupId 主键
     * @return 影响行数
     */
    int deleteById(String collectionGroupId);

}