package com.gzh.springbootshiro.config;

import com.gzh.springbootshiro.entity.User;
import com.gzh.springbootshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author GZH
 * @date 2021-12-10
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权doGetAuthorizationInfo");

        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        String permit = currentUser.getPermit();
        String role = "";
        if (StringUtils.hasLength(permit)) {
            role = permit.substring(0, permit.indexOf(":"));
        }
        //设置当前用户的权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission(permit);
        //设置角色
        info.addRole(role);

        return info;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证doGetAuthenticationInfo");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //从数据库拿到用户名、密码
        User currentUser = userService.getUserByName(token.getUsername());
        //没有这个用户
        if (currentUser == null) {
            //抛出异常 UnknownAccountException
            return null;
        }
        return new SimpleAuthenticationInfo(currentUser, currentUser.getPassword(), "");
    }
}
