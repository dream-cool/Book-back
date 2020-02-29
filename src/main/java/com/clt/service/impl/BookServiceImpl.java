package com.clt.service.impl;

import com.clt.dao.BookDao;
import com.clt.dao.TypeDao;
import com.clt.entity.Book;
import com.clt.entity.Type;
import com.clt.service.BookService;
import com.clt.utils.FileUtil;
import com.clt.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Book)表服务实现类
 *
 * @author makejava
 * @since 2020-02-26 09:39:53
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    @Autowired
    private TypeDao typeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bookId 主键
     * @return 实例对象
     */
    @Override
    public Book queryById(String bookId) {
        return this.bookDao.queryById(bookId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Book> queryAllByLimit(int offset, int limit) {
        return this.bookDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @Override
    public Book insert(Book book) {
        beforeInsertBook(book);
        this.bookDao.insert(book);
        return book;
    }

    /**
     * 新增书籍之前对书籍实体数据进行完善
     * @param book 前端书籍实体
     * @return 返回处理后的书籍实体
     */
    private Book beforeInsertBook(Book book) {
        if (book != null) {
            book.setBookId(UUIDUtil.getUUID());
            book.setZanNumber(0);
            book.setUpdateTime(new Date());
        }
        return book;
    }

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @Override
    public Book update(Book book) {
        this.bookDao.update(book);
        return this.queryById(book.getBookId());
    }

    /**
     * 通过主键删除数据
     *
     * @param bookId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String bookId) {
        return this.bookDao.deleteById(bookId) > 0;
    }


    @Value("${spring.servlet.multipart.location}")
    private String path;

    @Override
    public Map<Object,Object> getEbookInfo(Integer page,Integer rows, String bookId){
        Book book = queryById(bookId);
        String fileName = book.getLocation();
        String location = path+"/"+fileName;
        File file = new File(location);
        String fileSize = FileUtil.getPrintSize(file.length());
        page = page == null || page < 0 ? 1 : page;
        rows = rows == null || rows < 0 ? 100 : rows;
        List<String> ebookContent = FileUtil.getFileContent(page,rows,location);
        Map<Object,Object> result = new HashMap<>(16);
        result.put("pageIndex", page);
        result.put("rows", rows);
        result.put("total",ebookContent.size() * rows);
        result.put("content",ebookContent.get(page));
        result.put("book",book);
        result.put("fileSize",fileSize);
        return result;
    }

    @Override
    public List<Book> queryAll() {
        return this.bookDao.queryAll();
    }

    @Override
    public List<Book> queryAllByCondition(Book book) {
        List<Book> books = this.bookDao.queryAllByCondition(book);
        afterQueryAllByCondition(books);
        return books;
    }

    private void afterQueryAllByCondition(List<Book> books){
        final Map<Integer, String> typeCollection = getTypeTitleById();
        books.stream().forEach(book -> {
            book.setCategoryId(typeCollection.get(Integer.valueOf(book.getCategoryId())));
        });
    }

    private Map<Integer, String> getTypeTitleById(){
        Map<Integer,String> map = new HashMap<>();
        final List<Type> types = typeDao.queryAll();
        types.stream().forEach(type -> {
            map.put(type.getId(), type.getTitle());
        });
        return map;
    }


}