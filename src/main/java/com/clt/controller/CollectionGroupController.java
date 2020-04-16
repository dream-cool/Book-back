package com.clt.controller;

import com.clt.annotation.Log;
import com.clt.entity.CollectionGroup;
import com.clt.enums.LogOperationTypeEnum;
import com.clt.service.CollectionGroupService;
import com.clt.utils.ResultUtil;
import com.clt.utils.UUIDUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (CollectionGroup)表控制层
 *
 * @author makejava
 * @since 2020-03-16 20:36:51
 */
@RestController
@RequestMapping("collectionGroup")
public class CollectionGroupController {
    /**
     * 服务对象
     */
    @Resource
    private CollectionGroupService collectionGroupService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CollectionGroup selectOne(String id) {
        return this.collectionGroupService.queryById(id);
    }

    /**
     * 通过userId查询单条数据
     *
     * @param userId 主键
     * @return 单条数据
     */
    @GetMapping("/user/{userId}")
    public ResultUtil<List<CollectionGroup>> queryByUserId(@PathVariable String userId) {
        final List<CollectionGroup> collectionGroupInfo = this.collectionGroupService.queryByUserId(userId);
        if (collectionGroupInfo != null && !collectionGroupInfo.isEmpty()) {
            return ResultUtil.success(collectionGroupInfo, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }

    /**
     * 新增单条数据
     *
     * @param
     * @return 单条数据
     */
    @PostMapping("")
    @ApiOperation("新增用户收藏分组")
    @Log(value = "新增用户收藏分组", method = LogOperationTypeEnum.INSERT)
    public ResultUtil<CollectionGroup> insert(@RequestBody CollectionGroup collectionGroup) {
        final List<CollectionGroup> result = collectionGroupService.queryByName(collectionGroup.getName());
        if (result == null || result.isEmpty()){
            collectionGroup.setCollectionGroupId(UUIDUtil.getUUID());
            collectionGroup.setCreateTime(new Date());
            return ResultUtil.success(this.collectionGroupService.insert(collectionGroup), "分组新增成功");
        }
        return ResultUtil.failed("已存在相同名称分组");
    }

}