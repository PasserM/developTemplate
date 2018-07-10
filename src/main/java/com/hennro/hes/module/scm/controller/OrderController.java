package com.hennro.hes.module.scm.controller;

import com.github.pagehelper.Page;
import com.hennro.hes.common.JsonHelper;
import com.hennro.hes.common.base.Response;
import com.hennro.hes.module.scm.entity.Order;
import com.hennro.hes.module.scm.service.OrderService;
import com.hennro.hes.module.sys.core.entity.HUser;
import com.hennro.hes.utils.DateUtils;
import com.hennro.hes.utils.LayUI;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.LayerUI;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/scm/order")
public class OrderController {

    @Resource
    OrderService orderService;
    @Resource
    JsonHelper jsonHelper;

    @RequestMapping(value = {"list",""})
    public String list( HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println("===订单列表===");
//        Subject subject = SecurityUtils.getSubject();
//        HUser user = (HUser) subject.getPrincipal();
//        if (null == user) {
//            return "login";
//        }

//        List<Order> orderList = orderService.getOrderList(user.getFLoginName());
//        model.addAttribute("orderList", orderList);
        return "scm/order/orderList2";

    }
    @RequestMapping(value = {"orderGrid"})
    @ResponseBody
    public Object orderGrid(HttpServletRequest request,Integer pageNum,Integer pageSize,Order order, HttpServletResponse response, Model model) {
        System.out.println("===绑定数据===" );
        Subject subject = SecurityUtils.getSubject();
        HUser user = (HUser) subject.getPrincipal();
        if(pageNum==null){
            pageNum=1;

        }
        if(pageSize==null){
            pageSize=20;
        }
        //如果没选时间，默认一周内

        /*数据较老暂时去掉默认一周
        if(null == order.getStartDate() && null == order.getEndDate()){
            Date now = new Date();
            order.setEndDate(now);
            order.setStartDate(DateUtils.addDate(now,0,0,-7,0,0,0,0));
        }
        */
        order.setPageNum(pageNum);
        order.setPageSize(pageSize);
        order.setSupplyName(user.getFLoginName());
        List<Order> orderList = orderService.getOrderList(order);
       // model.addAttribute("orderList", orderList);
        return  jsonHelper.string(LayUI.data(20,orderList));
    }
}
