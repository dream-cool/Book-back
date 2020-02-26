package com.clt.service.impl;

import com.clt.entity.Record;
import com.clt.dao.RecordDao;
import com.clt.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Record)表服务实现类
 *
 * @author makejava
 * @since 2020-02-26 09:36:22
 */
@Service("recordService")
public class RecordServiceImpl implements RecordService {
    @Resource
    private RecordDao recordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param recordId 主键
     * @return 实例对象
     */
    @Override
    public Record queryById(String recordId) {
        return this.recordDao.queryById(recordId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Record> queryAllByLimit(int offset, int limit) {
        return this.recordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param record 实例对象
     * @return 实例对象
     */
    @Override
    public Record insert(Record record) {
        this.recordDao.insert(record);
        return record;
    }

    /**
     * 修改数据
     *
     * @param record 实例对象
     * @return 实例对象
     */
    @Override
    public Record update(Record record) {
        this.recordDao.update(record);
        return this.queryById(record.getRecordId());
    }

    /**
     * 通过主键删除数据
     *
     * @param recordId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String recordId) {
        return this.recordDao.deleteById(recordId) > 0;
    }
}