package com.lzyd.pay.controller.porxy.impl;

import com.lzyd.pay.controller.porxy.PayProxyService;
import com.lzyd.pay.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/07/18]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Slf4j
@Service
public class PayProxyServiceImpl implements PayProxyService {

    @Autowired
    PayService payService;
    @Override
    public String toAlipay(Map<String, String> sourceMap) throws IOException {
        return payService.toAlipay(sourceMap);
    }
}
