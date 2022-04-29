package com.example.demo.aspecttest;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * AspectMapper 类是
 *
 * @author dongyinggang
 * @date 2022-04-26 08:25
 **/
public interface AspectMapper {

    @Select("SELECT * FROM user")
    List<Map<String, Object>> selectAll();
}
