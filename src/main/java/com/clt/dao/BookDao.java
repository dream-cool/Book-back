package com.clt.dao;

import com.clt.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (Book)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-26 09:39:52
 */
@Mapper
public interface BookDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    Book queryById(String bookId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Book> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param book 实例对象
     * @return 对象列表
     */
    List<Book> queryAllByCondition(Book book);

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Book> queryAll();

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 影响行数
     */
    int insert(Book book);

    /**
     *  批量插入
     */
    int insertBatch(List<Book> bookList);

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 影响行数
     */
    int update(Book book);

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 影响行数
     */
    int deleteById(String bookId);


    List<Map> bookBorrowingRatio(Map map);

    List<Book> queryRecommendBook(@Param("userId") String userId, @Param("departNo") String departNo);

    List<Book> queryPopularBook();

    List<Book> queryNewBook();
}