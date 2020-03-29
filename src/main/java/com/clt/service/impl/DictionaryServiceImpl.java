package com.clt.service.impl;

import com.clt.service.DictionaryService;
import com.clt.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：clt
 * @Date ：Created in 17:11 2020/03/29
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

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
