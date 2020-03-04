package com.clt.controller;

import com.clt.constant.Const;
import com.clt.entity.User;
import com.clt.service.UserService;
import com.clt.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-02-25 19:05:15
 */
@RestController
@RequestMapping("user")
@Api("用户实体")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过主键查询单条数据")
    public ResultUtil<User> selectOne(
            @ApiParam("id")
            @PathVariable String id) {
        User User = this.userService.queryById(id);
        if (User != null) {
            return ResultUtil.success(User);
        } else {
            return ResultUtil.failed("没有找到对应信息");
        }
    }

    /**
     * 分页查询数据
     *
     * @param pageNum  起始
     * @param pageSize 条数
     * @return 多条数据
     */
    @PostMapping("/all")
    @ApiOperation("分页查询数据")
    public ResultUtil<PageInfo<User>> selectAllByLimit(
            @ApiParam("页码") @RequestParam(required = false) Integer pageNum,
            @ApiParam("每页大小") @RequestParam(required = false) Integer pageSize,
            @RequestBody(required = false) User user
    ) {
        pageNum = (pageNum == null || pageNum < 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize < 0) ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = this.userService.queryAllByCondition(user);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        if (pageInfo != null) {
            return ResultUtil.success(pageInfo, "查询成功");
        } else {
            return ResultUtil.failed("查询失败");
        }
    }


    /**
     * 通过实体数据新增单条数据
     *
     * @param user 用户实体
     * @return 新增的数据
     */
    @PostMapping("")
    @ApiOperation("新增单条数据")
    public ResultUtil<User> insert(@RequestBody User user) {
        if (user == null) {
            return ResultUtil.failed("用户信息为空");
        }
        if (user.getStuNo() != null) {
            User queryUser = this.userService.queryById(user.getStuNo());
            if (queryUser != null) {
                return ResultUtil.failed("用户编号已存在");
            }
        }
        User insertUser = this.userService.insert(user);
        if (insertUser != null) {
            return ResultUtil.success(insertUser, "新增成功");
        } else {
            return ResultUtil.failed("新增失败");
        }
    }

    /**
     * 通过实体数据更新单条数据
     *
     * @param user 信息实体
     * @return 更新的数据
     */
    @PutMapping("")
    @ApiOperation("更新单条数据")
    public ResultUtil<User> update(@RequestBody User user) {
        if (this.userService.queryById(user.getUserId()) == null) {
            return ResultUtil.failed("修改失败，没有找到对应信息");
        }
        User updateUser = this.userService.update(user);
        if (updateUser != null) {
            return ResultUtil.success(updateUser, "修改成功");
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
        if (this.userService.queryById(id) == null) {
            return ResultUtil.failed("删除失败，没有找到对应信息");
        }
        boolean flag = this.userService.deleteById(id);
        if (flag) {
            return ResultUtil.success(true, "删除成功");
        } else {
            return ResultUtil.failed("删除失败");
        }
    }

    /**
     * 通过主键批量删除数据
     *
     * @param ids id数组
     * @return 删除结果
     */
    @GetMapping("/delete/batch")
    @ApiOperation("批量删除书籍数据")
    public ResultUtil<Boolean> deleteBatch(@ApiParam(value = "id数组") @RequestParam(value = "ids") List<String> ids) {
        logger.info(ids.toString());
        ids.stream().forEach(id ->{
            delete(id);
        });
        return ResultUtil.success(true, "删除成功");
    }

    /**
     * 重置用户密码
     *
     * @param userId 用户id
     * @return 重置结果
     */
    @PutMapping("/resetPassword/{userId}")
    @ApiOperation("重置密码")
    public ResultUtil<Boolean> resetPassword(@PathVariable String userId){
        final User user = this.userService.queryById(userId);
        if (user == null){
            return ResultUtil.failed("没有找到对应用户");
        }
        user.setPassword(Const.INITIAL_PASSWORD);
        final User update = this.userService.update(user);
        if (update != null){
            return ResultUtil.success(true,"重置成功" );
        } else {
            return ResultUtil.success(false,"重置失败" );
        }
    }

}