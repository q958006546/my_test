package com.lzyd.controller.proxy;

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
public interface MqProxyService {
    Object taskList(Map<String, Object> map);

    Object rabbitMqTest(Map<String, Object> map);


}
