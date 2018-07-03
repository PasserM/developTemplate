package com.hennro.hes.module.cbs.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hennro.hes.common.JsonHelper;
import com.hennro.hes.common.base.Response;
import com.hennro.hes.module.cbs.common.request.AddHouseChangeRequest;
import com.hennro.hes.module.cbs.common.request.HouseChangeSearchRequest;
import com.hennro.hes.module.cbs.core.domain.HouseTree;
import com.hennro.hes.module.cbs.core.entity.HCbsBaseHouse;
import com.hennro.hes.module.cbs.core.entity.HCbsBillHouseChange;
import com.hennro.hes.module.cbs.core.service.HouseChangeService;
import com.hennro.hes.module.cbs.core.service.HouseService;
import com.hennro.hes.module.sys.core.entity.HUser;
import com.hennro.hes.module.sys.core.service.HDepartmentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by tianjianping in 2018/6/27
 */
@RestController
@RequestMapping(value = "/CBS/House")
public class HouseChangeApi {

    @Resource
    private HouseService houseService;

    @Resource
    private JsonHelper jsonHelper;

    @RequestMapping("/houseByTree")
    public List<HouseTree> getHouseByTree(String key){
        return houseService.getHouseOfTree(key);
    }

    @RequestMapping("/houseByParentId")
    public List<HCbsBaseHouse> getChildDetailHouse(String parentId){
        return houseService.getChildDetailHouse(parentId);
    }

    @RequestMapping(value = "/addHouseChange", method = RequestMethod.POST)
    public Response<Boolean> addHouseChange(String housesJson){
        System.out.println(housesJson);
        List<AddHouseChangeRequest> requests = jsonHelper.list(housesJson, AddHouseChangeRequest.class);
        System.out.println(requests);
        return Response.success(true);
    }
}
