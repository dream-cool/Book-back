package com.clt.controller;

import com.clt.entity.User;
import com.clt.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：clt
 * @Date ：Created in 19:18 2020/03/07
 */
@SpringBootTest
class UserControllerTest {

    @Autowired
    UserService userService;

    @Test
    void resetPassword() {

        userService.insert(new User());
    }
}