package com.clt.service;

import com.clt.entity.Borrowing;
import java.util.List;

/**
 * (Borrowing)表服务接口
 *
 * @author makejava
 * @since 2020-02-25 19:03:35
 */
public interface BorrowingService {

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    Borrowing queryById(String bookId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Borrowing> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param borrowing 实例对象
     * @return 实例对象
     */
    Borrowing insert(Borrowing borrowing);

    /**
     * 修改数据
     *
     * @param borrowing 实例对象
     * @return 实例对象
     */
    Borrowing update(Borrowing borrowing);

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 是否成功
     */
    boolean deleteById(String bookId);

}