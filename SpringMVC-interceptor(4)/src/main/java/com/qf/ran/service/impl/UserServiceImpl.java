package com.qf.ran.service.impl;

import com.qf.ran.entity.po.User;
import com.qf.ran.entity.vo.RespResult;
import com.qf.ran.service.UserService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/*
 * @author:Ran
 * @since:JDK 1.8
 * @Date:2023/7/3
 */
@Service
public class UserServiceImpl implements UserService {
    public RespResult login(HttpSession session, User user) {
        if("zs".equals(user.getUsername()) && "123".equals(user.getPassword())){
            session.setAttribute("id",1);
            return RespResult.respSuccess("登录成功",null);
        }
        return RespResult.respError("登录失败",null);
    }

    public RespResult logout(HttpSession session) {
        session.removeAttribute("id");
        return RespResult.respSuccess("退出登录成功",null);
    }

}
