package com.clt;

import com.clt.entity.User;
import com.clt.service.UserService;
import io.jsonwebtoken.lang.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

/**
 * @author clt
 * @create 2020/2/28 15:48
 */

@SpringBootTest
public class Test {


    @Mock
    private UserService userService;



    @BeforeTestClass
    public void init(){
        MockitoAnnotations.initMocks(UserService.class);
    }

    @org.junit.jupiter.api.Test
    public void test(){
        User user = userService.queryById("2");
        Assert.notNull(user);

    }
}
