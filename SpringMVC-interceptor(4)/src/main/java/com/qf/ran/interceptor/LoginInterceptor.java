package com.qf.ran.interceptor;

import com.qf.ran.exception.LoginException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @author:Ran
 * @since:JDK 1.8
 * @Date:2023/7/3
 *      登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    //true代表放行，false代表拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Integer id = (Integer)request.getSession().getAttribute("id");
        if(id == null){
            throw new LoginException("用户未登录");
        }
        return true;
    }
}
