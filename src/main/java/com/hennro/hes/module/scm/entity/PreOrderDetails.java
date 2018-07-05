package com.hennro.hes.module.scm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Getter
@Setter
@Entity
public class PreOrderDetails {
	@Id
	private String fid;
	private String entryID;
	private String itemName;
	private double price;
	private double qty;
	private double stockQty;
	private String unit;
	private double amount;
	private String taxRate;
	private String taxAmount;
	private double allAmount;
	private String batchNo;
	private String fromID;
	private String fromBuyPlanID;
	private String fromEntryID;
	private String memo;
	private String stauts;

}
