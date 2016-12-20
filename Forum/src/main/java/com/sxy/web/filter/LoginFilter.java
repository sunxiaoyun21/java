package com.sxy.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
public class LoginFilter extends AbstracFilter {
    private List<String>  urlList=null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String validateUrl=filterConfig.getInitParameter("validateUrl");
        urlList= Arrays.asList(validateUrl.split(","));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        //获取用户想要访问的URL
        String url=request.getRequestURI();
        if(urlList!=null && urlList.contains(url)){
            if(request.getSession().getAttribute("curr")==null){
                response.sendRedirect("/login?redirect="+url);
            }else {
                filterChain.doFilter(request,response);
            }
        }else {
            filterChain.doFilter(request,response);
        }
    }
}
