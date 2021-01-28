package com.example.demo.service.impl;

import com.example.demo.config.MailConfig;
import com.example.demo.config.MailConfigByValue;
import com.example.demo.config.ThreadPoolConfig;
import com.example.demo.domain.User;
import com.example.demo.mapper.HelloMapper;
import com.example.demo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * HelloServiceImpl 类是 demo的Service实现
 *
 * @author dongyinggang
 * @date 2020-11-23 14:59
 **/
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapper helloMapper;
    @Autowired
    private ThreadPoolConfig threadPoolConfig;
    @Autowired
    private MailConfig mailConfig;
    @Autowired
    private MailConfigByValue mailConfigByValue;

    /**
     * hello 方法是 测试
     *
     * @param id 用户id
     * @return 用户姓名
     * @author dongyinggang
     * @date 2020/11/23 15:00
     */
    @Override
    public String hello(Integer id) {
        //user可能为null
        User user = helloMapper.selectById(id);
        return Optional.ofNullable(user).map(User::getRealName).orElse("未知用户");
    }

    @Override
    public String helloList(Integer id) {
        //userList不会是null,会是一个size为0的空list
        List<User> userList = helloMapper.selectListById(id);
        return userList.size() + "";
    }

    @Override
    public String testProcess() {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", "开发人员");
        map.put("passWord", "123");
        map.put("realName", "王五");
        map.put("id", null);
        helloMapper.testProcess(map);
        System.out.println(map.get("id"));
        return "";
    }

    /**
     * testThreadPool 方法是 测试集成的公共线程池
     *
     * @return 结果
     * @author dongyinggang
     * @date 2021/1/23 10:50
     */
    @Override
    public String testThreadPool() {
        int threadNum = 10;
        //启多个线程运行,每个线程睡眠2000ms
        for (int i = 0; i < threadNum; i++) {
            //直接通过threadPoolConfig.commonThreadPool()就可以获取到公共线程池
            threadPoolConfig.commonThreadPool().execute(() -> {
                System.out.println(Thread.currentThread().getName() + "正在运行");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        return "成功启动" + threadNum + "个线程";
    }

    /**
     * testConf 方法是 测试 ConfigurationProperties 加载配置文件的属性
     *
     * @return mailConfig的值
     * @author dongyinggang
     * @date 2021/1/26 14:07
     */
    @Override
    public String testConf() {
        mailConfig.getMailConfig();
        mailConfigByValue.getMailConfig();
        return "加载配置文件完毕";
    }
}
