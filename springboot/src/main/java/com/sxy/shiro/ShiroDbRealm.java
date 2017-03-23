package com.sxy.shiro;


import com.sxy.pojo.Role;
import com.sxy.pojo.User;
import com.sxy.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ShiroDbRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 权限认证
     * @param principalCollection
     * @return
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user= (User) principalCollection.getPrimaryPrincipal();
        if(user !=null){
            //根据用户的roleID获取role
            Integer roliId=user.getRoleid();
            Role role=userService.findRoleByRoleId(roliId);

            //将用户的角色赋给info
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            info.addRole(role.getRolename());
            return info;
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
        User user=userService.findByUserName(userName);
        if(user !=null){
            return  new  SimpleAuthenticationInfo(user, user.getPassword(),getName());
        }else {
            throw new LockedAccountException("账号或密码错误");
        }

    }
}
