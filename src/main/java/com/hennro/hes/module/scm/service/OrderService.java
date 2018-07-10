package com.hennro.hes.module.scm.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hennro.hes.module.scm.entity.Order;
import com.hennro.hes.module.scm.mapper.OrderMapper;
import com.hennro.hes.utils.DateUtils;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;

    public  List<Order> getOrderList(Order order){
       // PageHelper.startPage(pageNum,pageSize,"billDate desc");

        List<Order> list = orderMapper.findAll(order.getSupplyName(),order.getStartDate(),order.getEndDate(),
                                                order.getSearchKey(),order,order.getPageNum(),order.getPageSize());
        //PageInfo<Order> pageInfo = new PageInfo<>(list);
        return list;
    }
}
