package com.hennro.hes.module.sys.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by anxpp.com on 2018/6/23.
 */
@Getter
@Setter
@Entity
@Table(name = "H_UserSysRight")
public class HUserSysRight {

    @Id
    @Column(name = "FID")
    private Integer id;
}
