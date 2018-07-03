package com.hennro.hes.module.cbs.core.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by tianjianping in 2018/6/21
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "H_CBS_Bill_HouseChangeEntry", schema = "dbo", catalog = "CBS")
public class HCbsBillHouseChangeEntry {
    @Id
    @Column(name = "FId")
    private int fId;
    @Basic
    @Column(name = "FListId")
    private int fListId;
    @Basic
    @Column(name = "FType")
    private String fType;
    @Basic
    @Column(name = "FOriginalHouseId")
    private int fOriginalHouseId;
    @Basic
    @Column(name = "FNewNumber")
    private String fNewNumber;
    @Basic
    @Column(name = "FNewName")
    private String fNewName;
    @Basic
    @Column(name = "FAcreage")
    private BigDecimal fAcreage;

    @Transient
    private String originalHouseNumber;
    @Transient
    private String originalHouseShortNumber;
    @Transient
    private String originalHouseFullNumber;
    @Transient
    private String originalHouseName;
    @Transient
    private String originalHouseFullName;
}
