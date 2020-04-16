package com.clt.service;

import com.clt.entity.WebLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (WebLog)表服务接口
 *
 * @author makejava
 * @since 2020-04-16 20:45:50
 */
public interface WebLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WebLog queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WebLog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param webLog 实例对象
     * @return 实例对象
     */
    WebLog insert(WebLog webLog);

    /**
     * 修改数据
     *
     * @param webLog 实例对象
     * @return 实例对象
     */
    WebLog update(WebLog webLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    List<WebLog> queryAllByCondition(WebLog log);
}