package com.hennro.hes.module.sys.core.entity;

import lombok.*;

import javax.persistence.*;
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
@Table(name = "H_User")
public class HUser {
    @Id
    @Column(name = "FID")
    private int fid;
    @Basic
    @Column(name = "FNumber")
    private String fNumber;
    @Basic
    @Column(name = "FLoginName")
    private String fLoginName;
    @Basic
    @Column(name = "FPassWord")
    private String fPassWord;
    @Basic
    @Column(name = "FName")
    private String fName;
    @Basic
    @Column(name = "FSex")
    private String fSex;
    @Basic
    @Column(name = "FTelePhone")
    private String fTelePhone;
    @Basic
    @Column(name = "FPhone")
    private String fPhone;
    @Basic
    @Column(name = "FEmail")
    private String fEmail;
    @Basic
    @Column(name = "FDeptID")
    private Integer fDeptId;
    @Basic
    @Column(name = "FPosition")
    private String fPosition;
    @Basic
    @Column(name = "FStatus")
    private Integer fStatus;
    @Basic
    @Column(name = "FMeno")
    private String fMeno;
    @Basic
    @Column(name = "FType")
    private String fType;
    @Basic
    @Column(name = "FComeFrom")
    private String fComeFrom;
    @Basic
    @Column(name = "FOtherUserID")
    private String fOtherUserId;
    @Basic
    @Column(name = "FOtherUserName")
    private String fOtherUserName;
    @Basic
    @Column(name = "FOperator")
    private String fOperator;
    @Basic
    @Column(name = "FOperatorIP")
    private String fOperatorIp;
    @Basic
    @Column(name = "FOperateTime")
    private Timestamp fOperateTime;
    @Basic
    @Column(name = "FOperatorHost")
    private String fOperatorHost;
    @Basic
    @Column(name = "FPhoneModel")
    private String fPhoneModel;
    @Basic
    @Column(name = "FDeviceToken")
    private String fDeviceToken;
    @Basic
    @Column(name = "FPhoto")
    private String fPhoto;
    @Basic
    @Column(name = "FLoginIP")
    private String fLoginIp;
    @Basic
    @Column(name = "FLoginDate")
    private Timestamp fLoginDate;
    @Basic
    @Column(name = "FLocation")
    private String fLocation;
}
