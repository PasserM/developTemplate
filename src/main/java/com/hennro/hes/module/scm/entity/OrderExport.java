package com.hennro.hes.module.scm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
public class OrderExport {

	private Long fid;
	private String billNo;
	private String date;
	private String getDate;
	private String ticType;
	private String tsuName;
	private String currencyName;
	private String ticName;
	private String shortNumber;
	private double qty;
	private double price;
	private String tsuNumber;
	private Double taxRate;
	private String note;
	private String entryID;
	private String planType;
	private String unit;
	private double amount;
	private double allAmount;
	private String inBeforeQty;
	private String stockQty;
	private String batchNo;
	private String fromType;
	private String fromID;
	private String memo;
	private String biller;
	private String billDate;
	private String checker;
	private String checkDate;
	private String startDate;
	private String endDate;
	private String searchKey;
	private String invoiceNo;

	
}
