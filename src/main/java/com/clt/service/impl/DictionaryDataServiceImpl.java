package com.clt.service.impl;

import com.clt.entity.DictionaryData;
import com.clt.dao.DictionaryDataDao;
import com.clt.service.DictionaryDataService;
import com.clt.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (DictionaryData)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 19:07:22
 */
@Service("dictionaryDataService")
public class DictionaryDataServiceImpl implements DictionaryDataService {
    @Resource
    private DictionaryDataDao dictionaryDataDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DictionaryData queryById(String id) {
        return this.dictionaryDataDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DictionaryData> queryAllByLimit(int offset, int limit) {
        return this.dictionaryDataDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<DictionaryData> queryAllByCondition(DictionaryData dictionaryData) {
        return this.dictionaryDataDao.queryAllByCondition(dictionaryData);
    }

    /**
     * 新增数据
     *
     * @param dictionaryData 实例对象
     * @return 实例对象
     */
    @Override
    public DictionaryData insert(DictionaryData dictionaryData) {
        this.dictionaryDataDao.insert(dictionaryData);
        return dictionaryData;
    }

    /**
     * 修改数据
     *
     * @param dictionaryData 实例对象
     * @return 实例对象
     */
    @Override
    public DictionaryData update(DictionaryData dictionaryData) {
        this.dictionaryDataDao.update(dictionaryData);
        return this.queryById(dictionaryData.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.dictionaryDataDao.deleteById(id) > 0;
    }

    @Autowired
    private StringRedisTemplate template;

    @Override
    public ResultUtil<Map<Object, Object>> insert(String field, String key, String value) {
        if (field == null) {
            final String valueResult = template.opsForValue().get(key);
            if (valueResult != null && valueResult.trim().length() != 0) {
                ResultUtil.failed("新增失败，编号重复。");
            } else {
                template.opsForValue().set(key, value);
            }
        } else {
            final String valueResult = (String) template.opsForHash().get(field, key);
            if (valueResult != null && valueResult.trim().length() != 0) {
                ResultUtil.failed("新增失败，编号重复。");
            } else {
                template.opsForHash().put(field, key, value);
            }
        }
        return ResultUtil.success(null, "新增成功");
    }

    @Override
    public ResultUtil<Map<Object, Object>> delete(String field, String key) {
        if (field != null && key != null) {
            template.opsForHash().delete(field, key);
        }
        if (field == null) {
            template.delete(key);
        } else {
            template.delete(field);
        }
        return ResultUtil.success(null, "删除成功");
    }

    @Override
    public ResultUtil<Map<Object, Object>> update(String field, String key, String value) {
        if (field == null) {
            template.opsForValue().set(key, value);
        } else {
            template.opsForHash().put(field, key, value);
        }
        return ResultUtil.success(null, "更新成功");
    }

    @Override
    public ResultUtil<Map<Object, Object>> query(String field, String key) {
        Map<Object, Object> result = new HashMap<>();
        if (field != null && key != null) {
            result.put("result", template.opsForHash().get(field, key));
        }
        if (field == null) {
            result.put("result", template.opsForValue().get(key));
        } else {
            return ResultUtil.success(template.opsForHash().entries(field), "查询成功");
        }
        return ResultUtil.success(result, "查询成功");
    }

    @Override
    public ResultUtil< List<Map<Object, Object>>> multipleQuery(List<String> fields) {
        List<Map<Object, Object>> result = new ArrayList<>();
        fields.stream().forEach( field -> {
            result.add(template.opsForHash().entries(field));
        });
        return  ResultUtil.success(result, "查询成功");
    }
}