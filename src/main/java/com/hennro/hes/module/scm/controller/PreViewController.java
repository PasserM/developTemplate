package com.hennro.hes.module.scm.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hennro.hes.common.JsonHelper;
import com.hennro.hes.common.base.Response;
import com.hennro.hes.module.scm.entity.Order;
import com.hennro.hes.module.scm.entity.OrderExport;
import com.hennro.hes.module.scm.service.OrderService;
import com.hennro.hes.module.sys.core.entity.HUser;
import com.hennro.hes.utils.LayUI;
import com.hennro.hes.utils.excel.ExcelException;
import com.hennro.hes.utils.excel.ExcelUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/scm/preview")
public class PreViewController {
    @Resource
    OrderService orderService;
    @Resource
    JsonHelper jsonHelper;

    @RequestMapping(value = {"list",""})
    public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println("===预发单列表===");
        return "scm/order/preViewList";
    }

    @RequestMapping(value = {"previewGrid"})
    @ResponseBody
    public Object previewGrid(HttpServletRequest request, HttpServletResponse response, Model model,
                              String searchKey, String dateRange, Integer page, Integer limit ,
                              OrderExport order){
        System.out.println("===绑定数据===" );
        Subject subject = SecurityUtils.getSubject();
        HUser user = (HUser) subject.getPrincipal();
        order.setTsuName(user.getFLoginName());
        order.setPageNum(page);
        order.setPageSize(limit);
        order.setSearchKey(searchKey);
        PageInfo pageInfo = orderService.findListByPage(order);
        return  jsonHelper.string(LayUI.data(pageInfo));
    }

    @RequestMapping(value = {"exportExcel"})
    public void exportExcel(OrderExport previewOrder,HttpServletRequest request,HttpServletResponse response, Model model){
        Subject subject = SecurityUtils.getSubject();
        HUser user = (HUser) subject.getPrincipal();
        previewOrder.setTsuName(user.getFLoginName());
        List<OrderExport> exportList = orderService.findExportList(previewOrder);
        if(exportList != null && exportList.size()>0){
            //System.out.println(exportList.size());

            //要导出的属性和列名对应关系
            LinkedHashMap<String,String> fieldMap = new LinkedHashMap<String,String>();
            fieldMap.put("billNo", "订单编号");
//				fieldMap.put("date", "订单日期");
//
//				fieldMap.put("tsuName", "供应商名称");
//				fieldMap.put("taxRate", "税率");
            fieldMap.put("shortNumber", "物料代码");
            fieldMap.put("ticName", "物料名称");
            fieldMap.put("qty", "订货数量");
            fieldMap.put("unit", "计量单位");
            fieldMap.put("price", "单价");
            fieldMap.put("currencyName", "币种");
//				fieldMap.put("note", "备注");
//				fieldMap.put("tsuNumber", "供应商代码");
//				fieldMap.put("planType", "计划类别");
//				fieldMap.put("amount", "不含税金额");
            fieldMap.put("invoiceNo", "发票号");
            fieldMap.put("inBeforeQty", "发货数量");
//				fieldMap.put("stockQty", "收料数量");
            fieldMap.put("allAmount", "金额");
            fieldMap.put("getDate", "预计到货日期");
//				fieldMap.put("batchNo", "卡板编号");
//				fieldMap.put("fromType", "来源");
//				fieldMap.put("fromID", "源计划分录号");
//				fieldMap.put("memo", "分录备注");
//				fieldMap.put("biller", "制单人");
//				fieldMap.put("billDate", "制单日期");
//				fieldMap.put("checker", "审核人");
//				fieldMap.put("checkDate", "审核日期");
            try {
                //直接导出文件到指定目录
                //OutputStream out = new FileOutputStream(new File("D:"+File.separator+"导出.xls"));
                //ExcelUtils.listToExcel(exportList,fieldMap,"统计导出",out);
                //浏览器下载
                ExcelUtils.listToExcel(exportList,fieldMap,"预发单",response);
            } catch (ExcelException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = {"importExcel"})
    @ResponseBody
    public String importExcel( HttpServletRequest request, HttpServletResponse response, Model model, MultipartFile file) {
        if(file.isEmpty()){
            return jsonHelper.string(Response.failure("文件不存在"));
        }

        try {
            InputStream is = file.getInputStream();
            String sheetName ="预发单";
            LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
            String[] uniqueFields = new String[]{};
            //EXCEL表头对应字段 列名>>字段名
            fieldMap.put("订单编号","billNo");
            fieldMap.put( "物料代码","shortNumber");
            fieldMap.put("物料名称","ticName");
            fieldMap.put("订货数量","qty");
            fieldMap.put("计量单位","unit");
            fieldMap.put("单价","price");
            fieldMap.put("币种","currencyName");
            fieldMap.put("发票号","invoiceNo");
            fieldMap.put("发货数量","inBeforeQty");
            fieldMap.put("金额","allAmount");
            fieldMap.put("预计到货日期","getDate");

            List<OrderExport> importList = ExcelUtils.excelToList(is,sheetName,OrderExport.class,fieldMap,null);
            List<OrderExport> fullPropertyList = orderService.getFullPropertyList(importList);
            orderService.updateOrderQty(fullPropertyList);

        } catch (ExcelException e) {
            e.printStackTrace();
            return jsonHelper.string(Response.failure(e.getMessage()));
        } catch (IOException e) {
            e.printStackTrace();
            return jsonHelper.string(Response.failure("文件读取出错"));
        }

        return jsonHelper.string(Response.success("导入成功"));
    }
}
