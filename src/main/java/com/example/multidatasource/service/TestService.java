package com.example.multidatasource.service;

import com.example.multidatasource.mapper1.MapperOne;
import com.example.multidatasource.mapper2.MapperTwo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Ren ZhiQiang
 * @date 2019/5/23 15:41
 * @desc
 */
@Service
public class TestService {
    @Resource
    MapperOne mapperOne;

    @Resource
    MapperTwo mapperTwo;

    public String testDateSourceOne() {
        return mapperOne.selectDataBase();
//        return "mapper1";
    }

    public String testDateSourceTwo() {
        return mapperTwo.selectDataBase();
//        return "mapper2";
    }
}
