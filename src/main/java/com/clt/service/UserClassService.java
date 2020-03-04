package com.clt.service;

import com.clt.entity.UserClass;
import java.util.List;

/**
 * (UserClass)表服务接口
 *
 * @author makejava
 * @since 2020-03-04 15:18:26
 */
public interface UserClassService {

    /**
     * 通过ID查询单条数据
     *
     * @param classId 主键
     * @return 实例对象
     */
    UserClass queryById(String classId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserClass> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userClass 实例对象
     * @return 实例对象
     */
    UserClass insert(UserClass userClass);

    /**
     * 修改数据
     *
     * @param userClass 实例对象
     * @return 实例对象
     */
    UserClass update(UserClass userClass);

    /**
     * 通过主键删除数据
     *
     * @param classId 主键
     * @return 是否成功
     */
    boolean deleteById(String classId);

}