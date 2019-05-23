package com.example.multidatasource.controller;

import com.example.multidatasource.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author Ren ZhiQiang
 * @date 2019/5/23 15:34
 * @desc
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Resource
    TestService testService;

    @GetMapping
    public Object testDataSource(){
        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("db1",testService.testDateSourceOne());
        resultMap.put("db2",testService.testDateSourceTwo());
        return resultMap;
    }
}
