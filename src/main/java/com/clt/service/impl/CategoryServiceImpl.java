package com.clt.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.clt.dao.CategoryDao;
import com.clt.entity.Category;
import com.clt.factory.JsonFactory;
import com.clt.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Category)表服务实现类
 *
 * @author makejava
 * @since 2020-02-25 19:04:25
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryDao categoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    @Override
    public Category queryById(String categoryId) {
        return this.categoryDao.queryById(categoryId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Category> queryAllByLimit(int offset, int limit) {
        return this.categoryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    @Override
    public Category insert(Category category) {
        this.categoryDao.insert(category);
        return category;
    }

    /**
     * 修改数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    @Override
    public Category update(Category category) {
        this.categoryDao.update(category);
        return this.queryById(category.getCategoryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String categoryId) {
        return this.categoryDao.deleteById(categoryId) > 0;
    }


    @Override
    public JSONArray getCategoryList() {
        JSONArray json = new JSONArray();
        List<Category> categoryList = this.categoryDao.queryAllByLimit(0,100 );
        JSONObject allNode = JsonFactory.getTreeNode("true","全部", "全部", null, "0","0");
        json.add(allNode);
        for (Category category: categoryList) {
            int level = 1;
            while (level < 4){
                /**
                 * 遍历添加节点时需判断是否为父节点
                 * 如果不是父节点则可以直接添加，否则需要遍历父节点下的子节点
                 * 同时还需要针对父节点进行去重
                 */
                if (!category.isParent(level)){
                    JSONObject subNode = JsonFactory.getTreeNode("false",category.getCategoryNameByLevel(level),
                            category.getCategoryNameByLevel(level),
                            level == 1 ? "0" : category.getCategoryIdByLevel(level-1),
                            category.getCategoryIdByLevel(level),String.valueOf(level));
                    json.add(subNode);
                    break;
                } else {
                    //默认没重复
                    boolean isRepeat = false;
                    /**
                     *	判断当前需要添加的父节点是否已经重复
                     */
                    if(json.size()>0){
                        for(int i=0;i<json.size();i++){
                            JSONObject job = json.getJSONObject(i);
                            if (category.getCategoryIdByLevel(level).equals(job.get("id"))){
                                isRepeat = true;
                                break;
                            }
                        }
                    }
                    if (!isRepeat){
                        JSONObject supNode = JsonFactory.getTreeNode("true",category.getCategoryNameByLevel(level),
                                category.getCategoryNameByLevel(level),
                                level == 1 ? "0" : category.getCategoryIdByLevel(level-1),
                                category.getCategoryIdByLevel(level),String.valueOf(level));
                        json.add(supNode);
                    }
                }
                level++;
            }
        }
        return json;
    }

    @Override
    public Map<Object, Object> getTypeInfo() {
        List<Category> categoryList = this.categoryDao.queryAllByLimit(0,100 );
        Map<Object,Object> result = new HashMap<>(16);
        for (Category category: categoryList) {
            result.put(category.getCategoryIdByLevel(1),category.getFirstType());
            if (StringUtils.isNotEmpty(category.getSecondType())){
                result.put(category.getCategoryIdByLevel(2),category.getSecondType());
            }
            if (StringUtils.isNotEmpty(category.getThirdType())){
                result.put(category.getCategoryIdByLevel(3),category.getThirdType());
            }
        }
        return  result;
    }
}