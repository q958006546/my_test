package com.lzyd.model;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Component;

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
public class Receiver {


    @RabbitHandler
    @RabbitListener(queues = "immediate_queue_test1")
    public void immediateProcess(String msg) {
        System.out.println("Receiver + " + msg);
        System.out.println("接收成功1");
    }
    @RabbitHandler
    @RabbitListener(queues = "immediate_queue_test1")
    public void immediateProcess2(String msg) {
        System.out.println("Receiver + " + msg );
        System.out.println("接收成功2");
    }

}
