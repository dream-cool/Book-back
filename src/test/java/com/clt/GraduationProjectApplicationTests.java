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

import java.util.Date;
import java.util.List;

@SpringBootTest
public class GraduationProjectApplicationTests{

    


    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Test
    public void contextLoads() {

    }

    @Test
    public void test(){

    }



    @Test
    public void test2(){
    }


}
