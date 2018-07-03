package com.hennro.hes.module.cbs.core.mapper;

import com.hennro.hes.module.cbs.common.request.HouseChangeSearchRequest;
import com.hennro.hes.module.cbs.core.entity.HCbsBillHouseChange;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HHouseChangeMapper {

    List<HCbsBillHouseChange> getHouseChangeList(HouseChangeSearchRequest request);

    HCbsBillHouseChange getByHouseChangeId(String id);
}
