package com.hennro.hes.module.scm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
public class OrderDetails {
    private String fid;
    private String shortNumber;
    private String name;
    private String planType;
    private String type;
    private Date getDate;
    private double qty;
    private double price;
    private String unit;
    private double amount;
    private double allAmount;
    private String batchNo;
    private String fromID;
    private String memo;
    private String taxRate;
    private String scmStatus;
}
