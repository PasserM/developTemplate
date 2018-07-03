package com.hennro.hes.module.sys.core.mapper;

import com.hennro.hes.module.sys.core.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<Menu> findByUserId(@Param("userId") Integer userId);

}
