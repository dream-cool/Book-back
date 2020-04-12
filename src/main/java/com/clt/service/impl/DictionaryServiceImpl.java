package com.clt.service.impl;

import com.clt.dao.DictionaryDao;
import com.clt.dao.DictionaryDataDao;
import com.clt.entity.Dictionary;
import com.clt.service.DictionaryService;
import com.clt.utils.UUIDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Dictionary)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 19:06:58
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
    @Resource
    private DictionaryDao dictionaryDao;

    @Resource
    private DictionaryDataDao dictionaryDataDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Dictionary queryById(String id) {
        return this.dictionaryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Dictionary> queryAllByLimit(int offset, int limit) {
        return this.dictionaryDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Dictionary> queryAllByCondition(Dictionary dictionary) {
        return this.dictionaryDao.queryAllByCondition(dictionary);
    }

    /**
     * 新增数据
     *
     * @param dictionary 实例对象
     * @return 实例对象
     */
    @Override
    public Dictionary insert(Dictionary dictionary) {
        if (dictionary.getId() == null){
            dictionary.setId(UUIDUtil.getUUID());
        }
        if (dictionary.getStatus() == null){
            dictionary.setStatus(1);
        }
        dictionary.setCreateTime(new Date());
        this.dictionaryDao.insert(dictionary);
        return dictionary;
    }

    /**
     * 修改数据
     *
     * @param dictionary 实例对象
     * @return 实例对象
     */
    @Override
    public Dictionary update(Dictionary dictionary) {
        this.dictionaryDao.update(dictionary);
        return this.queryById(dictionary.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        final Dictionary dictionary = queryById(id);
        dictionaryDataDao.deleteByType(dictionary.getType());
        return this.dictionaryDao.deleteById(id) > 0;
    }
}