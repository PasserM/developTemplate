package com.hennro.hes.config;

import com.hennro.hes.module.sys.core.entity.HUser;
import com.hennro.hes.module.sys.core.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * Created by tianjianping in 2018/6/23
 */
public class AuthRealm extends AuthorizingRealm {
    @Resource
    UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) authenticationToken;//获取用户输入的token
        String username = utoken.getUsername();
        HUser user = userService.getUserByLoginName(username);
        //账号不存在
        if(user==null){
            throw new UnknownAccountException("账号或密码不正确!");
        }
        return new SimpleAuthenticationInfo(user, user.getFPassWord(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
