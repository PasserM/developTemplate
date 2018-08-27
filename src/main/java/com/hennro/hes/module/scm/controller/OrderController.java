package com.hennro.hes.module.scm.controller;

import com.github.pagehelper.PageInfo;
import com.hennro.hes.common.JsonHelper;
import com.hennro.hes.module.scm.entity.Order;
import com.hennro.hes.module.scm.entity.OrderDetails;
import com.hennro.hes.module.scm.service.OrderService;
import com.hennro.hes.module.sys.core.entity.HUser;
import com.hennro.hes.utils.LayUI;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/scm/order")
public class OrderController {

    @Resource
    OrderService orderService;
    @Resource
    JsonHelper jsonHelper;

    @RequestMapping(value = {"list"})
    public String list( HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println("===订单列表===");
//        Subject subject = SecurityUtils.getSubject();
//        HUser user = (HUser) subject.getPrincipal();
//        if (null == user) {
//            return "login";
//        }

//        List<Order> orderList = orderService.getOrderList(user.getFLoginName());
//        model.addAttribute("orderList", orderList);
        return "scm/order/orderList";

    }
    @RequestMapping(value = {"orderGrid"})
    @ResponseBody
    public Object orderGrid(HttpServletRequest request,Integer page,Integer limit ,Order order, HttpServletResponse response, Model model) {
        System.out.println("===绑定数据===" );
        Subject subject = SecurityUtils.getSubject();
        HUser user = (HUser) subject.getPrincipal();
        //如果没选时间，默认一周内

        /*数据较老暂时去掉默认一周
        if(null == order.getStartDate() && null == order.getEndDate()){
            Date now = new Date();
            order.setEndDate(now);
            order.setStartDate(DateUtils.addDate(now,0,0,-7,0,0,0,0));
        }
        */
        order.setPageNum(page);
        order.setPageSize(limit);
        order.setSupplyName(user.getFLoginName());

        PageInfo pageInfo = orderService.getOrderList(order);
        //List<Order> orderList = orderService.getOrderList(order);
       // model.addAttribute("orderList", orderList);
        return  jsonHelper.string(LayUI.data(pageInfo));
    }

    @RequestMapping(value = {"details"})
    public String details( String id,HttpServletRequest request, HttpServletResponse response, Model model) {
        Order order = orderService.getById(id);

        if("未读".equals(order.getReadFlag())){
            orderService.updateStatus(order, "1");
            order = orderService.getById(id);
        }

        List<OrderDetails> detailsList = orderService.getOrderDetails(id);
        model.addAttribute("order", order);
        model.addAttribute("detailsList", detailsList);

        return "scm/order/orderDetails";
    }

    @RequestMapping(value = {"checkOrder"})
    public String checkOrder( String id,HttpServletRequest request, HttpServletResponse response, Model model) {
        //更新订单确认状态
        System.out.println("=确认订单 =");
        Order order = orderService.getById(id);
        orderService.updateStatus(order,"2");
        return "redirect:/scm/order/details?id="+id;
    }

}
