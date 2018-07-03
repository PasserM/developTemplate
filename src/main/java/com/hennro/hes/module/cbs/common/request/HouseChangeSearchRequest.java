package com.hennro.hes.module.cbs.common.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by tianjianping in 2018/6/27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HouseChangeSearchRequest {
    public String department;

    public Date startTime;

    public Date endTime;

    public String key;
}
