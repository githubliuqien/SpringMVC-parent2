package com.qf.ran.exception;

import com.qf.ran.entity.vo.RespResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @author:Ran
 * @since:JDK 1.8
 * @Date:2023/7/3
 *
 *      全局异常处理类
 */
@ControllerAdvice
@ResponseBody
public class HandlerException{

    //获取所有的异常并进行处理
    @ExceptionHandler
    public RespResult handlerException(Exception e){
        //响应前端
        return RespResult.respError("出现异常",null);
    }

    //针对登录异常进行处理
    @ExceptionHandler(value=LoginException.class)
    public RespResult handlerException(LoginException e){
        return RespResult.respError(e.getMessage(),null);
    }
}
