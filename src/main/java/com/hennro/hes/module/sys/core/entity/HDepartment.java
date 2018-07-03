package com.hennro.hes.module.sys.core.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by tianjianping in 2018/6/21
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "H_Department", schema = "dbo", catalog = "hsite")
public class HDepartment {
    @Id
    @Column(name = "FItemID")
    private int fItemId;

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
    private Short fDeleted;
    @Basic
    @Column(name = "FShortNumber")
    private String fShortNumber;
    @Basic
    @Column(name = "FFullName")
    private String fFullName;
    @Basic
    @Column(name = "FChkUserID")
    private Integer fChkUserId;
    @Basic
    @Column(name = "FUnitSysCode")
    private String fUnitSysCode;
    @Basic
    @Column(name = "FCreateDate")
    private Timestamp fCreateDate;
    @Basic
    @Column(name = "FResponsibility")
    private String fResponsibility;
    @Basic
    @Column(name = "FTelephone")
    private String fTelephone;
    @Basic
    @Column(name = "FPhone")
    private String fPhone;
    @Basic
    @Column(name = "FFax")
    private String fFax;
    @Basic
    @Column(name = "FEmail")
    private String fEmail;
    @Basic
    @Column(name = "FMeno")
    private String fMeno;
    @Basic
    @Column(name = "FSelfCode")
    private String fSelfCode;
    @Basic
    @Column(name = "FType")
    private String fType;
}
