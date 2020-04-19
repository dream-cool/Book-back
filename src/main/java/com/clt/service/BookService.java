package com.clt.service;

import com.clt.entity.Book;
import com.clt.utils.ResultUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * (Book)表服务接口
 *
 * @author makejava
 * @since 2020-02-26 09:39:53
 */
public interface BookService {

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    Book queryById(String bookId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Book> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    Book insert(Book book);

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    Book update(Book book);

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 是否成功
     */
    boolean deleteById(String bookId);


    /**
     *  根据电子书页码返回具体内容
     *
     * @param bookId  书籍Id
     * @param page  页码
     * @param rows  行数
     *
     * @return 电子书文本内容
     */
    Map<Object, Object> getEbookInfo(Integer page, Integer rows, String bookId);

    /**
     * 分页查询数据
     */
    List<Book> queryAll();

    PageInfo<Book> queryAllByCondition(Integer pageNum, Integer pageSize, Book book);

    ResultUtil<Map<String, Object>> getBookDetail(String id);

    List<Book> queryRecommendBook(String userName);

    List<Book> queryNewBook();

    List<Book> queryPopularBook();
}