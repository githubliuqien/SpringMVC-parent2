package com.qf.ran.exception;

import com.qf.ran.entity.vo.RespResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Executors;

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


    //只针对转账异常进行处理
    @ExceptionHandler(value = TransferAccountException.class)
    public RespResult handlerException(TransferAccountException e){
        //e.getMessage()    --  获取异常的说明
        return RespResult.respError(e.getMessage(),null);
    }
}
