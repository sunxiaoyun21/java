package com.sxy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/20.
 */
public class BaseAction extends ActionSupport{

   public Map<String,Object> getSession(){
       return ActionContext.getContext().getSession();
   }

   public HttpServletRequest getHttpRequest(){
       return ServletActionContext.getRequest();
   }

   public HttpServletResponse getHttpRespone(){
       return ServletActionContext.getResponse();
   }
   public ServletContext getServletContext(){
       return ServletActionContext.getServletContext();
   }

   public Map<String,Object> getApplication(){
       return ActionContext.getContext().getApplication();
   }

   public HttpSession getHttpSession(){
       return getHttpRequest().getSession();
   }
}
