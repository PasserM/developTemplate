package com.hennro.hes.common.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
public class BaseEntity {
    private Integer pageNum;
    private  Integer pageSize;
    private String searchKey;
    private Date startDate;
    private Date endDate;
}
