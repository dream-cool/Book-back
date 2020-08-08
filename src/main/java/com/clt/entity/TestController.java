package com.clt.entity;

import com.clt.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author clt
 * @create 2020/7/11 16:25
 */
@Controller
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/test")
    @ResponseBody
    public User test(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        return userDao.queryById("1");
    }

    @RequestMapping("/test1")
    @ResponseBody
    public List<String> test1(@RequestParam(value = "str") String str) throws InterruptedException {
        List<String> strList = new ArrayList<>();
        strList.add(str);
        logger.info(strList.toString());
        Thread.sleep(10000);
        return strList;
    }
}
