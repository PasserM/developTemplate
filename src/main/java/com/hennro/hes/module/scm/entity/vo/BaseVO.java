package com.hennro.hes.module.scm.entity.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
public class BaseVO {
    private Integer pageNum;
    private  Integer pageSize;
    private String searchKey;
    private Date startDate;
    private Date endDate;
}
