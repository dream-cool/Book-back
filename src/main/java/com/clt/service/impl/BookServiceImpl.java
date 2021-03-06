package com.clt.service.impl;

import com.clt.constant.Const;
import com.clt.dao.*;
import com.clt.entity.*;
import com.clt.enums.BookEnum;
import com.clt.service.BookService;
import com.clt.service.LocationService;
import com.clt.service.TypeService;
import com.clt.utils.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
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

    @Resource
    private LocationService locationService;

    @Resource
    private UserClassDao userClassDao;

    @Resource
    private UserDao userDao;

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
     * 新增数据
     *
     * @param bookList 实例对象
     * @return 实例对象
     */
    @Override
    public int insertBatch(List<Book> bookList) {
        return this.bookDao.insertBatch(bookList);
    }

    /**
     * 新增书籍之前对书籍实体数据进行完善
     *
     * @param book 前端书籍实体
     * @return 返回处理后的书籍实体
     */
    private void beforeInsertBook(Book book) {
        if (book != null) {
            if (book == null || StringUtils.isEmpty(book.getBookId())) {
                book.setBookId(UUIDUtil.getUUID());
            }
            if (book.getPrice() == null || book.getPrice() < 0) {
                book.setPrice(new Double("0"));
            }
            if (book.getBookStatus() == null) {
                book.setBookStatus(BookEnum.BOOK_STATUS_IN_LIBRARY.getCode());
            }
            if (book.getInputTime() == null) {
                book.setInputTime(new Date());
            }
            if (book.getZanNumber() == null) {
                book.setZanNumber(0);
            }
            if (book.getImg() == null){
                book.setImg(Const.DEFAULT_BOOK_IMG);
            }
            if (book.getLocation() != null && BookEnum.BOOK_TYPE_PAPER.getCode().equals(book.getEbook())){
                Location location = new Location();
                location.setLocationId(book.getLocation());
                locationService.insert(location);
            } else if (book.getLocation() == null && BookEnum.BOOK_TYPE_EBOOK.getCode().equals(book.getEbook())){
                book.setLocation(Const.DEFAULT_EBOOK_FILE);
            }
            book.setBorrowingNumber(0);
            book.setUpdateTime(new Date());
        }
    }

    /**
     * 将查询到的书籍进行完事处理后再返回前端
     *
     * @param book 前端书籍实体
     * @return 返回处理后的书籍实体
     */
    private void handleBookAfterQuery(Book book) {
        if (book == null) {
            return;
        } else {
            if (BookEnum.BOOK_TYPE_EBOOK.getCode().equals(String.valueOf(book.getEbook()))) {
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


    private String path = System.getProperty("user.dir") + File.separator + "fileData";

    @Override
    public Map<Object, Object> getEbookInfo(Integer pageNum, Integer pageSize, String bookId) {
        Book book = queryById(bookId);
        String fileName = book.getLocation();
        String location = path + "/" + fileName;
        File file = new File(location);
        String fileSize = FileUtil.getPrintSize(file.length());
        pageNum = pageNum == null || pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize == null || pageSize < 0 ? 100 : pageSize;
        List<String> ebookContent = FileUtil.getFileContent(pageNum, pageSize, location);
        Map<Object, Object> result = new HashMap<>(16);
        pageNum = pageNum > (ebookContent.size() - 1) ? ebookContent.size() - 1 : pageNum;
        result.put("pageNum", pageNum);
        result.put("pageSize", pageSize);
        result.put("total", (ebookContent.size() - 1) * pageSize);
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
    private Set<String> idSet = new HashSet<>();

    @Override
    public PageInfo<Book> queryAllByCondition(Integer pageNum, Integer pageSize, Book book) {
        Page page = PageHelper.startPage(pageNum, pageSize);
        bookDao.queryAllByCondition(book);
        PageInfo<Book> pageInfo = new PageInfo<>(page);
//        PageInfo<Book> pageInfo = beforeAllByCondition(book);
        afterQueryAllByCondition(pageInfo.getList());
        return pageInfo;
    }

    /**
     * 级联类别的所有数据
     */
    private List<Type> cascadeTypes;

    /**
     * @param id 书籍id
     * @return 返回书籍的详细信息和书籍类别的层级id数组 [1,3,4]
     */
    @Override
    public ResultUtil<Map<String, Object>> getBookDetail(String id) {
        final Book book = this.queryById(id);
        if (book == null) {
            return ResultUtil.failed("没有找到书籍信息");
        }
        cascadeTypes = this.typeService.queryAllByCascade();
        List<String> ids = new ArrayList<>(10);
        ids = hanleCategory(book.getCategoryId(), cascadeTypes, ids);
        Collections.reverse(ids);
        Map<String, Object> data = new HashMap<>(16);
        data.put("typeList", ids);
        data.put("book", book);
        String qrcodePath = Const.filePath + File.separator +"QRCode" + File.separator ;
        String bookQRcode = qrcodePath +book.getBookId();
        File bookQRcodeFile = new File(bookQRcode+".jpg");
        if (!bookQRcodeFile.exists()){
            String qrcodeFilePath =  qrcodePath + book.getBookId();
            String content = "http://39.97.239.108:8080/front/bookDetail/" + book.getBookId();
            QRCodeUtils.genQrcodeImage(content, qrcodeFilePath);
            try {
                QRCodeUtils.drawCircle(qrcodeFilePath, qrcodePath + "favicon.jpg",  qrcodeFilePath +".jpg");
                File srcQrcodeFile = new File(qrcodeFilePath);
                if (srcQrcodeFile.exists() && !srcQrcodeFile.isDirectory()){
                    srcQrcodeFile.delete();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResultUtil.success(data, "查询成功");
    }


    /**
     * 寻找目标id对应的层级父id数组集合
     * <p>
     * 例如 小说(id = 1) > 中国小说（id = 3） > 武侠（id = 4）
     * 则 寻找id为4的层级父id  即返回 [4,3,1]
     *
     * @param id    具体的类别id
     * @param types 在哪些类型里面找
     * @param ids   层级id的数组集合
     */
    private List<String> hanleCategory(String id, List<Type> types, List<String> ids) {
        if (id == null) {
            return ids;
        }
        for (Type type : types) {
            if (type.getId().equals(id)) {
                /**
                 * 如果找到目标id 则存进ids
                 * 同时回溯递归其父id去寻找
                 * 如果父id为空则回溯完毕
                 */
                ids.add(id);
                this.hanleCategory(type.getPid(), cascadeTypes, ids);
            }
            if (type.getChildren() != null && !type.getChildren().isEmpty()) {
                hanleCategory(id, type.getChildren(), ids);
            }
        }
        return ids;
    }


    /**
     * 查询之前根据书籍实体是否带了类别的筛选条件进行处理
     *
     * @param book 书籍实体
     */
    @Deprecated
    private PageInfo<Book> beforeAllByCondition(Book book) {
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
            Page page = PageHelper.startPage(1, 12);
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
            PageHelper.startPage(1, 12);
            PageInfo<Book> pageInfo = new PageInfo<>(books);
            return pageInfo;
        } else {
            Page page = PageHelper.startPage(1, 12);
            bookDao.queryAllByCondition(book);
            PageInfo<Book> pageInfo = new PageInfo<>(page);
            return pageInfo;
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
        if (type != null && type.getId().equals(typeId)) {
            targetType = type;
            logger.info("type----" + type);
        }
        if (type.getChildren() != null && type.getChildren().size() > 0) {
            final List<Type> childList = type.getChildren();
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
        if (type.getChildren() != null && !type.getChildren().isEmpty()) {
            final List<Type> childList = type.getChildren();
            childList.stream().forEach(childType -> {
                resumeQueryTypeForIdSet(childType);
            });
        }
    }

    private void afterQueryAllByCondition(List<Book> books) {
        final Map<String, String> typeCollection = getTypeTitleById();
        books.stream().forEach(book -> {
            book.setCategoryId(typeCollection.get(book.getCategoryId()));
            handleBookAfterQuery(book);
        });
    }

    private Map<String, String> getTypeTitleById() {
        Map<String, String> map = new HashMap<>(16);
        final List<Type> types = typeDao.queryAll();
        types.stream().forEach(type -> {
            map.put(type.getId(), type.getTitle());
        });
        return map;
    }

    @Override
    public List<Book> queryRecommendBook(String userName) {
        final User user = userDao.queryByUserName(userName);
        if (user == null || user.getClassId() == null){
            return Collections.emptyList();
        }
        final UserClass userClass = userClassDao.queryById(user.getClassId());
        if (userClass == null || userClass.getDepartNo() == null){
            return Collections.emptyList();
        }
        return bookDao.queryRecommendBook(user.getUserId(), userClass.getDepartNo());
    }

    @Override
    public List<Book> queryNewBook() {
        return bookDao.queryNewBook();
    }

    @Override
    public List<Book> queryPopularBook() {
        return bookDao.queryPopularBook();
    }
}