package com.clt.service.impl;

import com.clt.entity.UserClass;
import com.clt.dao.UserClassDao;
import com.clt.service.UserClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserClass)表服务实现类
 *
 * @author makejava
 * @since 2020-03-04 15:18:26
 */
@Service("userClassService")
public class UserClassServiceImpl implements UserClassService {
    @Resource
    private UserClassDao userClassDao;

    /**
     * 通过ID查询单条数据
     *
     * @param classId 主键
     * @return 实例对象
     */
    @Override
    public UserClass queryById(String classId) {
        return this.userClassDao.queryById(classId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserClass> queryAllByLimit(int offset, int limit) {
        return this.userClassDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userClass 实例对象
     * @return 实例对象
     */
    @Override
    public UserClass insert(UserClass userClass) {
        this.userClassDao.insert(userClass);
        return userClass;
    }

    /**
     * 修改数据
     *
     * @param userClass 实例对象
     * @return 实例对象
     */
    @Override
    public UserClass update(UserClass userClass) {
        this.userClassDao.update(userClass);
        return this.queryById(userClass.getClassId());
    }

    /**
     * 通过主键删除数据
     *
     * @param classId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String classId) {
        return this.userClassDao.deleteById(classId) > 0;
    }
}