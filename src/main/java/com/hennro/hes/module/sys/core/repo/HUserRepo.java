package com.hennro.hes.module.sys.core.repo;

import com.hennro.hes.module.sys.core.entity.HUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tianjianping on 2018/6/23.
 */
public interface HUserRepo extends JpaRepository<HUser, Integer> {
    HUser findByFLoginName(String loginName);
}
