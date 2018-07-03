package com.hennro.hes.module.sys.core.mapper;

import com.hennro.hes.module.sys.core.domain.HUserSysRight;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HUserSysRightMapper {

    List<HUserSysRight> findAll();

}
