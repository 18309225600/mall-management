package com.lhf.mall.management.config;

import com.lhf.mall.management.domain.std.StdException;
import com.lhf.mall.management.domain.std.StdResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/3/9
 **/
@Slf4j
@RestControllerAdvice
public class StdExceptionHandler {
    @Autowired
    private HttpServletRequest request;

    @ModelAttribute
    public void preHandler(){
        log.info("请求路径：{}",request.getRequestURL());
    }

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(StdException.class)
    public StdResponse handleRenException(StdException e){
        return StdResponse.newErrorStdResponse(e.getMsg(),e.getCode());
    }


    @ExceptionHandler(Exception.class)
    public StdResponse handleException(Exception ex){
        log.error("error:{}",ex);
        return StdResponse.newErrorStdResponse();
    }
}
