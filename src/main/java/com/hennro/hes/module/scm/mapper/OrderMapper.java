package com.hennro.hes.module.scm.mapper;

import com.hennro.hes.module.scm.entity.Order;
import com.hennro.hes.module.scm.entity.OrderDetails;
import com.hennro.hes.module.scm.entity.OrderExport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {
    List<Order> findAll(@Param("supplyName") String supplyName, @Param("startDate") Date startDate, @Param("endDate") Date endDate,
                        @Param("searchKey") String searchKey, Order order, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
//    List<Order> findAll(Order order,@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
}
