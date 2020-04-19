package com.clt.service.impl;

import com.clt.constant.Const;
import com.clt.entity.IncreaseBook;
import com.clt.entity.Statistics;
import com.clt.dao.StatisticsDao;
import com.clt.enums.BookEnum;
import com.clt.service.StatisticsService;
import com.clt.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * (Statistics)表服务实现类
 *
 * @author makejava
 * @since 2020-04-18 21:05:36
 */
@Service("statisticsService")
public class StatisticsServiceImpl implements StatisticsService {
    @Resource
    private StatisticsDao statisticsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Statistics queryById(String id) {
        return this.statisticsDao.queryById(id);
    }

    @Override
    public Statistics queryYesterdayInfo(){
        return this.statisticsDao.queryYesterdayInfo();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Statistics> queryAllByLimit(int offset, int limit) {
        return this.statisticsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param statistics 实例对象
     * @return 实例对象
     */
    @Override
    public Statistics insert(Statistics statistics) {
        this.statisticsDao.insert(statistics);
        return statistics;
    }

    /**
     * 修改数据
     *
     * @param statistics 实例对象
     * @return 实例对象
     */
    @Override
    public Statistics update(Statistics statistics) {
        this.statisticsDao.update(statistics);
        return this.queryById(statistics.getId());
    }

    @Override
    public List<Statistics> queryAllByCondition(Statistics condition) {
        return statisticsDao.queryAllByCondition(condition);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.statisticsDao.deleteById(id) > 0;
    }


    @Override
    public List<Map<Object, Object>> bookBorrowingRatio() {
        Map<String, Object> map = new HashMap<>(16);
        List<Map<Object, Object>> books = statisticsDao.bookBorrowingRatio(map);
        for (Map<Object, Object> book : books) {
            if (book.get("status").equals("0")) {
                book.put("status", BookEnum.BOOK_STATUS_IN_LIBRARY.getMessage());
            }
            if (book.get("status").equals("1")) {
                book.put("status", BookEnum.BOOK_STATUS_LEND.getMessage());
            }
            if (book.get("status").equals("2")) {
                book.put("status", BookEnum.BOOK_STATUS_DAMAGE.getMessage());
            }
        }
        return books;
    }

    @Override
    public List<IncreaseBook> bookStorageByTime(String timeSlot, Date start, Date end) {
        Map<String, Object> map = new HashMap<>(16);
        if (StringUtils.isEmpty(timeSlot) || StringUtils.equalsIgnoreCase(timeSlot, DateUtils.DAY)) {
            map.put(Const.ITME_LEVEL, 10);
        } else if (StringUtils.equalsIgnoreCase(timeSlot, DateUtils.MONTH)) {
            map.put(Const.ITME_LEVEL, 7);
        } else if (StringUtils.equalsIgnoreCase(timeSlot, DateUtils.YEAR)) {
            map.put(Const.ITME_LEVEL, 4);
        }
        map.put("start", start);
        map.put("end", end);
        List<IncreaseBook> increaseBooks = new ArrayList<>();
        List<Map<Object, Object>> books = statisticsDao.bookStorageByTime(map);
        for (Map<Object, Object> book : books) {
            IncreaseBook increaseBook = new IncreaseBook();
            increaseBook.setDate(book.get("时间").toString());
            increaseBook.setBooks(book.get("新增书籍数量").toString());
            increaseBooks.add(increaseBook);
        }
        map.put("ebook", "0");
        List<Map<Object, Object>> paperBooks = statisticsDao.bookStorageByTime(map);
        for (Map<Object, Object> paperBook : paperBooks) {
            for (IncreaseBook book : increaseBooks) {
                if (paperBook.get("时间").equals(book.getDate())) {
                    book.setPaperBooks(paperBook.get("新增书籍数量").toString());
                }
            }
        }
        map.put("ebook", "1");
        List<Map<Object, Object>> beforeEbooks = statisticsDao.bookStorageByTime(map);
        for (Map<Object, Object> ebook : beforeEbooks) {
            for (IncreaseBook book : increaseBooks) {
                if (ebook.get("时间").equals(book.getDate())) {
                    book.setEbooks(ebook.get("新增书籍数量").toString());
                }
            }
        }
        return increaseBooks;
    }

    @Override
    public List<Map<Object, Object>> bookStorageByCategory() {
        Map<String, Object> map = new HashMap<>(16);
        List<Map<Object, Object>> books = statisticsDao.bookStorageByCategory(map);
        return books;
    }


    @Override
    public List<Map<Object, Object>> readerNumbersByTime(String timeSlot) {
        Map<String, Object> map = new HashMap<>(16);
        if (StringUtils.isEmpty(timeSlot) || StringUtils.equalsIgnoreCase(timeSlot, "DAY")) {
            map.put(Const.ITME_LEVEL, 10);
        } else if (StringUtils.equalsIgnoreCase(timeSlot, "MONTH")) {
            map.put(Const.ITME_LEVEL, 7);
        } else {
            map.put(Const.ITME_LEVEL, 4);
        }
        List<Map<Object, Object>> users = statisticsDao.readerNumbersByTime(map);
        return users;
    }

}