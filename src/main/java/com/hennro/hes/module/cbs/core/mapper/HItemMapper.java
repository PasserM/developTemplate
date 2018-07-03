package com.hennro.hes.module.cbs.core.mapper;

import com.hennro.hes.module.cbs.core.domain.HouseTree;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HItemMapper {

    List<HouseTree> findAll();

}
