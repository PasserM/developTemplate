package com.hennro.hes.module.sys.core.service;

import com.hennro.hes.common.JsonHelper;
import com.hennro.hes.module.sys.core.entity.HUser;
import com.hennro.hes.module.sys.core.repo.HUserRepo;
import com.hennro.hes.module.sys.core.repo.HUserSysRightRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by anxpp.com on 2018/6/23.
 */
@Service
@Slf4j
public class UserService {

    @Resource
    private HUserRepo userRepo;

    public HUser getUserByLoginName(String loginName){
        return userRepo.findByFLoginName(loginName);
    }

}
