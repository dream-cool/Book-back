package com.clt.controller;

import com.alibaba.fastjson.JSONArray;
import com.clt.entity.Category;
import com.clt.service.CategoryService;
import com.clt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Category)表控制层
 *
 * @author makejava
 * @since 2020-02-25 19:04:25
 */
@RestController
@RequestMapping("category")
@Api("类别管理")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过主键查询单条数据")
    public ResultUtil<Category> selectOne(
            @ApiParam("id")
            @PathVariable String id) {
        Category category = this.categoryService.queryById(id);
        if (category != null) {
            return ResultUtil.success(category);
        } else {
            return ResultUtil.failed("没有找到对应信息");
        }
    }

    /**
     * 分页查询数据
     *
     * @param offset 起始
     * @param limit  条数
     * @return 多条数据
     */
    @GetMapping("")
    @ApiOperation("分页查询数据")
    public ResultUtil<List<Category>> selectAllByLimit(
            @ApiParam("起始") Integer offset,
            @ApiParam("条数") Integer limit
    ) {
        offset = (offset == null || offset < 0) ? 0 : offset;
        limit = (limit == null || limit < 0) ? 10 : limit;
        List<Category> categoryList = this.categoryService.queryAllByLimit(offset, limit);
        if (categoryList != null) {
            return ResultUtil.success(categoryList, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    /**
     * 通过实体数据新增单条数据
     *
     * @param category 类别实体
     * @return 新增的数据
     */
    @PostMapping("")
    public ResultUtil<Category> insert(@RequestBody Category category) {
        Category insertCategory = this.categoryService.insert(category);
        if (insertCategory != null) {
            return ResultUtil.success(insertCategory, "新增成功");
        } else {
            return ResultUtil.failed("新增失败");
        }
    }

    /**
     * 通过实体数据更新单条数据
     *
     * @param category 类别实体
     * @return 更新的数据
     */
    @PutMapping("")
    public ResultUtil<Category> update(@RequestBody Category category) {
        if (this.categoryService.queryById(category.getCategoryId()) == null) {
            return ResultUtil.failed("修改失败，没有找到对应信息");
        }
        Category updateCategory = this.categoryService.update(category);
        if (updateCategory != null) {
            return ResultUtil.success(updateCategory, "修改成功");
        } else {
            return ResultUtil.failed("修改失败");
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
        if (this.categoryService.queryById(id) == null) {
            return ResultUtil.failed("删除失败，没有找到对应信息");
        }
        boolean flag = this.categoryService.deleteById(id);
        if (flag) {
            return ResultUtil.success(true, "删除成功");
        } else {
            return ResultUtil.failed("删除失败");
        }
    }


    @GetMapping("/treeList")
    @ApiOperation("查询所有书籍类别列表信息")
    public JSONArray getCategoryList() {
        //休眠100毫秒，以便前端界面先加载表格组件
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            logger.error("context", e);
            Thread.currentThread().interrupt();
        }
        return categoryService.getCategoryList();
    }

    @GetMapping("typeInfo")
    public Map<Object, Object> getTypeInfo() {
        return categoryService.getTypeInfo();
    }


}