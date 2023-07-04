package com.qf.ran.service;

import com.qf.ran.entity.po.User;
import com.qf.ran.entity.vo.RespResult;

import javax.servlet.http.HttpSession;

/*
 * @author:Ran
 * @since:JDK 1.8
 * @Date:2023/7/3
 */
public interface UserService {

    RespResult login(HttpSession session, User user);
    RespResult logout(HttpSession session);
}
