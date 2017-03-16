package com.ztesoft.interceptor;

import com.ztesoft.config.Constants;
import com.ztesoft.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@Configuration
public class AuthInterceptor extends HandlerInterceptorAdapter {



    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.SESSION_NAME);
        HandlerMethod hm = (HandlerMethod) handler;
        if (user == null ) {
            String url = request.getRequestURL().toString();
            if (url.contains("/login")||url.lastIndexOf("/")==(url.length()-1)) {
                return true;
            } else {
                response.sendRedirect(request.getContextPath() + "/");
                return false;
            }

        }
        return super.preHandle(request, response, handler);
    }

}