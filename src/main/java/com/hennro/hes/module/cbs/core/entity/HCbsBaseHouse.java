package com.hennro.hes.module.cbs.core.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name = "H_CBS_Base_House", schema = "dbo", catalog = "CBS")
public class HCbsBaseHouse {
    @Id
    @Column(name = "FItemID")
    private int fItemId;
    @Basic
    @Column(name = "FLeaseStatus")
    private String fLeaseStatus;
    @Basic
    @Column(name = "FHouseShape")
    private String fHouseShape;
    @Basic
    @Column(name = "FAcreage")
    private String fAcreage;
    @Basic
    @Column(name = "FEffective")
    private Timestamp fEffective;
    @Basic
    @Column(name = "FFailure")
    private Timestamp fFailure;
//    @Basic
//    @Column(name = "FModifyTime")
//    private Serializable fModifyTime;
    @Basic
    @Column(name = "FNumber")
    private String fNumber;
    @Basic
    @Column(name = "FParentID")
    private Integer fParentId;
    @Basic
    @Column(name = "FLevel")
    private Short fLevel;
    @Basic
    @Column(name = "FDetail")
    private Boolean fDetail;
    @Basic
    @Column(name = "FName")
    private String fName;
    @Basic
    @Column(name = "FFullNumber")
    private String fFullNumber;
    @Basic
    @Column(name = "FDeleted")
    private Boolean fDeleted;
    @Basic
    @Column(name = "FShortNumber")
    private String fShortNumber;
    @Basic
    @Column(name = "FFullName")
    private String fFullName;
    @Basic
    @Column(name = "FChkUserID")
    private Integer fChkUserId;
}
