package com.clt.service;

import com.clt.entity.Borrowing;
import com.clt.utils.ResultUtil;

import java.util.List;
import java.util.Map;

/**
 * (Borrowing)表服务接口
 *
 * @author makejava
 * @since 2020-02-26 09:33:42
 */
public interface BorrowingService {

    /**
     * 通过ID查询单条数据
     *
     * @param borrowingId 主键
     * @return 实例对象
     */
    Borrowing queryById(String borrowingId);

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
    ResultUtil<Borrowing> insert(Borrowing borrowing);

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
     * @param borrowingId 主键
     * @return 是否成功
     */
    boolean deleteById(String borrowingId);

    /**
     * 查询所有数据
     */
    List<Borrowing> queryAll();

    List<Borrowing> queryAllByCondition(Borrowing borrowing);

    ResultUtil<Borrowing> handleApplying(String operation, String userName, String borrowingId,String note);

    ResultUtil<Map<String,Object>> getBorrowingStatus();

    ResultUtil<Borrowing> handleReturn(String borrowingId, String userName);
}