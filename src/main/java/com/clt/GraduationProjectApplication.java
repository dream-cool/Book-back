package com.clt;

import com.clt.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class GraduationProjectApplication {

    private static final Logger logger = LoggerFactory.getLogger(GraduationProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GraduationProjectApplication.class, args);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handle(Throwable e) {
        e.printStackTrace();
        return ResultUtil.failed(e.getMessage());
    }

}
