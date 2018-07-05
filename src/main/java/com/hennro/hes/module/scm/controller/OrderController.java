package com.hennro.hes.module.scm.controller;

import com.github.pagehelper.Page;
import com.hennro.hes.common.JsonHelper;
import com.hennro.hes.module.scm.entity.Order;
import com.hennro.hes.module.scm.service.OrderService;
import com.hennro.hes.module.sys.core.entity.HUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/scm/order")
public class OrderController {

    @Resource
    JsonHelper jsonHelper;

    @RequestMapping(value = {"list",""})
    public String list(Order order , HttpServletRequest request, HttpServletResponse response, Model model) {
        //System.out.println(principal.getLoginName());
        HUser user = (HUser)request.getAttribute("user");
        order.setLoginName(user.getFLoginName());
//        System.out.println("searchKey:"+order.getSearchKey()+" st:"+order.getStartDate()+" et:"+order.getEndDate());
//
//        List<Order> orderList = orderService.getOrderList(order);
//        String jsonData =  jsonHelper.string(orderList);
//        model.addAttribute("orderList", jsonData);
        return "scm/order/orderList";

    }
}
