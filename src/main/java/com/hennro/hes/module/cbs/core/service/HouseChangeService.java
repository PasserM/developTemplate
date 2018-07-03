package com.hennro.hes.module.cbs.core.service;

import com.hennro.hes.module.cbs.common.request.AddHouseChangeRequest;
import com.hennro.hes.module.cbs.common.request.HouseChangeSearchRequest;
import com.hennro.hes.module.cbs.core.entity.HCbsBillHouseChange;
import com.hennro.hes.module.cbs.core.mapper.HHouseChangeMapper;
import com.hennro.hes.module.sys.core.entity.HUser;
import com.hennro.hes.utils.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by tianjianping in 2018/6/27
 */
@Service
public class HouseChangeService {

    @Resource
    HHouseChangeMapper houseChangeMapper;

    public List<HCbsBillHouseChange> getHouseChangeList(HouseChangeSearchRequest request){
        return houseChangeMapper.getHouseChangeList(request);
    }

    public HCbsBillHouseChange getByHouseChangeId(String id){
        return houseChangeMapper.getByHouseChangeId(id);
    }

    public String getBillNumber(Integer userId){
        return "Change" + DateUtils.parseDateToStr(new Date(), DateUtils.DATE_TIME_FORMAT_YYYYMMDDHHMISS) + userId;
    }

    public Boolean addHouseChange(List<AddHouseChangeRequest> requests){
        for(AddHouseChangeRequest request : requests){

        }
        return true;
    }
}
