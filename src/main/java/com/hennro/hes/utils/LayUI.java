package com.hennro.hes.utils;

import com.hennro.hes.module.scm.entity.Order;

import java.util.HashMap;
import java.util.List;

public class LayUI extends HashMap<String, Object> {
        public static LayUI data(Integer count,List data){
            LayUI r = new LayUI();
            r.put("code", 0);
            r.put("msg", "");
            r.put("count", count);
            r.put("data", data);
            return r;
        }

}