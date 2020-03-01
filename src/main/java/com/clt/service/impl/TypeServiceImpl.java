package com.clt.service.impl;

import com.clt.dao.BookDao;
import com.clt.dao.TypeDao;
import com.clt.entity.Book;
import com.clt.entity.Type;
import com.clt.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * (Type)表服务实现类
 *
 * @author makejava
 * @since 2020-02-28 20:31:36
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeDao typeDao;

    @Autowired
    private BookDao bookDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Type queryById(Integer id) {
        return this.typeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Type> queryAllByLimit(int offset, int limit) {
        return this.typeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @Override
    public Type insert(Type type) {
        beforeInsertType(type);
        this.typeDao.insert(type);
        return type;
    }

    /**
     * @param type 处理前的类型实体
     * @return 处理后的类型实体
     */
    private Type beforeInsertType(Type type){
        if (type.getPid() == null){
            type.setLevel(1);
        } else {
            final Type parentType = queryById(type.getPid());
            type.setLevel(parentType.getLevel()+1);
        }
        type.setCreateTime(new Date());
        return type;
    }

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @Override
    public Type update(Type type) {
        this.typeDao.update(type);
        return this.queryById(type.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        Book book = new Book();
        book.setCategoryId(String.valueOf(id));
        final List<Book> books = bookDao.queryAllByCondition(book);
        if (books != null && books.size() > 0){
            return false;
        }
        beforeDelete(id);
        return this.typeDao.deleteById(id) > 0;
    }

    /**
     *  删除该类别之前先把该类别下的子类别修改到该类别的父类下
     *
     * @param id 类别id
     */
    private void beforeDelete(Integer id){
        final Type type = typeDao.queryById(id);
        Type typeCondition = new Type();
        typeCondition.setPid(id);
        final List<Type> types = typeDao.queryAllByCondition(typeCondition);
        types.stream().forEach(updateType -> {
            updateType.setPid(type.getPid());
            typeDao.update(updateType);
        });
    }


    @Override
    public List<Type> queryAll() {
        return this.typeDao.queryAll();
    }

    @Override
    public List<Type> queryAllByCondition(Type type) {
        List<Type> types = this.typeDao.queryAllByCondition(type);
        afterQueryType(types);
        return types;
    }

    /**
     * 处理类别列表数据添加父类名称
     *
     */
    private void afterQueryType(List<Type> types){
        Map<Integer, String> map = new HashMap<>(16);
        map.put(null,"无" );
        final List<Type> allTypes = queryAll();
        for (Type type : allTypes) {
            map.put(type.getId(), type.getTitle());
        }
        for (Type type : types) {
            type.setPName(map.get(type.getPid()));
        }
    }


    @Override
    public List<Type> queryAllByCascade() {
        List<Type> types = queryAll();
        Iterator<Type> it = types.iterator();
        /**
         * 在所有类别信息中 找到父类不为空的类别
         * 然后将其添加到父类的child中
         */
        while (it.hasNext()){
            final Type next = it.next();
            if (next.getPid() != null){
                final List<Type> collect = types.stream().filter(type -> {
                    return type.getId().equals(next.getPid());
                }).collect(Collectors.toList());
                collect.get(0).getChild().add(next);
            }
        }
        /**
         * 针对已经添加到父类child的类别进行去重
         */
        it = types.iterator();
        while (it.hasNext()){
            final Type next = it.next();
            if (next.getPid() != null){
                it.remove();
            }
        }
        return types;
    }
}