package com.clt.controller;

import com.clt.entity.Book;
import com.clt.service.BookService;
import com.clt.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (Book)表控制层
 *
 * @author makejava
 * @since 2020-02-26 09:39:53
 */
@RestController
@RequestMapping("book")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    /**
     * 服务对象
     */
    @Resource
    private BookService bookService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过主键查询单条数据")
    public ResultUtil<Book> selectOne(
            @ApiParam("id")
            @PathVariable String id) {
        Book book = this.bookService.queryById(id);
        if (book != null) {
            return ResultUtil.success(book);
        } else {
            return ResultUtil.failed("没有找到对应信息");
        }
    }

    /**
     * 通过主键查询书籍详细信息
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/detail/{id}")
    @ApiOperation("通过主键查询单条数据")
    public ResultUtil<Map<String,Object>> getBookDetail(
            @ApiParam("id")
            @PathVariable String id){
        return this.bookService.getBookDetail(id);
    }

    /**
     * 查询部分数据
     *
     * @param offset 起始
     * @param limit  条数
     * @return 多条数据
     */
    @GetMapping("/limit")
    @ApiOperation("查询部分数据")
    public ResultUtil<List<Book>> selectAllByLimit(
            @ApiParam("起始") Integer offset,
            @ApiParam("条数") Integer limit
    ) {
        offset = (offset == null || offset < 0) ? 0 : offset;
        limit = (limit == null || limit < 0) ? 10 : limit;
        List<Book> books = this.bookService.queryAllByLimit(offset, limit);
        if (books != null) {
            return ResultUtil.success(books, "查询成功");
        } else {
            return ResultUtil.failed("系统繁忙,查询失败");
        }
    }

    @GetMapping("")
    @ApiOperation("分页查询数据")
    public ResultUtil<PageInfo<Book>> selectAllByPage(
            @ApiParam("页码") @RequestParam(value = "pageNum", required = false) Integer pageNum,
            @ApiParam("每页大小") @RequestParam(value = "pageSize", required = false) Integer pageSize,
            Book book
    ) {
        PageInfo<Book> pageInfo = this.bookService.queryAllByCondition(pageNum, pageSize, book);
        if (pageInfo != null) {
            return ResultUtil.success(pageInfo, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    /**
     * 通过实体数据新增单条数据
     *
     * @param book 书籍实体
     * @return 新增的数据
     */
    @PostMapping("")
    public ResultUtil<Book> insert(@RequestBody Book book) {
        Book insertBook = this.bookService.insert(book);
        if (insertBook != null) {
            return ResultUtil.success(insertBook, "新增成功");
        } else {
            return ResultUtil.failed();
        }
    }

    /**
     * 通过实体数据更新单条数据
     *
     * @param book 书籍实体
     * @return 更新的数据
     */
    @PutMapping("")
    public ResultUtil<Map<String,Object>> update(@RequestBody Book book) {
        if (this.bookService.queryById(book.getBookId()) == null) {
            return ResultUtil.failed("修改失败，没有找到对应信息");
        }
        Book updateBook = this.bookService.update(book);
        ResultUtil<Map<String, Object>> bookDetail = getBookDetail(updateBook.getBookId());
        if (updateBook != null && bookDetail.getData() != null) {
            bookDetail.setMessage("书籍修改成功");
            return bookDetail;
        } else {
            return ResultUtil.failed();
        }
    }

    /**
     * 通过主键删除单条数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public ResultUtil<Boolean> delete(@PathVariable String id) {
        if (this.bookService.queryById(id) == null) {
            return ResultUtil.failed("删除失败，没有找到对应信息");
        }
        boolean flag = this.bookService.deleteById(id);
        if (flag) {
            return ResultUtil.success(true, "删除成功");
        } else {
            return ResultUtil.failed();
        }
    }

    /**
     * 通过主键批量删除数据
     *
     * @param ids id数组
     * @return 删除结果
     */
    @GetMapping("/delete/batch")
    public ResultUtil<Boolean> deleteBatch(@RequestParam(value = "ids") List<String> ids) {
        logger.info(ids.toString());
        ids.stream().forEach(id ->{
            delete(id);
        });
        return ResultUtil.success(true, "删除成功");
    }


    @GetMapping("/ebook/{bookId}")
    @ApiOperation("根据电子书页码返回具体内容")
    public ResultUtil<Map<Object, Object>> getEbookInfo(
            @ApiParam(value = "页码", required = true, defaultValue = "1")
            @RequestParam(value = "pageNum", required = false) Integer pageNum,
            @ApiParam(value = "每页大小", required = true, defaultValue = "100")
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @ApiParam(value = "电子书id", required = true) @PathVariable(value = "bookId") String bookId) {
        return ResultUtil.success(bookService.getEbookInfo(pageNum, pageSize, bookId));
    }



}