package com.hennro.hes.module.sys.core.service;

import com.hennro.hes.common.JsonHelper;
import com.hennro.hes.module.sys.core.mapper.HUserSysRightMapper;
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
public class SysTestService {

    @Resource
    private HUserSysRightRepo hUserSysRightRepo;

    @Resource
    private HUserSysRightMapper hUserSysRightMapper;

    @Resource
    private JsonHelper jsonHelper;

    @Transactional
    public void test() {
        log.info(jsonHelper.string(hUserSysRightRepo.findAll()));
        log.info(jsonHelper.string(hUserSysRightMapper.findAll()));
    }
}
