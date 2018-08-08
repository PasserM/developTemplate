package com.hennro.hes.module.scm.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hennro.hes.module.scm.entity.Order;
import com.hennro.hes.module.scm.entity.OrderDetails;
import com.hennro.hes.module.scm.entity.OrderExport;
import com.hennro.hes.module.scm.entity.Preorder;
import com.hennro.hes.module.scm.mapper.OrderMapper;
import com.hennro.hes.utils.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;

    public  PageInfo<Order> getOrderList(Order order){

        if(null ==order.getPageNum() ){
            order.setPageNum(1);
        }
        if(null == order.getPageSize()){
            order.setPageSize(20);
        }
        PageHelper.startPage(order.getPageNum(),order.getPageSize());
//        List<Order> list = orderMapper.findAll(order.getSupplyName(),order.getStartDate(),order.getEndDate(),
//                                                order.getSearchKey(),order,order.getPageNum(),order.getPageSize());
        List<Order> list = orderMapper.findAll(order);
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        pageInfo.setSize(list.size());

        return pageInfo;
        //return list;
    }

    public Order getById(String id) {
        return orderMapper.getById(id);
    }

    public void updateStatus(Order order, String s) {
        orderMapper.updateStatus(order.getId()+"",s);
    }

    public List<OrderDetails> getOrderDetails(String id) {
        return  orderMapper.getOrderDetails(id);
    }

    public PageInfo<OrderExport> findListByPage(OrderExport previewOrder) {
        if(null ==previewOrder.getPageNum() ){
            previewOrder.setPageNum(1);
        }
        if(null == previewOrder.getPageSize()){
            previewOrder.setPageSize(20);
        }
        PageHelper.startPage(previewOrder.getPageNum(),previewOrder.getPageSize());
        List<OrderExport> list = orderMapper.findExportList(previewOrder);
        PageInfo<OrderExport> pageInfo = new PageInfo<>(list);
        pageInfo.setSize(list.size());
        pageInfo.setPageNum(previewOrder.getPageNum());
        return pageInfo;
    }
    public List findExportList(OrderExport previewOrder) {
        List<OrderExport> list = orderMapper.findExportList(previewOrder);
        return list;
    }

    public void updateOrderQty(List<OrderExport> exportList) {

        for (OrderExport orderExport : exportList){
            //如果发票号存在，则更新预发单表体，否则新增
            if(checkInvoiceExist(orderExport.getInvoiceNo())){
                
            }else{
                Preorder preorder = new Preorder();
                preorder.setSupplyName(orderExport.getTsuName());
                preorder.setBillDate(orderExport.getBillDate());
                preorder.setBiller(orderExport.getBiller());
                preorder.setBillNo(orderExport.getBillNo());
                preorder.setCurrencyName(orderExport.getCurrencyName());
                preorder.setCheckDate(orderExport.getCheckDate());
                preorder.setChecker(orderExport.getChecker());
                preorder.setTaxRate(orderExport.getTaxRate());
            }
        }

        //更新订单中的数量
        orderMapper.updateOrderQty(exportList);

    }

    public List<OrderExport> getFullPropertyList(List<OrderExport> importList) {
        List<OrderExport> fullPropertyList = new ArrayList<OrderExport>();
            for (OrderExport oe : importList){
                OrderExport o = orderMapper.getByOrder(oe);
                o.setInBeforeQty(oe.getInBeforeQty());
                o.setPrice(oe.getPrice());
                o.setInvoiceNo(oe.getInvoiceNo());
                fullPropertyList.add(o);
            }
        return fullPropertyList;
    }

    boolean checkInvoiceExist(String invoiceNo){
        if(orderMapper.checkInvoiceExist(invoiceNo)>0){
            return  true;
        }
        return  false;
    }


}
