package com.hennro.hes.module.scm.mapper;

import com.hennro.hes.module.scm.entity.Order;
import com.hennro.hes.module.scm.entity.OrderDetails;
import com.hennro.hes.module.scm.entity.OrderExport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<Order> findAll(@Param("loginName")String loginName);
}
