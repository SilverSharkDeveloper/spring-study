package com.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {
//    @Select("SELECT SYSDATE FROM DUAL")
//    public String getTime();
    public String getTime();
}
