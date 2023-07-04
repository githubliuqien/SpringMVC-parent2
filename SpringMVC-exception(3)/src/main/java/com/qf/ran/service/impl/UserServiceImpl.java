package com.qf.ran.service.impl;

import com.qf.ran.entity.vo.RespResult;
import com.qf.ran.exception.TransferAccountException;
import com.qf.ran.service.UserService;
import org.springframework.stereotype.Service;

/*
 * @author:Ran
 * @since:JDK 1.8
 * @Date:2023/7/3
 */
@Service
public class UserServiceImpl implements UserService {
    public RespResult transferAccount() {
        RespResult respResult = null;
        /*if(respResult == null){
            throw new NullPointerException();
        }*/
        if(respResult == null){
            throw new TransferAccountException("转账异常");
        }

        return respResult;
    }
}
