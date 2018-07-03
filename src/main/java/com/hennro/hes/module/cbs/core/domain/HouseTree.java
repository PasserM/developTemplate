package com.hennro.hes.module.cbs.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

/**
 * Created by anxpp.com on 2018/6/23.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseTree {

    private Integer id;

    private String name;

    private Integer parentId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<HouseTree> children;
}
