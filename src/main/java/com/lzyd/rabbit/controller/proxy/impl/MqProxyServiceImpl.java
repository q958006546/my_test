package com.lzyd.controller.proxy.impl;

import com.lzyd.controller.proxy.MqProxyService;
import com.lzyd.model.Sender;
import com.lzyd.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/07/15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
@Slf4j
public class MqProxyServiceImpl implements MqProxyService {
    @Autowired
    RedisUtils redisUtils;

    @Autowired
    Sender sender;

    @Override
    public Object taskList(Map<String, Object> map) {
        redisUtils.set("sss","sss",50*50);
        Object sss = redisUtils.get("sss");
        System.out.println(sss);


        return 666;
    }

    @Override
    public Object rabbitMqTest(Map<String, Object> map) {
        sender.send();
        log.info("队列发送成功");
        return null;
    }
}
