package com.clt.controller;

import com.clt.annotation.Log;
import com.clt.constant.Const;
import com.clt.entity.User;
import com.clt.entity.UserClass;
import com.clt.enums.LogOperationTypeEnum;
import com.clt.service.UserService;
import com.clt.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
     * 根据用户名和邮箱查询用户
     *
     * @param userName 用户名
     * @param email 邮箱
     * @return 单条数据
     */
    @GetMapping("/queryUser/{userName}/{email}")
    @ApiOperation("根据用户名和邮箱查询用户")
    @Log(value = "根据用户名和邮箱查询用户数据", method = LogOperationTypeEnum.QUERY)
    public ResultUtil<User> queryByUserNameAndEmail(
            @ApiParam("userName") @PathVariable String userName,
            @ApiParam("email") @PathVariable String email) {
        User condiction = new User();
        condiction.setUserName(userName);
        condiction.setEmail(email);
        final List<User> users = userService.queryAllByCondition(condiction);
        if (users != null && users.size() == 1) {
            return ResultUtil.success(users.get(0));
        } else {
            return ResultUtil.failed("没有找到对应信息");
        }
    }

    /**
     * 根据邮箱查询用户
     *
     * @param email 邮箱
     * @return 单条数据
     */
    @GetMapping("/queryUserByEmail/{email}")
    @ApiOperation("根据邮箱查询用户")
    @Log(value = "根据邮箱查询用户数据", method = LogOperationTypeEnum.QUERY)
    public ResultUtil<User> queryUserByEmail(
            @ApiParam("email") @PathVariable String email) {
        User condiction = new User();
        condiction.setEmail(email);
        final List<User> users = userService.queryAllByCondition(condiction);
        if (users == null || users.size() == 0) {
            return ResultUtil.success(null);
        } else {
            return ResultUtil.failed("该邮箱已被绑定");
        }
    }

    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名
     * @return 单条数据
     */
    @GetMapping("/queryUserByUserName/{userName}")
    @ApiOperation("根据邮箱查询用户")
    @Log(value = "根据邮箱查询用户数据", method = LogOperationTypeEnum.QUERY)
    public ResultUtil<User> queryUserByUserName(
            @ApiParam("userName") @PathVariable String userName) {
        final User user = userService.queryByUserName(userName);
        if (user != null) {
            return ResultUtil.success(user);
        } else {
            return ResultUtil.failed("没有找到对应用户");
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
    @Log(value = "分页查询用户数据", method = LogOperationTypeEnum.QUERY)
    public ResultUtil<PageInfo<User>> selectAllByLimit(
            @ApiParam("页码") @RequestParam(required = false) Integer pageNum,
            @ApiParam("每页大小") @RequestParam(required = false) Integer pageSize,
            @RequestBody(required = false) User user
    ) {
        pageNum = (pageNum == null || pageNum < 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize < 0) ? 10 : pageSize;
        Page page =PageHelper.startPage(pageNum,pageSize);
        List<User> users = this.userService.queryAllByCondition(user);
        PageInfo<User> pageInfo = new PageInfo<>(page);
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
    @Log(value = "新增用户数据", method = LogOperationTypeEnum.INSERT)
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
        if (user.getUserName() != null){
            User condition = new User();
            condition.setUserName(user.getUserName());
            List<User> queryUser = userService.queryAllByCondition(condition);
            if (queryUser != null && queryUser.size() > 0) {
                return ResultUtil.failed("用户名已存在");
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
    @Log(value = "修改用户数据", method = LogOperationTypeEnum.UPDATE)
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
    @Log(value = "删除用户数据", method = LogOperationTypeEnum.DELETE)
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
    @ApiOperation("批量删除用户")
    @Log(value = "根据id数组批量删除用户数据", method = LogOperationTypeEnum.DELETE)
    public ResultUtil<Boolean> deleteBatch(@ApiParam(value = "id数组") @RequestParam(value = "ids") List<String> ids) {
        logger.info(ids.toString());
        ids.stream().forEach(id -> {
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
    @Log(value = "根据id重置用户密码", method = LogOperationTypeEnum.UPDATE)
    public ResultUtil<Boolean> resetPassword(@PathVariable String userId) {
        final User user = this.userService.queryById(userId);
        if (user == null) {
            return ResultUtil.failed("没有找到对应用户");
        }
        user.setPassword(Const.INITIAL_PASSWORD);
        Object md5PassWord = new SimpleHash("MD5", user.getPassword(),
                user.getUserName(), 1024);
        user.setPassword(md5PassWord.toString());
        final User update = this.userService.update(user);
        if (update != null) {
            return ResultUtil.success(true, "重置成功");
        } else {
            return ResultUtil.success(false, "重置失败");
        }
    }


    @GetMapping("/verificationCheck")
    @ApiModelProperty("登录接口")
    public ResultUtil<Map<String, Object>> verificationCheck(User user,
         @ApiParam("操作") @RequestParam(required = false) String operation) {
        return userService.verificationCheck(user, operation);
    }


    @GetMapping("/sendVerificationLogin")
    @ResponseBody
    public ResultUtil<Map<String, Object>> sendVerification(User user,
            @ApiParam("操作") @RequestParam(required = false) String operation) {
        if (user.getEmail() == null){
            return ResultUtil.failed("用户邮箱为空");
        }
        return userService.sendVerification(user, operation);
    }

    @GetMapping("/updatePWByOldPW")
    @ResponseBody
    public ResultUtil<Map<String, Object>> updatePWByOldPW(
            @ApiParam("oldPassword") @RequestParam("oldPassword") String oldPassword,
            @ApiParam("newPassword") @RequestParam("newPassword") String newPassword,
            @ApiParam("userId") @RequestParam("userId") String userId
    ) {
        return userService.updatePWByOldPW(oldPassword, newPassword, userId);
    }

    @GetMapping("/updatePWByVerificationCode")
    @ResponseBody
    public ResultUtil<Map<String, Object>> updatePWByVerificationCode(
            @ApiParam("newPassword") @RequestParam("newPassword") String newPassword,
            @ApiParam("userId") @RequestParam("userId") String userId
    ) {
        return this.userService.updatePWByVerificationCode(userId, newPassword);
    }

}