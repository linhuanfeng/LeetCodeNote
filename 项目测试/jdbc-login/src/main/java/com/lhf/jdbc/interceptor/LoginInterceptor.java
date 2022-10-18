package com.lhf.jdbc.interceptor;

import com.lhf.jdbc.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if("/".equals(request.getRequestURI())||"/login".equals(request.getRequestURI()))
            return true;
        if(user==null){
            response.getWriter().print("请先登录");
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
