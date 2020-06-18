package com.clt;

import com.clt.entity.User;
import com.clt.service.UserService;
import io.jsonwebtoken.lang.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author clt
 * @create 2020/2/28 15:48
 */

@SpringBootTest
public class Test {


    @Mock
    private UserService userService;



    public void init(){
        MockitoAnnotations.initMocks(UserService.class);
    }

    public void test(){
        User user = userService.queryById("2");

    }
}
