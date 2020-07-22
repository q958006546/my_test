package com.lzyd.model;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/07/16]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */


@Component
public class Sender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(String msg) {
//        System.out.println("Sender + " + msg);
        rabbitTemplate.convertAndSend("immediateExchange","immediate_routing_key_test1",msg);
    }


}
