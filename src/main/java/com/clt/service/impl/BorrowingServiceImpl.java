package com.clt.service.impl;

import com.clt.entity.Borrowing;
import com.clt.dao.BorrowingDao;
import com.clt.service.BorrowingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Borrowing)表服务实现类
 *
 * @author makejava
 * @since 2020-02-25 19:03:35
 */
@Service("borrowingService")
public class BorrowingServiceImpl implements BorrowingService {
    @Resource
    private BorrowingDao borrowingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    @Override
    public Borrowing queryById(String bookId) {
        return this.borrowingDao.queryById(bookId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Borrowing> queryAllByLimit(int offset, int limit) {
        return this.borrowingDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param borrowing 实例对象
     * @return 实例对象
     */
    @Override
    public Borrowing insert(Borrowing borrowing) {
        this.borrowingDao.insert(borrowing);
        return borrowing;
    }

    /**
     * 修改数据
     *
     * @param borrowing 实例对象
     * @return 实例对象
     */
    @Override
    public Borrowing update(Borrowing borrowing) {
        this.borrowingDao.update(borrowing);
        return this.queryById(borrowing.getBookId());
    }

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String bookId) {
        return this.borrowingDao.deleteById(bookId) > 0;
    }
}