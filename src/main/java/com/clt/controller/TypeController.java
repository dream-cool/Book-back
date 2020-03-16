package com.clt.controller;

import com.clt.entity.Type;
import com.clt.service.TypeService;
import com.clt.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Type)表控制层
 *
 * @author makejava
 * @since 2020-02-28 20:31:36
 */
@RestController
@RequestMapping("type")
public class TypeController {
    /**
     * 服务对象
     */
    @Resource
    private TypeService typeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过主键查询单条数据")
    public ResultUtil<Type> selectOne(
            @ApiParam("id")
            @PathVariable Integer id) {
        Type Type = this.typeService.queryById(id);
        if (Type != null) {
            return ResultUtil.success(Type);
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
    @GetMapping("/limit")
    @ApiOperation("查询某些数据")
    public ResultUtil<List<Type>> selectAllByLimit(
            @ApiParam("起始") Integer offset,
            @ApiParam("条数") Integer limit
    ) {
        offset = (offset == null || offset < 0) ? 0 : offset;
        limit = (limit == null || limit < 0) ? 10 : limit;
        List<Type> TypeList = this.typeService.queryAllByLimit(offset, limit);
        if (TypeList != null) {
            return ResultUtil.success(TypeList, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    @GetMapping("")
    @ApiOperation("分页查询数据")
    public ResultUtil<PageInfo<Type>> selectAllByPage(
            @ApiParam("页码") @RequestParam(required = false) Integer pageNum,
            @ApiParam("每页大小") @RequestParam(required = false) Integer pageSize,
            Type type
    ) {
        pageNum = (pageNum == null || pageNum < 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize < 0) ? 10 : pageSize;
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<Type> typeList = this.typeService.queryAllByCondition(type);
        PageInfo<Type> pageInfo = new PageInfo<>(page);
        if (pageInfo != null) {
            return ResultUtil.success(pageInfo, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }

    @GetMapping("/cascade")
    @ApiOperation("查询级联数据")
    public ResultUtil<List<Type>> queryAllByCascade() {
        List<Type> typeList = this.typeService.queryAllByCascade();
        if (typeList != null) {
            return ResultUtil.success(typeList, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }

    @GetMapping("/all")
    @ApiOperation("查询所有数据")
    public ResultUtil<List<Type>> queryAll() {
        List<Type> typeList = this.typeService.queryAll();
        if (typeList != null) {
            return ResultUtil.success(typeList, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    /**
     * 通过实体数据新增单条数据
     *
     * @param type 类别实体
     * @return 新增的数据
     */
    @PostMapping("")
    public ResultUtil<Type> insert(@RequestBody Type type) {
        Type insertType = this.typeService.insert(type);
        if (insertType != null) {
            return ResultUtil.success(insertType, "新增成功");
        } else {
            return ResultUtil.failed("新增失败");
        }
    }

    /**
     * 通过实体数据更新单条数据
     *
     * @param type 类别实体
     * @return 更新的数据
     */
    @PutMapping("")
    public ResultUtil<Type> update(@RequestBody Type type) {
        if (this.typeService.queryById(type.getId()) == null) {
            return ResultUtil.failed("修改失败，没有找到对应信息");
        }
        Type updateType = this.typeService.update(type);
        if (updateType != null) {
            return ResultUtil.success(updateType, "修改成功");
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
    public ResultUtil<Boolean> delete(@PathVariable Integer id) {
        if (this.typeService.queryById(id) == null) {
            return ResultUtil.failed("删除失败，没有找到对应信息");
        }
        boolean flag = this.typeService.deleteById(id);
        if (flag) {
            return ResultUtil.success(true, "删除成功");
        } else {
            return ResultUtil.failed("删除失败, 该类别下仍有书籍");
        }
    }


}