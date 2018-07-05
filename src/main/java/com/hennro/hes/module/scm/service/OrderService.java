package com.hennro.hes.module.scm.service;

import com.hennro.hes.module.scm.entity.Order;
import com.hennro.hes.module.scm.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;

}
