package com.clt.controller;

import com.clt.entity.Permission;
import com.clt.service.PermissionService;
import com.clt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Permission)表控制层
 *
 * @author makejava
 * @since 2020-02-26 09:39:15
 */
@RestController
@RequestMapping("permission")
@Api("权限实体接口")
public class PermissionController {

    private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);
    /**
     * 服务对象
     */
    @Resource
    private PermissionService permissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过主键查询单条数据")
    public ResultUtil<Permission> selectOne(
            @ApiParam("id")
            @PathVariable String id) {
        Permission Permission = this.permissionService.queryById(id);
        if (Permission != null) {
            return ResultUtil.success(Permission);
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
    public ResultUtil<List<Permission>> selectAllByLimit(
            @ApiParam("起始") Integer offset,
            @ApiParam("条数") Integer limit
    ) {
        offset = (offset == null || offset < 0) ? 0 : offset;
        limit = (limit == null || limit < 0) ? 10 : limit;
        List<Permission> permissions = this.permissionService.queryAllByLimit(offset, limit);
        if (permissions != null) {
            return ResultUtil.success(permissions, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    /**
     * 通过实体数据新增单条数据
     *
     * @param permission 权限实体
     * @return 新增的数据
     */
    @PostMapping("")
    @ApiOperation("新增单条数据")
    public ResultUtil<Permission> insert(@RequestBody Permission permission) {
        Permission insertPermission = this.permissionService.insert(permission);
        if (insertPermission != null) {
            return ResultUtil.success(insertPermission, "新增成功");
        } else {
            return ResultUtil.failed("新增失败");
        }
    }

    /**
     * 通过实体数据更新单条数据
     *
     * @param permission 权限实体
     * @return 更新的数据
     */
    @PutMapping("")
    @ApiOperation("更新单条数据")
    public ResultUtil<Permission> update(@RequestBody Permission permission) {
        if (this.permissionService.queryById(permission.getUserId()) == null){
            return ResultUtil.failed("修改失败，没有找到对应信息");
        }
        Permission updatePermission = this.permissionService.update(permission);
        if (updatePermission != null) {
            return ResultUtil.success(updatePermission, "修改成功");
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
    @ApiOperation("删除单条数据")
    public ResultUtil<Boolean> delete(@PathVariable String id) {
        if (this.permissionService.queryById(id) == null){
            return ResultUtil.failed("修改失败，没有找到对应信息");
        }
        boolean flag = this.permissionService.deleteById(id);
        if (flag) {
            return ResultUtil.success(true, "删除成功");
        } else {
            return ResultUtil.failed("删除失败");
        }
    }

}