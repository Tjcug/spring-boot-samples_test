package com.basic.springboot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by dell-pc on 2016/5/10.
 */
@WebFilter(filterName = "errorFilter",urlPatterns = "/error",dispatcherTypes = DispatcherType.ERROR)
@Order(3)
public class ErrorFilter implements Filter{

    protected static final Logger log = LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("------------init----------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("您的输入错误！！！");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("------------destory----------");
    }
}
