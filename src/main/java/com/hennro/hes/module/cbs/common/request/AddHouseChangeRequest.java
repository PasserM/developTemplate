package com.hennro.hes.module.cbs.common.request;

import lombok.*;

import java.util.Date;

/**
 * Created by tianjianping in 2018/6/30
 */

@Getter
@Setter
public class AddHouseChangeRequest {
    private String fAcreage;
    private String fType;
    private String newHouseName;
    private String newHouseNumber;
    private String originalHouseFullName;
    private String originalHouseFullNumber;
    private Integer originalHouseId;
    private String fCompanyBelong;
    private String fBillNumber;
    private String fRemark;
    private Date fDate;
}
