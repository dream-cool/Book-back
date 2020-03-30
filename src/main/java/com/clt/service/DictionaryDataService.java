package com.clt.service;

import com.clt.entity.DictionaryData;
import com.clt.utils.ResultUtil;

import java.util.List;
import java.util.Map;

/**
 * (DictionaryData)表服务接口
 *
 * @author makejava
 * @since 2020-03-30 19:07:22
 */
public interface DictionaryDataService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictionaryData queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DictionaryData> queryAllByLimit(int offset, int limit);

    List<DictionaryData> queryAllByCondition(DictionaryData dictionaryData);

    /**
     * 新增数据
     *
     * @param dictionaryData 实例对象
     * @return 实例对象
     */
    DictionaryData insert(DictionaryData dictionaryData);

    /**
     * 修改数据
     *
     * @param dictionaryData 实例对象
     * @return 实例对象
     */
    DictionaryData update(DictionaryData dictionaryData);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    ResultUtil<Map<Object, Object>> insert(String field, String key, String value);

    ResultUtil<Map<Object, Object>> delete(String field, String key);

    ResultUtil<Map<Object, Object>> update(String field, String key, String value);

    ResultUtil<Map<Object, Object>> query(String field, String key);

    ResultUtil<List<Map<Object, Object>>> multipleQuery(List<String> fields);

}