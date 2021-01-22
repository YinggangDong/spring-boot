package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * HelloMapper 接口是 测试Mapper
 *
 * @author dongyinggang
 * @date 2020-11-23 15:03
 **/
@Mapper
public interface HelloMapper {

    User selectById(Integer id);

    List<User> selectListById(Integer id);

    String testProcess(Map<String,Object> map);
}
