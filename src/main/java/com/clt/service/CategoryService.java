package com.clt.service;

import com.alibaba.fastjson.JSONArray;
import com.clt.entity.Category;

import java.util.List;
import java.util.Map;

/**
 * (Category)表服务接口
 *
 * @author makejava
 * @since 2020-02-25 19:04:25
 */
public interface CategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    Category queryById(String categoryId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Category> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    Category insert(Category category);

    /**
     * 修改数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    Category update(Category category);

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 是否成功
     */
    boolean deleteById(String categoryId);


    /**
     * 查询所有书籍类别列表信息
     */
    JSONArray getCategoryList();

    Map<Object, Object> getTypeInfo();
}