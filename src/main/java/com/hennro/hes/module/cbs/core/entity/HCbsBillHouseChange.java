package com.hennro.hes.module.cbs.core.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by tianjianping in 2018/6/21
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "H_CBS_Bill_HouseChange", schema = "dbo", catalog = "CBS")
public class HCbsBillHouseChange {
    @Id
    @Column(name = "FId")
    private int fId;
    @Basic
    @Column(name = "FCompanyBelong")
    private String fCompanyBelong;
    @Basic
    @Column(name = "FBillNumber")
    private String fBillNumber;
    @Basic
    @Column(name = "FDate")
    private Date fDate;
    @Basic
    @Column(name = "FRemark")
    private String fRemark;
    @Basic
    @Column(name = "FOperator")
    private String fOperator;
    @Basic
    @Column(name = "FCheck")
    private String fCheck;

    @Transient
    private List<HCbsBillHouseChangeEntry> entries;
}
