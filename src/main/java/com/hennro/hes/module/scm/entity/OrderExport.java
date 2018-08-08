package com.hennro.hes.module.scm.entity;

import com.hennro.hes.module.scm.entity.vo.BaseVO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class OrderExport extends BaseVO {

	@Id
	private Long fid;
	private String entryID;
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
	private Date billDate;
	private String checker;
	private Date checkDate;
	private String invoiceNo;

	
}
