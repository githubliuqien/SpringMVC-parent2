package com.qf.ran.exception;

/*
 * @author:Ran
 * @since:JDK 1.8
 * @Date:2023/7/3
 *
 *      转账异常
 */
public class TransferAccountException extends RuntimeException {
    public TransferAccountException(String message) {
        //父类 RuntimeException 的有参构造方法
        //参数会成为异常说明
        super(message);
    }
}
