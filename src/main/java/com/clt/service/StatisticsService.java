package com.clt.service;

import com.clt.entity.IncreaseBook;

import java.util.List;
import java.util.Map;

/**
 * 统计服务接口
 *
 * @author makejava
 * @since 2020-02-26 09:36:21
 */
public interface StatisticsService {

    List<Map<Object, Object>> bookBorrowingRatio();

    List<IncreaseBook> bookStorageByTime(String timeSlot);

    List<Map<Object, Object>> bookStorageByCategory();

    List<Map<Object, Object>> readerNumbersByTime(String timeSlot);
}
