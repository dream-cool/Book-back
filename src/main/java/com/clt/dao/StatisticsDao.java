package com.clt.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * (Statistics)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-05 09:36:12
 */
@Mapper
public interface StatisticsDao {


    List<Map<Object,Object>> bookBorrowingRatio(Map<String, Object> map);

    List<Map<Object,Object>> bookStorageByTime(Map<String, Object> map);

    List<Map<Object,Object>> bookStorageByCategory(Map<String, Object> map);

    List<Map<Object,Object>> readerNumbersByTime(Map<String, Object> map);
}