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
 * Created by Administrator on 2017/3/17.
 */
public class HelloAction extends ActionSupport
        implements SessionAware,ServletRequestAware,ServletResponseAware,ApplicationAware,ServletContextAware{


    private String code;

    private Map<String,Object> session;

    public String execute(){
        //Map<String,Object> session= ActionContext.getContext().getSession();
        //session.put("name","k1");
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        session.setAttribute("name","k1");
        return SUCCESS;
    }

    public String add(){
        code="1234";
        System.out.println("add...................");
        return "success";
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


    //get set

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {

    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {

    }

    @Override
    public void setApplication(Map<String, Object> map) {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {

    }
}
