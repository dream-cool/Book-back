package com.clt.config;

import com.clt.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author clt
 * @create 2020/6/4 15:19
 */
@ControllerAdvice()
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultUtil exceptionHandler(Exception e) {
        e.printStackTrace();
        return ResultUtil.failed(e.getMessage());
    }
}
