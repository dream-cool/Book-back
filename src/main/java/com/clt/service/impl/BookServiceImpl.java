package com.clt.service.impl;

import com.clt.constant.Const;
import com.clt.dao.BookDao;
import com.clt.dao.TypeDao;
import com.clt.entity.Book;
import com.clt.entity.Category;
import com.clt.entity.Type;
import com.clt.enums.BookEnum;
import com.clt.service.BookService;
import com.clt.service.TypeService;
import com.clt.utils.FileUtil;
import com.clt.utils.PageUtil;
import com.clt.utils.ResultUtil;
import com.clt.utils.UUIDUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * (Book)表服务实现类
 *
 * @author makejava
 * @since 2020-02-26 09:39:53
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Resource
    private BookDao bookDao;

    @Autowired
    private TypeDao typeDao;

    @Autowired
    private TypeService typeService;

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
     *
     * @param book 前端书籍实体
     * @return 返回处理后的书籍实体
     */
    private void beforeInsertBook(Book book) {
        if (book != null) {
            if (book == null || StringUtils.isEmpty(book.getBookId())){
                book.setBookId(UUIDUtil.getUUID());
            }
            if (book.getPrice() == null || book.getPrice() < 0){
                book.setPrice(new Double("0"));
            }
            if (book.getBookStatus() == null) {
                book.setBookStatus(BookEnum.BOOK_STATUS_IN_LIBRARY.getCode());
            }
            if (book.getInputTime() == null) {
                book.setInputTime(new Date());
            }
            if (book.getZanNumber() == null){
                book.setZanNumber(0);
            }
            book.setUpdateTime(new Date());
        }
    }

    /**
     * 将查询到的书籍进行完事处理后再返回前端
     *
     * @param book 前端书籍实体
     * @return 返回处理后的书籍实体
     */
    private void handleBookAfterQuery(Book book){
        if (book == null) {
            return;
        } else {
            if (BookEnum.BOOK_TYPE_EBOOK.getCode().equals(book.getEbook())){
                book.setBookStatus("无");
                book.setPrice(new Double("0"));
                book.setLocation("无");
            }
        }
    }


    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @Override
    public Book update(Book book) {
        beforeInsertBook(book);
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
    public Map<Object, Object> getEbookInfo(Integer pageNum, Integer pageSize, String bookId) {
        Book book = queryById(bookId);
        String fileName = book.getLocation();
        String location = path + "/" + fileName;
        File file = new File(location);
        String fileSize = FileUtil.getPrintSize(file.length());
        pageNum = pageNum == null || pageNum < 0 ? 1 : pageNum;
        pageSize = pageSize == null || pageSize < 0 ? 100 : pageSize;
        List<String> ebookContent = FileUtil.getFileContent(pageNum, pageSize, location);
        Map<Object, Object> result = new HashMap<>(16);
        result.put("pageNum", pageNum);
        result.put("pageSize", pageSize);
        result.put("total", ebookContent.size() * pageSize);
        result.put("content", ebookContent.get(pageNum));
        result.put("book", book);
        result.put("fileSize", fileSize);
        return result;
    }

    @Override
    public List<Book> queryAll() {
        return this.bookDao.queryAll();
    }


    /**
     * 根据Book实体中传入id 寻找到对应级联的Type
     */
    private Type targetType;

    /**
     * 对应级联Type中child的所有id
     */
    private Set<Integer> idSet = new HashSet<>();

    @Override
    public PageInfo<Book> queryAllByCondition(Integer pageNum, Integer pageSize, Book book) {
        pageNum = (pageNum == null || pageNum < 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize < 0) ? 10 : pageSize;
        List<Book> books = beforeAllByCondition(book);
        afterQueryAllByCondition(books);
        return PageUtil.getPageInfo(pageNum, pageSize, books);
    }

    /**
     * 级联类别的所有数据
     */
    private List<Type> cascadeTypes;

    /**
     * @param id 书籍id
     * @return 返回书籍的详细信息和书籍类别的层级id数组 [1,3,4]
     *
     */
    @Override
    public ResultUtil<Map<String, Object>> getBookDetail(String id) {
        final Book book = this.queryById(id);
        if (book == null) {
            return ResultUtil.failed("没有找到书籍信息");
        }
        book.setImg(Const.SERVER_URL+ "/download/" +book.getImg());
        cascadeTypes = this.typeService.queryAllByCascade();
        List<Integer> ids = new ArrayList<>(10);
        ids = hanleCategory(Integer.valueOf(book.getCategoryId()), cascadeTypes,ids);
        Collections.reverse(ids);
        Map<String, Object> data = new HashMap<>(16);
        data.put("typeList", ids);
        data.put("book", book);
        return ResultUtil.success(data, "查询成功");
    }


    /**
     * 寻找目标id对应的层级父id数组集合
     *
     * 例如 小说(id = 1) > 中国小说（id = 3） > 武侠（id = 4）
     * 则 寻找id为4的层级父id  即返回 [4,3,1]
     *
     * @param id 具体的类别id
     * @param types 在哪些类型里面找
     * @param ids 层级id的数组集合
     */
    private List<Integer> hanleCategory(Integer id, List<Type> types, List<Integer> ids){
        if (id == null){
            return ids;
        }
        for (Type type : types) {
            if (type.getId().equals(id)){
                /**
                 * 如果找到目标id 则存进ids
                 * 同时回溯递归其父id去寻找
                 * 如果父id为空则回溯完毕
                 */
                ids.add(id);
                this.hanleCategory(type.getPid(),cascadeTypes , ids);
            }
            if (type.getChild() != null && !type.getChild().isEmpty()) {
                hanleCategory(id, type.getChild(), ids);
            }
        }
        return ids;
    }


    /**
     * 查询之前根据书籍实体是否带了类别的筛选条件进行处理
     *
     * @param book 书籍实体
     */
    private List<Book> beforeAllByCondition(Book book) {
        if (book != null && StringUtils.isNotEmpty(book.getCategoryId()) && StringUtils.isNoneBlank(book.getCategoryId())) {
            List<Type> types = this.typeService.queryAllByCascade();
            /**
             * 遍历级联列表寻找需要的 targetType
             */
            for (Type type : types) {
                resumeQueryTargetType(type, book.getCategoryId());
            }
            resumeQueryTypeForIdSet(targetType);
            /**
             * 针对某一类别下的所有类别
             * 逐一寻找满足要求的图书
             */
            List<Book> books = new ArrayList<>(0);
            logger.info("idSet -------" + idSet);
            idSet.stream().forEach(id -> {
                book.setCategoryId(String.valueOf(id));
                books.addAll(this.bookDao.queryAllByCondition(book));
            });
            /**
             * 容器处理完后进行销毁
             */
            idSet = new HashSet<>();
            return books;
        } else {
            return bookDao.queryAllByCondition(book);
        }
    }

    /**
     * 递归寻找某一级联类别下的所有子类中
     * 满足条件的类别 存入成员变量targetType
     *
     * @param type
     * @param typeId
     */
    private void resumeQueryTargetType(Type type, String typeId) {
        if (type != null && type.getId().equals(Integer.valueOf(typeId))) {
            targetType = type;
            logger.info("type----" + type);
        }
        if (type.getChild() != null && type.getChild().size() > 0) {
            final List<Type> childList = type.getChild();
            childList.stream().forEach(childType -> {
                resumeQueryTargetType(childType, typeId);
            });
        }
    }

    /**
     * 从级联类别中找到满足条件的类别后
     * 再从该类别出发 递归子类别，将找到的所有
     * 类别id存入idSet
     *
     * @param type 类别
     */
    private void resumeQueryTypeForIdSet(Type type) {
        idSet.add(type.getId());
        if (type.getChild() != null && !type.getChild().isEmpty()) {
            final List<Type> childList = type.getChild();
            childList.stream().forEach(childType -> {
                resumeQueryTypeForIdSet(childType);
            });
        }
    }

    private void afterQueryAllByCondition(List<Book> books) {
        final Map<Integer, String> typeCollection = getTypeTitleById();
        books.stream().forEach(book -> {
            book.setCategoryId(typeCollection.get(Integer.valueOf(book.getCategoryId())));
        });
    }

    private Map<Integer, String> getTypeTitleById() {
        Map<Integer, String> map = new HashMap<>();
        final List<Type> types = typeDao.queryAll();
        types.stream().forEach(type -> {
            map.put(type.getId(), type.getTitle());
        });
        return map;
    }


}