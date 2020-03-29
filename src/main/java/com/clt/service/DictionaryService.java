package com.clt.service;

import com.clt.utils.ResultUtil;

import java.util.List;
import java.util.Map;

/**
 * @author ：clt
 * @Date ：Created in 17:11 2020/03/29
 */
public interface DictionaryService {

    ResultUtil<Map<Object, Object>> insert(String field, String key, String value);

    ResultUtil<Map<Object, Object>> delete(String field, String key);

    ResultUtil<Map<Object, Object>> update(String field, String key, String value);

    ResultUtil<Map<Object, Object>> query(String field, String key);

    ResultUtil<List<Map<Object, Object>>> multipleQuery(List<String> fields);
}
