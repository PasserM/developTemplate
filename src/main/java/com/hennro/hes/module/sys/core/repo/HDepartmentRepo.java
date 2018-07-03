package com.hennro.hes.module.sys.core.repo;

import com.hennro.hes.module.sys.core.entity.HDepartment;
import com.hennro.hes.module.sys.core.entity.HUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tianjianping on 2018/6/23.
 */
public interface HDepartmentRepo extends JpaRepository<HDepartment, Integer> {

}
