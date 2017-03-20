package com.sxy.action.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/20.
 */
public class LoginInterceptor extends AbstractInterceptor{

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionProxy proxy=actionInvocation.getProxy();
        String actionName=proxy.getActionName();
        String spaceName=proxy.getNamespace();

        if("/".equals(spaceName) && "index".equals(actionName) || "login".equals(actionName)){
            return actionInvocation.invoke();
        }else {
            Map<String,Object> map= ActionContext.getContext().getSession();
            if(map.get("Current_user") == null){
                return Action.LOGIN;
            }else {
                return actionInvocation.invoke();
            }

        }

    }
}
