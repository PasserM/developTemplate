package com.hennro.hes.module.cbs.core.repo;

import com.hennro.hes.module.cbs.core.entity.HCbsBaseHouse;
import com.hennro.hes.module.cbs.core.entity.HItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by tianjianping
 */
public interface HCbsBaseHouseRepo extends JpaRepository<HCbsBaseHouse, Integer> {

    @Query(value = "SELECT * from H_CBS_Base_House WHERE FDeleted=?1 AND (FFullName like %?2% or FFullNumber like %?3%)", nativeQuery = true)
    List<HCbsBaseHouse> getHouse(Integer delete, String key, String key1);

    @Query(value = "with rpl as ( " +
            "select * from H_CBS_Base_House where FParentID= ?1 " +
            "union all " +
            "select  child.* from rpl parent, H_CBS_Base_House child where parent.FItemID=child.FParentID " +
            ") " +
            "select * from rpl where FDetail=1 and FName is not null", nativeQuery = true)
    List<HCbsBaseHouse> getChildDetailHouse(String parentId);
}
