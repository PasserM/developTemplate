package com.hennro.hes.module.sys.core.service;

import com.hennro.hes.module.sys.core.entity.HDepartment;
import com.hennro.hes.module.sys.core.entity.HUser;
import com.hennro.hes.module.sys.core.repo.HDepartmentRepo;
import com.hennro.hes.module.sys.core.repo.HUserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tianjianping on 2018/6/23.
 */
@Service
@Slf4j
public class HDepartmentService {

    @Resource
    private HDepartmentRepo departmentRepo;

    public List<HDepartment> getDepartmentList(){
        return departmentRepo.findAll();
    }

}
