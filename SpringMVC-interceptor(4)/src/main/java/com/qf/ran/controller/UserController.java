package com.qf.ran.controller;

import com.qf.ran.entity.po.User;
import com.qf.ran.entity.vo.RespResult;
import com.qf.ran.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/*
 * @author:Ran
 * @since:JDK 1.8
 * @Date:2023/7/3
 */
@Api(tags="用户模块")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("/转账接口")
    @PutMapping("/transferAccount")
    public RespResult transferAccount(){
        return RespResult.respSuccess("转账成功",null);
    }

    @ApiOperation("/登录接口")
    @PostMapping("/login")
    public RespResult login(HttpSession session, User user){
        return userService.login(session,user);
    }

    @ApiOperation("/退出登录接口")
    @PostMapping("/logout")
    public RespResult logout(HttpSession session){
        return userService.logout(session);
    }
}
