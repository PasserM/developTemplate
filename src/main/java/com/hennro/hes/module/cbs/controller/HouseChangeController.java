package com.hennro.hes.module.cbs.controller;

import com.hennro.hes.module.cbs.common.request.HouseChangeSearchRequest;
import com.hennro.hes.module.cbs.core.entity.HCbsBillHouseChange;
import com.hennro.hes.module.cbs.core.service.HouseChangeService;
import com.hennro.hes.module.sys.core.entity.HUser;
import com.hennro.hes.module.sys.core.service.HDepartmentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by tianjianping in 2018/6/27
 */
@Controller
@RequestMapping(value = "/CBS/HouseChange")
public class HouseChangeController {

    @Resource
    HDepartmentService departmentService;
    @Resource
    HouseChangeService houseChangeService;

    @RequestMapping(value = "HouseChangeMaintain")
    public String HouseChangeMaintain(Model model, HouseChangeSearchRequest request) {
        model.addAttribute("houseChangeList", houseChangeService.getHouseChangeList(request));
        model.addAttribute("departments",departmentService.getDepartmentList());
        model.addAttribute("request",request);
        return "cbs/house-change/house-change-maintain";
    }

    @RequestMapping(value = "HouseChangeOpen")
    public String HouseChangeOpen(Model model,String id) {
        Subject subject = SecurityUtils.getSubject();
        HUser user = (HUser) subject.getPrincipal();
        model.addAttribute("departments",departmentService.getDepartmentList());
        model.addAttribute("user",user);
        if(StringUtils.isEmpty(id)){
            model.addAttribute("houseChange",HCbsBillHouseChange.builder().fBillNumber(houseChangeService.getBillNumber(user.getFid()))
                    .fOperator(user.getFName()).fDate(new Date()).build());
        }else{
            model.addAttribute("houseChange",houseChangeService.getByHouseChangeId(id));
        }
        return "cbs/house-change/house-change-open";
    }

    @RequestMapping(value = "HouseChangeOpenChoose")
    public String HouseChangeOpenChoose(Model model) {
        return "cbs/house-change/house-change-open-choose";
    }
}
