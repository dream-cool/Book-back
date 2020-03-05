package com.clt.service.impl;

import com.clt.constant.Const;
import com.clt.dao.StatisticsDao;
import com.clt.entity.IncreaseBook;
import com.clt.enums.BookEnum;
import com.clt.service.StatisticsService;
import com.clt.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Statistics)表服务实现类
 *
 * @author makejava
 * @since 2020-03-05 09:36:19
 */
@Service("statisticsService")
public class StatisticsServiceImpl implements StatisticsService {
    @Resource
    private StatisticsDao statisticsDao;


    @Override
    public List<Map<Object, Object>> bookBorrowingRatio() {
        Map<String, Object> map = new HashMap<>(16);
        List<Map<Object, Object>> books = statisticsDao.bookBorrowingRatio(map);
        for (Map<Object, Object> book : books) {
            if (book.get("status").equals("0")){
                book.put("status", BookEnum.BOOK_STATUS_IN_LIBRARY.getMessage());
            }
            if (book.get("status").equals("1")){
                book.put("status", BookEnum.BOOK_STATUS_LEND.getMessage());
            }
            if (book.get("status").equals("2")){
                book.put("status", BookEnum.BOOK_STATUS_DAMAGE.getMessage());
            }
        }
        return books;
    }

    @Override
    public List<IncreaseBook> bookStorageByTime(String timeSlot) {
        Map<String, Object> map = new HashMap<>(16);
        if (StringUtils.isEmpty(timeSlot) || StringUtils.equalsIgnoreCase(timeSlot, DateUtils.DAY)) {
            map.put(Const.ITME_LEVEL, 10);
        } else if (StringUtils.equalsIgnoreCase(timeSlot, DateUtils.MONTH)) {
            map.put(Const.ITME_LEVEL, 7);
        } else if (StringUtils.equalsIgnoreCase(timeSlot, DateUtils.YEAR)) {
            map.put(Const.ITME_LEVEL, 4);
        }
        List<IncreaseBook> increaseBooks = new ArrayList<>();
        List<Map<Object, Object>> books = statisticsDao.bookStorageByTime(map);
        for (Map<Object, Object> book : books) {
            IncreaseBook increaseBook = new IncreaseBook();
            increaseBook.setDate(book.get("时间").toString());
            increaseBook.setBooks(book.get("新增书籍数量").toString());
            increaseBooks.add(increaseBook);
        }
        map.put("ebook","0");
        List<Map<Object, Object>> paperBooks = statisticsDao.bookStorageByTime(map);
        for (Map<Object, Object> paperBook : paperBooks) {
            for (IncreaseBook book : increaseBooks) {
                if (paperBook.get("时间").equals(book.getDate())){
                    book.setPaperBooks(paperBook.get("新增书籍数量").toString());
                }
            }
        }
        map.put("ebook", "1");
        List<Map<Object, Object>> beforeEbooks = statisticsDao.bookStorageByTime(map);
        for (Map<Object, Object> ebook : beforeEbooks) {
            for (IncreaseBook book : increaseBooks) {
                if (ebook.get("时间").equals(book.getDate())){
                    book.setEbooks(ebook.get("新增书籍数量").toString());
                }
            }
        }
        return increaseBooks;
    }

    @Override
    public List<Map<Object, Object>> bookStorageByCategory() {
        Map<String,Object> map = new HashMap<>(16);
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