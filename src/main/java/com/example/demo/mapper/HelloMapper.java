package com.example.demo.mapper;

import com.example.demo.domain.User;
import com.example.demo.util.aspect.stopwatch.StopWatchTime;
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

    /**
     * selectById 方法是 根据id查询User信息
     * StopWatchTime的自定义注解生效,可以进入切面
     *
     * @param id userId
     * @return 用户信息
     * @author dongyinggang
     * @date 2021/6/7 16:24
     */
    @StopWatchTime("say hello")
    User selectById(Integer id);

    List<User> selectListById(Integer id);

    String testProcess(Map<String, Object> map);
}
