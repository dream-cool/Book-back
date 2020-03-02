package com.clt;

import com.clt.entity.Book;
import com.clt.entity.User;
import com.clt.service.BookService;
import com.clt.service.UserService;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GraduationProjectApplicationTests{

    


    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Test
    public void contextLoads() {
        User user = userService.queryById("2");
        Assert.notNull(user);
    }

    @Test
    public void test(){
        Book book = bookService.queryById("2");
        Assert.notNull(book);
    }


    @Timeout(1)
    @Test
    public void test1(){
        try {
            Thread.sleep(1111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
    }
}
