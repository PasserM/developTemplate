package com.hennro.hes.module.scm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
public class Order {
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
    private String startDate;
    private String endDate;
    private String searchKey;


}
