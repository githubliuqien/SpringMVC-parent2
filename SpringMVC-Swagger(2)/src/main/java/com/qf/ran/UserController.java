package com.qf.ran;

import com.qf.ran.entity.po.User;
import com.qf.ran.entity.vo.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author:Ran
 * @since:JDK 1.8
 * @Date:2023/7/3
 */
@Api(tags="用户模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("登录接口")
    @RequestMapping("/login")
    public RespResult login(User user){
        if("iKun".equals(user.getUsername()) && "123".equals(user.getPassword())){
            return RespResult.respSuccess("登录成功",null);
        }
        return RespResult.respError("登录失败",null);
    }

    @ApiOperation("注册接口")
    @PostMapping("/register")
    public RespResult register(User user){
        return RespResult.respSuccess("注册成功",null);
    }
}
