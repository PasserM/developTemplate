package com.hennro.hes.module.scm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Auther: LuoHM
 * @Date: 2018/8/3 11:12
 * @Description:
 */
@Getter
@Setter
@Entity
public class Supplier {
    @Id
    private int id;
    private String supplierName;
    private String shortName;
}
