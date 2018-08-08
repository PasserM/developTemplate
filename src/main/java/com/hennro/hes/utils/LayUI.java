package com.hennro.hes.utils;

import com.github.pagehelper.PageInfo;
import com.hennro.hes.module.scm.entity.Order;

import java.util.HashMap;
import java.util.List;

public class LayUI extends HashMap<String, Object> {
        public static LayUI data(long count,List data){
            LayUI r = new LayUI();
            r.put("code", 0);
            r.put("msg", "");
            r.put("count", count);
            r.put("data", data);
            return r;
        }
    public static LayUI data(PageInfo<Object> pageInfo){
        LayUI r = new LayUI();
        r.put("code", 0);
        r.put("msg", "");
        r.put("count", pageInfo.getTotal());
        r.put("limt", pageInfo.getPageNum());
        r.put("page", pageInfo.getPageSize());
        r.put("data", pageInfo.getList());
        return r;
    }

}
