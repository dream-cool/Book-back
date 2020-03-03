package com.clt.service.impl;

import com.clt.entity.Borrowing;
import com.clt.dao.BorrowingDao;
import com.clt.enums.BorrowingEnum;
import com.clt.service.BorrowingService;
import com.clt.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * (Borrowing)表服务实现类
 *
 * @author makejava
 * @since 2020-02-26 09:33:43
 */
@Service("borrowingService")
public class BorrowingServiceImpl implements BorrowingService {
    @Resource
    private BorrowingDao borrowingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param borrowingId 主键
     * @return 实例对象
     */
    @Override
    public Borrowing queryById(String borrowingId) {
        return this.borrowingDao.queryById(borrowingId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
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
        return this.queryById(borrowing.getBorrowingId());
    }

    /**
     * 通过主键删除数据
     *
     * @param borrowingId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String borrowingId) {
        return this.borrowingDao.deleteById(borrowingId) > 0;
    }

    @Override
    public List<Borrowing> queryAll() {
        return this.borrowingDao.queryAll();
    }

    @Override
    public List<Borrowing> queryAllByCondition(Borrowing borrowing) {
        List<Borrowing> borrowings = this.borrowingDao.queryAllByCondition(borrowing);
        return borrowings;
    }

    @Override
    public ResultUtil<Borrowing> handleApplying(String operation, String userName, String borrowingId) {
        final Borrowing borrowingResult = queryById(borrowingId);
        if (borrowingResult == null) {
            ResultUtil.failed("没有找到对应借阅信息");
        }
        borrowingResult.setBorrowingStatus(BorrowingEnum.valueOf(operation).getCode());
        borrowingResult.setOperator(userName);
        borrowingResult.setHandleTime(new Date());
        borrowingResult.setUpdateTime(new Date());
        final Borrowing handleResult = update(borrowingResult);
        if (handleResult != null) {
            return ResultUtil.success(handleResult, "处理成功");
        } else {
            return ResultUtil.failed("操作失败");
        }
    }

    @Override
    public ResultUtil<Map<String,Object>> getBorrowingStatus() {
        if (BorrowingEnum.values().length <= 0) {
            return ResultUtil.failed("查询信息为空");
        }
        Map<String,Object> data = new HashMap<>(16);
        List<Map<String,String>> dataList = new ArrayList<>(BorrowingEnum.values().length);
        for (BorrowingEnum value : BorrowingEnum.values()) {
            Map<String, String> obj = new HashMap<>(BorrowingEnum.values().length);
            obj.put("message",value.getMessage());
            obj.put("code",value.getCode());
            dataList.add(obj);
        }
        data.put("list",dataList);
        Map<String,String> dataObj = new HashMap<>(16);
        for (BorrowingEnum value : BorrowingEnum.values()) {
            dataObj.put(value.getCode(),value.getMessage());
        }
        data.put("obj", dataObj);
        return ResultUtil.success(data, "查询成功");
    }
}