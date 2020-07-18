package com.lzyd.pay.service;

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
public interface PayService {
    String toAlipay(Map<String, String> sourceMap) throws IOException;
}
