package com.clt.service;

import com.clt.entity.IncreaseBook;
import com.clt.entity.Statistics;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (Statistics)表服务接口
 *
 * @author makejava
 * @since 2020-04-18 21:05:36
 */
public interface StatisticsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Statistics queryById(String id);

    Statistics queryYesterdayInfo();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Statistics> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param statistics 实例对象
     * @return 实例对象
     */
    Statistics insert(Statistics statistics);

    /**
     * 修改数据
     *
     * @param statistics 实例对象
     * @return 实例对象
     */
    Statistics update(Statistics statistics);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    List<Map<Object, Object>> bookBorrowingRatio();

    List<IncreaseBook> bookStorageByTime(String timeSlot, Date start, Date end);

    List<Map<Object, Object>> bookStorageByCategory();

    List<Map<Object, Object>> readerNumbersByTime(String timeSlot);

    List<Statistics> queryAllByCondition(Statistics condition);
}