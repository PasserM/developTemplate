package com.hennro.hes;

import com.hennro.hes.common.JsonHelper;
import com.hennro.hes.module.sys.core.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuTests {

    @Resource
    private MenuService menuService;

    @Resource
    private JsonHelper jsonHelper;

    @Test
    public void test() {

        Map<String,Object> map = new HashMap<>();
        map.put("123","sdfg");
        String json = jsonHelper.string(map);

        log.info(json);

//        menuService.findByUserId(2);
    }

}
