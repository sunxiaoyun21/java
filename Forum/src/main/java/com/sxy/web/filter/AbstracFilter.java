package com.sxy.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/20.
 */
public abstract class AbstracFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public abstract void  doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException ;



    @Override
    public void destroy() {

    }
}
