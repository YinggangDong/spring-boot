package com.example.demo.verifyaspect;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * DemoMapper 接口是
 *
 * @author dongyinggang
 * @date 2022-04-26 15:48
 **/
@Mapper
public interface DemoMapper {

    @Select("SELECT * FROM t")
    List<Map<String, Object>> selectAll();

}
