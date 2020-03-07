package com.clt.service.impl;

import com.clt.constant.Const;
import com.clt.dao.PermissionDao;
import com.clt.entity.Permission;
import com.clt.entity.User;
import com.clt.dao.UserDao;
import com.clt.enums.UserEnum;
import com.clt.service.UserService;
import com.clt.utils.UUIDUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-02-25 19:05:15
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private PermissionDao permissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(String userId) {
        return this.userDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        beforeInsertUser(user);
        final Permission defaultPermission = new Permission();
        defaultPermission.setUserId(user.getUserId());
        if (UserEnum.USER_ROLE_ADMIN.getCode().equals(user.getRole())){
            defaultPermission.setAdmin(true);
        }
        permissionDao.insert(defaultPermission);
        this.userDao.insert(user);
        return user;
    }

    private void beforeInsertUser(User user) {
        if (user.getStuNo() == null || StringUtils.isEmpty(user.getStuNo())) {
            user.setStuNo(UUIDUtil.getUUID());
        }
        if (user.getStatus() == null || StringUtils.isEmpty(user.getStatus())) {
            user.setStatus(UserEnum.USER_STATUS_NORMAL.getCode());
        }
        if (user.getRole() == null || StringUtils.isEmpty(user.getRole())) {
            user.setRole(UserEnum.USER_ROLE_STUDENT.getCode());
        }
        if (user.getSex() == null || StringUtils.isEmpty(user.getSex())) {
            user.setSex(UserEnum.USER_SEX_MALE.getCode());
        }
        if (user.getCredit() == null || user.getCredit() < 0 || user.getCredit() > 100) {
            user.setCredit(60);
        }
        user.setUserId(user.getStuNo());
        user.setPassword(Const.INITIAL_PASSWORD);
        Object md5PassWord = new SimpleHash("MD5",user.getPassword(),
                user.getUserName(), 1024);
        user.setPassword(md5PassWord.toString());
        Date now = new Date();
        user.setRegisterTime(now);
        user.setCreateTime(now);
        user.setUpdateTime(now);
    }


    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String userId) {
        return this.userDao.deleteById(userId) > 0;
    }

    @Override
    public List<User> queryAllByCondition(User user) {
        List<User> users = this.userDao.queryAllByCondition(user).stream().map(userResult -> {
            if (userResult.getCredit() != null){
                userResult.setCreditStars(userResult.getCredit()/20);
            }
            return userResult;
        }).collect(Collectors.toList());
        return users;
    }

    @Override
    public User login(User user){
        return null;
    }
}