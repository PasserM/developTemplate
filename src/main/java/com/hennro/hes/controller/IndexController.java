package com.hennro.hes.controller;

import com.hennro.hes.common.JsonHelper;
import com.hennro.hes.common.base.Response;
import com.hennro.hes.module.sys.core.entity.HUser;
import com.hennro.hes.module.sys.core.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by anxpp.com on 2018/6/23.
 */
@Slf4j
@Controller
@RequestMapping("/index")
public class IndexController {

    @Resource
    private MenuService menuService;

    @RequestMapping
    public String index(String type,Model model,HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        HUser user = (HUser) subject.getPrincipal();
        if(null == user){
            return "login";
        }
        model.addAttribute("user",user);
        if(type.equals("property")){
            model.addAttribute("menus",menuService.findByUserId(user.getFid()).get(0).getChildren().get(0).getChildren());
            return "index-property";
        }else{
            model.addAttribute("menus",menuService.findByUserId(user.getFid()).get(0).getChildren().get(1).getChildren());
            return "index-estate";
        }

    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Response loginPost(String username, String password, HttpSession session) {
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            HUser user=(HUser) subject.getPrincipal();
            session.setAttribute("user", user);
            return Response.success(null);
        } catch(Exception e) {
            return Response.failure(e.toString());
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        session.removeAttribute("user");
        return "login";
    }
}