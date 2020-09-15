package com.lzyd.reptile.proxy.impl;

import com.lzyd.reptile.proxy.ReptileProxyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/08/03]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Slf4j
@Service
public class ReptileProxyServiceImpl implements ReptileProxyService {


    @Override
    @Async("taskExecutor")
    public Object quBiGe(Map<String, Object> map) {
        for (int i = 0; i < 10; i++) {


        }


        return null;
    }
}
