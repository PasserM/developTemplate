package com.hennro.hes.module.sys.core.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anxpp.com on 2018/6/24.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {

    private Menu parent;    // 父级菜单
    private String parentIds; // 所有父级编号
    private String name;    // 名称
    private String href;    // 链接
    private String target;    // 目标（ mainFrame、_blank、_self、_parent、_top）
    private String icon;    // 图标
    private Integer sort = 30;    // 排序
    private String isShow;    // 是否在菜单中显示（1：显示；0：不显示）
    private String permission; // 权限标识

    private List<Menu> children = new ArrayList<>();

}
