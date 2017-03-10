package com.sxy.shiro;

import com.sxy.mapper.RoleMapper;
import com.sxy.mapper.UserMapper;
import com.sxy.pojo.Role;
import com.sxy.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 */
@Component
public class ShiroDbRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       //返回当前登陆的对象
        User user= (User) principalCollection.getPrimaryPrincipal();
        //获取当前对象所拥有的角色
        List<Role> roleList=roleMapper.findByUserId(user.getId());
        if(!roleList.isEmpty()){
            SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
            for(Role role:roleList){
                simpleAuthorizationInfo.addRole(role.getRoleName());
            }
            return simpleAuthorizationInfo;
        }

        return null;
    }

    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
            String userName=usernamePasswordToken.getUsername();
            User user=userMapper.findUserByName(userName);
            if(user!=null){
                return  new SimpleAuthenticationInfo(user,user.getPassword(),getName());
            }
        return null;
    }
}
