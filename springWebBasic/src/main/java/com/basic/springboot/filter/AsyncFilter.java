package com.basic.springboot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dell-pc on 2016/5/10.
 */

@WebFilter(filterName = "asyncFilter",asyncSupported = true,urlPatterns = "/asyncfilter",dispatcherTypes = DispatcherType.ASYNC)
public class AsyncFilter implements Filter {

    protected static final Logger log = LoggerFactory.getLogger(AsyncFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("------------init----------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("------------start Filter----------");
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse= (HttpServletResponse) servletResponse;
        httpServletResponse.sendRedirect("/async");
        //filterChain.doFilter(servletRequest,servletResponse);
        log.info("------------end Filter----------");
    }

    @Override
    public void destroy() {
        log.info("------------destory----------");
    }
}
