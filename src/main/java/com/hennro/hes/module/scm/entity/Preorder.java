package com.hennro.hes.module.scm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author LuoHM
 * @version 1.0
 */
@Getter
@Setter
@Entity
public class Preorder {

	private String tranType;
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
	private String status;
	private String invoiceNo;
	private String isChangePrice;
	private String priceVer;
	private String startDate;
	private String endDate;
	private String searchKey;


}
