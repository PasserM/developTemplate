package com.hennro.hes.module.scm.entity;

import com.hennro.hes.module.scm.entity.vo.BaseVO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Order extends BaseVO {
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
