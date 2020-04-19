package com.clt.dao;

import com.clt.entity.Statistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (Statistics)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-18 21:05:36
 */
@Mapper
public interface StatisticsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Statistics queryById(String id);

    Statistics queryYesterdayInfo();
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Statistics> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param condition 实例对象
     * @return 对象列表
     */
    List<Statistics> queryAllByCondition(Statistics condition);

    /**
     * 新增数据
     *
     * @param statistics 实例对象
     * @return 影响行数
     */
    int insert(Statistics statistics);

    /**
     * 修改数据
     *
     * @param statistics 实例对象
     * @return 影响行数
     */
    int update(Statistics statistics);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    List<Map<Object,Object>> bookBorrowingRatio(Map<String, Object> map);

    List<Map<Object,Object>> bookStorageByTime(Map<String, Object> map);

    List<Map<Object,Object>> bookStorageByCategory(Map<String, Object> map);

    List<Map<Object,Object>> readerNumbersByTime(Map<String, Object> map);



}