package com.basic.springboot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dell-pc on 2016/5/10.
 */
@WebFilter(filterName = "userFilter",urlPatterns = "/send_success")
public class UserFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse= (HttpServletResponse) servletResponse;
        if(httpServletRequest.getSession().getAttribute("username")!=null){
            if(httpServletRequest.getRequestURL().indexOf("login")!=-1){
                httpServletResponse.sendRedirect("/send_success");
                return;
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            httpServletResponse.sendRedirect("/send_login");
        }
    }

    @Override
    public void destroy() {

    }
}
