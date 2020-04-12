package com.clt.dao;

import com.clt.entity.SchedulingTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SchedulingTask)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-12 19:21:14
 */
@Mapper
public interface SchedulingTaskDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SchedulingTask queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SchedulingTask> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param schedulingTask 实例对象
     * @return 对象列表
     */
    List<SchedulingTask> queryAll(SchedulingTask schedulingTask);

    /**
     * 新增数据
     *
     * @param schedulingTask 实例对象
     * @return 影响行数
     */
    int insert(SchedulingTask schedulingTask);

    /**
     * 修改数据
     *
     * @param schedulingTask 实例对象
     * @return 影响行数
     */
    int update(SchedulingTask schedulingTask);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}