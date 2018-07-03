package com.hennro.hes.module.sys.core.service;

import com.hennro.hes.common.JsonHelper;
import com.hennro.hes.module.sys.core.domain.Menu;
import com.hennro.hes.module.sys.core.mapper.MenuMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anxpp.com on 2018/6/23.
 */
@Service
@Slf4j
public class MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private JsonHelper jsonHelper;

    /**
     * 获取用户菜单
     * 1、应该需要根据父菜单作预处理
     * 2、菜单添加cache
     * @param userId 用户ID：可能需要使用当前用户的token获取userId，而不是直接传入
     */
    @Transactional
    public List<Menu> findByUserId(Integer userId) {
        List<Menu> menus = menuMapper.findByUserId(userId);
        List<Menu> results = toChild(menus);
        return results;
    }

    private  List<Menu > toChild( List<Menu> menus){
        List<Menu> nodeList = new ArrayList();

        for (Menu menu : menus) {

            if (menu.getName().equals(menu.getParent().getName())) {
              nodeList.add(menu);
            }

            for (Menu it : menus) {
                if (!it.getName().equals(it.getParent().getName()) && it.getParent().getName().equals(menu.getName())) {
                    if (menu.getChildren() == null) {
                        menu.setChildren(new ArrayList<>());
                    }
                    menu.getChildren().add(it);
                }
            }
        }
        return nodeList;
    }
}
