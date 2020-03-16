package com.clt.service;

import com.clt.entity.CollectionGroup;
import java.util.List;

/**
 * (CollectionGroup)表服务接口
 *
 * @author makejava
 * @since 2020-03-16 20:36:51
 */
public interface CollectionGroupService {

    /**
     * 通过ID查询单条数据
     *
     * @param collectionGroupId 主键
     * @return 实例对象
     */
    CollectionGroup queryById(String collectionGroupId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CollectionGroup> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param collectionGroup 实例对象
     * @return 实例对象
     */
    CollectionGroup insert(CollectionGroup collectionGroup);

    /**
     * 修改数据
     *
     * @param collectionGroup 实例对象
     * @return 实例对象
     */
    CollectionGroup update(CollectionGroup collectionGroup);

    /**
     * 通过主键删除数据
     *
     * @param collectionGroupId 主键
     * @return 是否成功
     */
    boolean deleteById(String collectionGroupId);

    List<CollectionGroup> queryByUserId(String userId);

    List<CollectionGroup> queryByName(String name);
}