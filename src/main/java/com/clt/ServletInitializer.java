package com.clt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author clt
 * @create 2020/5/26 21:06
 */
public class ServletInitializer extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(ServletInitializer.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        logger.info("starting-------------");
        return application.sources(GraduationProjectApplication.class);
    }
}
