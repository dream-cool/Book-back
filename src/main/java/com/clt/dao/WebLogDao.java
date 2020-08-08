package com.clt.dao;

import com.clt.entity.WebLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (WebLog)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-16 20:45:50
 */
@Mapper
public interface WebLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WebLog queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WebLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param webLog 实例对象
     * @return 对象列表
     */
    List<WebLog> queryAllByCondition(WebLog webLog);

    /**
     * 新增数据
     *
     * @param webLog 实例对象
     * @return 影响行数
     */
    int insert(WebLog webLog);


    /**
     * 新增数据
     *
     * @param logList 实例对象列表
     * @return 影响行数
     */
    int insertBatch(List<WebLog> logList);

    /**
     * 修改数据
     *
     * @param webLog 实例对象
     * @return 影响行数
     */
    int update(WebLog webLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}
