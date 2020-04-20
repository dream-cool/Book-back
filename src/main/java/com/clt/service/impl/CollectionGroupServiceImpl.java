package com.clt.service.impl;

import com.clt.constant.Const;
import com.clt.entity.CollectionGroup;
import com.clt.dao.CollectionGroupDao;
import com.clt.entity.UserCollection;
import com.clt.service.CollectionGroupService;
import com.clt.service.UserCollectionService;
import com.clt.utils.UUIDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (CollectionGroup)表服务实现类
 *
 * @author makejava
 * @since 2020-03-16 20:36:51
 */
@Service("collectionGroupService")
public class CollectionGroupServiceImpl implements CollectionGroupService {
    @Resource
    private CollectionGroupDao collectionGroupDao;

    @Resource
    private UserCollectionService userCollectionService;

    /**
     * 通过ID查询单条数据
     *
     * @param collectionGroupId 主键
     * @return 实例对象
     */
    @Override
    public CollectionGroup queryById(String collectionGroupId) {
        return this.collectionGroupDao.queryById(collectionGroupId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CollectionGroup> queryAllByLimit(int offset, int limit) {
        return this.collectionGroupDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param collectionGroup 实例对象
     * @return 实例对象
     */
    @Override
    public CollectionGroup insert(CollectionGroup collectionGroup) {
        this.collectionGroupDao.insert(collectionGroup);
        return collectionGroup;
    }

    /**
     * 修改数据
     *
     * @param collectionGroup 实例对象
     * @return 实例对象
     */
    @Override
    public CollectionGroup update(CollectionGroup collectionGroup) {
        this.collectionGroupDao.update(collectionGroup);
        return this.queryById(collectionGroup.getCollectionGroupId());
    }

    /**
     * 通过主键删除数据
     *
     * @param collectionGroupId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String collectionGroupId) {
        final CollectionGroup collectionGroup = collectionGroupDao.queryById(collectionGroupId);
        userCollectionService.deleteByUserCollectionGroup(collectionGroup.getUserId(), collectionGroup.getName());
        return this.collectionGroupDao.deleteById(collectionGroupId) > 0;
    }

    @Override
    public List<CollectionGroup> queryByUserId(String userId) {
        CollectionGroup collectionGroup = new CollectionGroup();
        collectionGroup.setUserId(userId);
        final List<CollectionGroup> collectionGroups = collectionGroupDao.queryAll(collectionGroup);
        if (collectionGroups == null || collectionGroups.isEmpty()){
            CollectionGroup defaultCollectionGroup = new CollectionGroup();
            defaultCollectionGroup.setCollectionGroupId(UUIDUtil.getUUID());
            defaultCollectionGroup.setUserId(userId);
            defaultCollectionGroup.setCreateTime(new Date());
            defaultCollectionGroup.setName(Const.DEAFULT_COLLECTION);
            final CollectionGroup insertResult = insert(defaultCollectionGroup);
            final ArrayList<CollectionGroup> results = new ArrayList<>(1);
            results.add(insertResult);
            return results;
        } else {
            return collectionGroups;
        }
    }

    @Override
    public List<CollectionGroup> queryByName(String name) {
        CollectionGroup collectionGroup = new CollectionGroup();
        collectionGroup.setName(name);
        final List<CollectionGroup> collectionGroups = collectionGroupDao.queryAll(collectionGroup);
        return collectionGroups;
    }
}