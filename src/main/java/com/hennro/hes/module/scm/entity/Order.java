package com.hennro.hes.module.scm.entity;

import com.hennro.hes.common.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "H_POOrder")
public class Order extends BaseEntity {
    @Id
    @Column(name = "FID")
    private int id;
    private String billNo;
    private Date date;
    private String supplyName;
    private String currencyName;
    private Double taxRate;
    private String note;
    private String biller;
    private Date billDate;
    private String checker;
    private Date checkDate;
    private String readFlag;
    private String loginName;


}
