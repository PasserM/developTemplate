package com.hennro.hes.module.cbs.core.service;

import com.hennro.hes.module.cbs.common.request.HouseChangeSearchRequest;
import com.hennro.hes.module.cbs.core.domain.HouseTree;
import com.hennro.hes.module.cbs.core.entity.HCbsBaseHouse;
import com.hennro.hes.module.cbs.core.entity.HCbsBillHouseChange;
import com.hennro.hes.module.cbs.core.mapper.HHouseChangeMapper;
import com.hennro.hes.module.cbs.core.repo.HCbsBaseHouseRepo;
import com.hennro.hes.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tianjianping in 2018/6/27
 */
@Service
public class HouseService {

    @Resource
    HCbsBaseHouseRepo hCbsBaseHouseRepo;

    public List<HouseTree> getHouseOfTree(String key){
        List<HCbsBaseHouse> houses = hCbsBaseHouseRepo.getHouse(0,null==key?"":key,null==key?"":key);
        List<HouseTree> tree;
        if(StringUtils.isEmpty(key)){
            houses.add(HCbsBaseHouse.builder().fItemId(0).fName("全部").fParentId(-1).build());
            tree = listToTree(houses);
        }else{
            tree = new ArrayList<>();
            tree.add(HouseTree.builder().name("全部").id(0).children(new ArrayList<>()).build());
            for(HCbsBaseHouse house : houses){
                tree.get(0).getChildren().add(HouseTree.builder().name(house.getFFullName()).id(house.getFItemId()).parentId(0).build());
            }
        }

        return tree;
    }

    public List<HCbsBaseHouse> getChildDetailHouse(String parentId){
        return hCbsBaseHouseRepo.getChildDetailHouse(parentId);
    }

    private static List<HouseTree> listToTree(List<HCbsBaseHouse> list) {
        List<HouseTree> temp = new ArrayList<>();
        for(HCbsBaseHouse house : list){
                temp.add(HouseTree.builder().id(house.getFItemId()).name(house.getFName()).parentId(house.getFParentId()).build());
        }
        List<HouseTree> treeList = new ArrayList<>();
        for (HouseTree house : temp) {
            //找到根
            if (house.getParentId() == -1) {
                treeList.add(house);
            }
            //找到子
            for (HouseTree house1 : temp) {
                if (house1.getParentId() == house.getId()) {
                    if (house.getChildren() == null) {
                        house.setChildren(new ArrayList<>());
                    }
                    house.getChildren().add(house1);
                }
            }
        }
        return treeList;
    }

}
