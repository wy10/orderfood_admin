package com.rimi.cs.intercept;


import com.rimi.cs.utils.Constant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*登录拦截器*/
public class LoginIntercept extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        Object user = request.getSession().getAttribute(Constant.USER_INFO);
        if (user != null) {
            return true;
        }else{
            response.sendRedirect("/");
            return false;
        }
    }

}
