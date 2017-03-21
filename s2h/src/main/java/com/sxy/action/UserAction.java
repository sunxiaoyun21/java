package com.sxy.action;

import com.sxy.pojo.User;
import com.sxy.service.UserService;
import com.sxy.util.QueryParam;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/3/21.
 */
@Namespace("/user")
public class UserAction extends BaseAction {
    @Autowired
    private UserService userService;

    private User user;

    private Integer id;

    private List<User> userList;

    @Action("list")
    @Override
    public String execute() throws Exception {
        List<QueryParam> paramList=QueryParam.builderQueryparambyRequest(getHttpRequest());
        userList=userService.findByQueryParam(paramList);
        return SUCCESS;
    }

    @Action("new")
    public String newUser(){
      return SUCCESS;
    }

    @Action(value = "save", results={
        @Result(type = "redirectAction",params = {"actionName","list"})
    })
    public String save(){
        userService.save(user);
        return SUCCESS;
    }

    @Action(value = "del",results = {
            @Result(type = "redirectAction",params = {"actionName","list"})
    })
    public String del(){
        userService.del(id);
        return SUCCESS;
    }
    @Action("edit")
    public String edit(){
      user=userService.findById(id);
       return SUCCESS;
    }




    //get set


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
