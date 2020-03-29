package com.clt.service;

import com.clt.entity.User;
import com.clt.utils.ResultUtil;

import java.util.List;
import java.util.Map;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-02-25 19:05:15
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(String userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(String userId);

    List<User> queryAllByCondition(User user);

    ResultUtil<Map<String, Object>> sendVerification(User user, String operation);

    ResultUtil<Map<String, Object>> verificationCheck(User user, String operation);

    ResultUtil<Map<String, Object>> updatePWByOldPW(String oldPassword, String newPassword, String userId);

    ResultUtil<Map<String, Object>> updatePWByVerificationCode(String userId, String newPassword);
}