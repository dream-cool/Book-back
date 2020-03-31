package com.clt.controller;

import com.clt.entity.DictionaryData;
import com.clt.service.DictionaryDataService;
import com.clt.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (DictionaryData)表控制层
 *
 * @author makejava
 * @since 2020-03-30 19:07:22
 */
@RestController
@RequestMapping("dictionaryData")
public class DictionaryDataController {
    /**
     * 服务对象
     */
    @Resource
    private DictionaryDataService dictionaryDataService;

    @Autowired
    private StringRedisTemplate template;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过主键查询单条数据")
    public ResultUtil<DictionaryData> selectOne(
            @ApiParam("id")
            @PathVariable String id) {
        DictionaryData dictionaryData = this.dictionaryDataService.queryById(id);
        if (dictionaryData != null) {
            return ResultUtil.success(dictionaryData);
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
    public ResultUtil<List<DictionaryData>> selectAllByLimit(
            @ApiParam("起始") Integer offset,
            @ApiParam("条数") Integer limit
    ) {
        offset = (offset == null || offset < 0) ? 0 : offset;
        limit = (limit == null || limit < 0) ? 10 : limit;
        List<DictionaryData> dictionaryDataList = this.dictionaryDataService.queryAllByLimit(offset, limit);
        if (dictionaryDataList != null) {
            return ResultUtil.success(dictionaryDataList, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    @PostMapping("/all")
    @ApiOperation("分页查询数据")
    public ResultUtil<PageInfo<DictionaryData>> selectAllByPage(
            @ApiParam("页码") @RequestParam(required = false) Integer pageNum,
            @ApiParam("每页大小") @RequestParam(required = false) Integer pageSize,
            @ApiParam("用户id") @RequestParam(required = false) String userId,
            @RequestBody DictionaryData dictionaryData
    ) {
        pageNum = (pageNum == null || pageNum < 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize < 0) ? 10 : pageSize;
        Page page = PageHelper.startPage(pageNum, pageSize);
        this.dictionaryDataService.queryAllByCondition(dictionaryData);
        PageInfo<DictionaryData> pageInfo = new PageInfo<>(page);
        if (pageInfo != null) {
            return ResultUtil.success(pageInfo, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }

    @GetMapping("/class/getClassInfo")
    @ApiOperation("获取班级级联信息")
    public ResultUtil<List<List<DictionaryData>>> getClassInfo() {
        return this.dictionaryDataService.getClassInfo();
    }


    /**
     * 通过实体数据新增单条数据
     *
     * @param dictionaryData 评论实体
     * @return 新增的数据
     */
    @PostMapping("")
    @ApiOperation("通过实体数据新增单条数据")
    public ResultUtil<DictionaryData> insert(@RequestBody DictionaryData dictionaryData) {
        DictionaryData insertDictionaryData = this.dictionaryDataService.insert(dictionaryData);
        if (insertDictionaryData != null) {
            return ResultUtil.success(insertDictionaryData, "新增成功");
        } else {
            return ResultUtil.failed("新增失败");
        }
    }

    /**
     * 通过实体数据更新单条数据
     *
     * @param dictionaryData 评论实体
     * @return 更新的数据
     */
    @PutMapping("")
    @ApiOperation("通过实体数据更新单条数据")
    public ResultUtil<DictionaryData> update(@RequestBody DictionaryData dictionaryData) {
        if (this.dictionaryDataService.queryById(dictionaryData.getId()) == null) {
            return ResultUtil.failed("修改失败，没有找到对应信息");
        }
        DictionaryData updateDictionaryData = this.dictionaryDataService.update(dictionaryData);
        if (updateDictionaryData != null) {
            return ResultUtil.success(updateDictionaryData, "修改成功");
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
        if (this.dictionaryDataService.queryById(id) == null) {
            return ResultUtil.failed("删除失败，没有找到对应信息");
        }
        boolean flag = this.dictionaryDataService.deleteById(id);
        if (flag) {
            return ResultUtil.success(true, "删除成功");
        } else {
            return ResultUtil.failed("删除失败");
        }
    }



    @PostMapping("/redis")
    public ResultUtil<Map<Object, Object>> insert(
            @ApiParam @RequestParam(required = false) String field,
            @ApiParam @RequestParam String key,
            @ApiParam @RequestParam String value
    ) {
        return this.dictionaryDataService.insert(field, key, value);
    }

    @GetMapping("/redis")
    public ResultUtil<Map<Object, Object>> query(
            @ApiParam @RequestParam(required = false) String field,
            @ApiParam @RequestParam String key
    ) {
        return this.dictionaryDataService.query(field, key);
    }

    @GetMapping("/redis/multiple")
    public ResultUtil<List<Map<Object, Object>>> multipleQuery(
            @ApiParam @RequestParam(required = false) List<String> fields
    ) {
        return this.dictionaryDataService.multipleQuery(fields);
    }


    @PutMapping("/redis")
    public ResultUtil<Map<Object, Object>> update(
            @ApiParam @RequestParam(required = false) String field,
            @ApiParam @RequestParam String key,
            @ApiParam @RequestParam String value
    ) {
        return this.dictionaryDataService.update(field, key, value);
    }

    @Delete("/redis")
    public ResultUtil<Map<Object, Object>> delete(
            @ApiParam @RequestParam(required = false) String field,
            @ApiParam @RequestParam String key
    ) {
        return this.dictionaryDataService.delete(field, key);
    }

    @GetMapping("/redis/keys")
    public ResultUtil<Map<Object, Object>> queryKeys() {
        template.opsForValue().get("grade");
        return null;
    }
}