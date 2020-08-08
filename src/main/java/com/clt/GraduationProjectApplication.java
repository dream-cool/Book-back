package com.clt;

import com.clt.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Mrchen
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableRabbit
public class GraduationProjectApplication {

    private static final Logger logger = LoggerFactory.getLogger(GraduationProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GraduationProjectApplication.class, args);
        logger.info("容器初始化完成");
//        UserService  userService = SpringUtils.getBean("userService", UserService.class);
//        userService.queryById("1");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handle(Throwable e) {
        e.printStackTrace();
        return ResultUtil.failed(e.getMessage());
    }

}
