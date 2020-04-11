package com.clt.dao;

import com.clt.entity.Dictionary;
import com.clt.entity.DictionaryData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DictionaryData)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-30 19:07:22
 */
@Mapper
public interface DictionaryDataDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictionaryData queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DictionaryData> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dictionaryData 实例对象
     * @return 对象列表
     */
    List<DictionaryData> queryAllByCondition(DictionaryData dictionaryData);

    /**
     * 新增数据
     *
     * @param dictionaryData 实例对象
     * @return 影响行数
     */
    int insert(DictionaryData dictionaryData);

    /**
     * 修改数据
     *
     * @param dictionaryData 实例对象
     * @return 影响行数
     */
    int update(DictionaryData dictionaryData);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 查询所有的专业数据
     *
     * @return 专业列表数据
     */
    List<DictionaryData> queryMajorList();
}