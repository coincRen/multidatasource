package com.example.multidatasource.mapper2;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Ren ZhiQiang
 * @date 2019/5/23 15:41
 * @desc
 */
@Mapper
public interface MapperTwo {

    @Select("SELECT DATABASE()")
    String selectDataBase();
}
