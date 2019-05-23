package com.example.multidatasource.mapper1;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Ren ZhiQiang
 * @date 2019/5/23 15:40
 * @desc
 */
@Mapper
public interface MapperOne {

    @Select("SELECT DATABASE()")
    String selectDataBase();
}
