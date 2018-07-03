package com.hennro.hes.config;

import com.hennro.hes.common.Des;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * Created by tianjianping in 2018/6/23
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String accountCredentials = String.valueOf(getCredentials(info)).toLowerCase();
        String pwd=String.valueOf((char[]) token.getCredentials());
        try
        {
            pwd=Des.encrypt(pwd).toLowerCase();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        boolean matches = equals(pwd, accountCredentials);
        if(!matches){
            throw new IncorrectCredentialsException("账号或密码不正确!");
        }
        return matches;
    }

}