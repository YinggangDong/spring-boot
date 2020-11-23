package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * HelloMapper 接口是 测试Mapper
 *
 * @author dongyinggang
 * @date 2020-11-23 15:03
 **/
@Mapper
public interface HelloMapper {

    /**
     * selectById 方法是 根据id查询user信息
     *
     * @param id 用户id
     * @return 用户信息
     * @author dongyinggang
     * @date 2020/11/23 15:38
     */
    User selectById(Integer id);
}
