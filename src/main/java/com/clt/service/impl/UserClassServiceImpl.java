package com.clt.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.clt.entity.UserClass;
import com.clt.dao.UserClassDao;
import com.clt.service.UserClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
        final UserClass queryClassResult = queryById(userClass.getClassId());
        if (queryClassResult != null){
            return null;
        }
        if (userClass.getClassId() != null){
            final JSONArray classInfoArray = JSON.parseArray(userClass.getClassId());
            if (classInfoArray != null && classInfoArray.size() == 4){
                userClass.setGradeNo(classInfoArray.get(0).toString());
                userClass.setDepartNo(classInfoArray.get(1).toString());
                userClass.setMajorNo(classInfoArray.get(2).toString());
                userClass.setClassNumberNo(classInfoArray.get(3).toString());
                Date now = new Date();
                userClass.setCreateTime(now);
                userClass.setUpdateTime(now);
            }
        } else {
            return null;
        }
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