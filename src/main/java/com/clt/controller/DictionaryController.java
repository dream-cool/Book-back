package com.clt.controller;

import com.clt.entity.Dictionary;
import com.clt.service.DictionaryService;
import com.clt.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dictionary)表控制层
 *
 * @author makejava
 * @since 2020-03-30 19:06:59
 */
@RestController
@RequestMapping("dictionary")
public class DictionaryController {
    /**
     * 服务对象
     */
    @Resource
    private DictionaryService dictionaryService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过主键查询单条数据")
    public ResultUtil<Dictionary> selectOne(
            @ApiParam("id")
            @PathVariable String id) {
        Dictionary dictionary = this.dictionaryService.queryById(id);
        if (dictionary != null) {
            return ResultUtil.success(dictionary);
        } else {
            return ResultUtil.failed("没有找到对应信息");
        }
    }

    /**
     * 查询数据
     *
     * @param offset 起始
     * @param limit  条数
     * @return 多条数据
     */
    @GetMapping("/limit")
    @ApiOperation("查询数据")
    public ResultUtil<List<Dictionary>> selectAllByLimit(
            @ApiParam("起始") Integer offset,
            @ApiParam("条数") Integer limit
    ) {
        offset = (offset == null || offset < 0) ? 0 : offset;
        limit = (limit == null || limit < 0) ? 10 : limit;
        List<Dictionary> dictionaries = this.dictionaryService.queryAllByLimit(offset, limit);
        if (dictionaries != null) {
            return ResultUtil.success(dictionaries, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    @PostMapping("/all")
    @ApiOperation("分页查询数据")
    public ResultUtil<PageInfo<Dictionary>> selectAllByPage(
            @ApiParam("页码") @RequestParam(required = false) Integer pageNum,
            @ApiParam("每页大小") @RequestParam(required = false) Integer pageSize,
            @ApiParam("用户id") @RequestParam(required = false) String userId,
            @RequestBody Dictionary dictionary
    ) {
        pageNum = (pageNum == null || pageNum < 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize < 0) ? 10 : pageSize;
        Page page = PageHelper.startPage(pageNum, pageSize);
        this.dictionaryService.queryAllByCondition(dictionary);
        PageInfo<Dictionary> pageInfo = new PageInfo<>(page);
        if (pageInfo != null) {
            return ResultUtil.success(pageInfo, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    /**
     * 通过实体数据新增单条数据
     *
     * @param dictionary 评论实体
     * @return 新增的数据
     */
    @PostMapping("")
    @ApiOperation("通过实体数据新增单条数据")
    public ResultUtil<Dictionary> insert(@RequestBody Dictionary dictionary) {
        if (dictionary == null || StringUtils.isBlank(dictionary.getId())) {
            return ResultUtil.failed("评论内容为空");
        }
        Dictionary insertDictionary = this.dictionaryService.insert(dictionary);
        if (insertDictionary != null) {
            return ResultUtil.success(insertDictionary, "新增成功");
        } else {
            return ResultUtil.failed("新增失败");
        }
    }

    /**
     * 通过实体数据更新单条数据
     *
     * @param dictionary 评论实体
     * @return 更新的数据
     */
    @PutMapping("")
    @ApiOperation("通过实体数据更新单条数据")
    public ResultUtil<Dictionary> update(@RequestBody Dictionary dictionary) {
        if (this.dictionaryService.queryById(dictionary.getId()) == null) {
            return ResultUtil.failed("修改失败，没有找到对应信息");
        }
        Dictionary updateDictionary = this.dictionaryService.update(dictionary);
        if (updateDictionary != null) {
            return ResultUtil.success(updateDictionary, "修改成功");
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
    @ApiOperation("通过主键删除单条数据")
    public ResultUtil<Boolean> delete(@PathVariable String id) {
        if (this.dictionaryService.queryById(id) == null) {
            return ResultUtil.failed("删除失败，没有找到对应信息");
        }
        boolean flag = this.dictionaryService.deleteById(id);
        if (flag) {
            return ResultUtil.success(true, "删除成功");
        } else {
            return ResultUtil.failed("删除失败");
        }
    }

}