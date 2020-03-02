package com.clt.service.impl;

import com.clt.entity.Permission;
import com.clt.dao.PermissionDao;
import com.clt.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Permission)表服务实现类
 *
 * @author makejava
 * @since 2020-02-26 09:39:15
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionDao permissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public Permission queryById(String userId) {
        return this.permissionDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Permission> queryAllByLimit(int offset, int limit) {
        return this.permissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public Permission insert(Permission permission) {
        this.permissionDao.insert(permission);
        return permission;
    }

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public Permission update(Permission permission) {
        this.permissionDao.update(permission);
        return this.queryById(permission.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String userId) {
        return this.permissionDao.deleteById(userId) > 0;
    }

    @Override
    public List<Permission> queryAllByCondition(Permission permission) {
        return this.permissionDao.queryAllByCondition(permission);
    }
}