package com.lzyd.controller;


import com.lzyd.controller.proxy.MqProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("/test")
public class MqController {
    @Autowired
    MqProxyService mqProxyService;


    @RequestMapping(value = "taskList", method = RequestMethod.POST)
    public Object taskList(@RequestBody Map<String,Object> map) {
        Object o = mqProxyService.taskList(map);
        return o;
    }

    @RequestMapping(value = "rabbitMqTest", method = RequestMethod.POST)
    public Object rabbitMqTest(@RequestBody Map<String,Object> map) {
        Object o = mqProxyService.rabbitMqTest(map);
        return o;
    }








}
