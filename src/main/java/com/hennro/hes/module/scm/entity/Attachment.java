package com.hennro.hes.module.scm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.awt.*;
import java.util.Date;

/**'
 * @author LuoHM
 *
 */

@Getter
@Setter
@Entity
public class Attachment {
    @Id
    @Column(name="FAttID" )
    private int id;
    private String fid;
    private String attName;
    private String attType;
    private String path;
    private Image context;
    private String remark;
    private Date uploadDate;
    private Float fileSize;
}
