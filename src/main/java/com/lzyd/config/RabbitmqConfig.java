package com.lzyd.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/07/16]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */


//@Configuration
public class RabbitmqConfig {


    public static final String DELAY_EXCHANGE_NAME = "delay.queue.demo.business.exchange";
    public static final String DELAY_QUEUEA_NAME = "delay.queue.demo.business.queuea";
    public static final String DELAY_QUEUEB_NAME = "delay.queue.demo.business.queueb";
    public static final String DELAY_QUEUEA_ROUTING_KEY = "delay.queue.demo.business.queuea.routingkey";
    public static final String DELAY_QUEUEB_ROUTING_KEY = "delay.queue.demo.business.queueb.routingkey";
    public static final String DEAD_LETTER_EXCHANGE = "delay.queue.demo.deadletter.exchange";
    public static final String DEAD_LETTER_QUEUEA_ROUTING_KEY = "delay.queue.demo.deadletter.delay_10s.routingkey";
    public static final String DEAD_LETTER_QUEUEB_ROUTING_KEY = "delay.queue.demo.deadletter.delay_60s.routingkey";
    public static final String DEAD_LETTER_QUEUEA_NAME = "delay.queue.demo.deadletter.queuea";
    public static final String DEAD_LETTER_QUEUEB_NAME = "delay.queue.demo.deadletter.queueb";

    /**
     * 立即消费队列
     */
    @Bean(name = "immediate_queue_test1")
    public Queue immediateQueue() {
        return new Queue("immediate_queue_test1",true);
    }
    /**
     * 立即消费队列
     */
    @Bean(name = "immediate_queue_test2")
    public Queue immediateQueueTest2() {
        return new Queue("immediate_queue_test2",true);
    }
    /**
     *  一共有三种构造方法，可以只传exchange的名字， 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
     *  第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
     */
    @Bean
    public DirectExchange immediateExchange() {
        return new DirectExchange("immediateExchange",true,false);
    }



    /**
     *      把立即消费的队列和立即消费的exchange绑定在一起
     */
    @Bean
    public Binding immediateBinding1() {
        return BindingBuilder.bind(immediateQueue()).to(immediateExchange()).with("immediate_routing_key_test1");
    }
    @Bean
    public Binding immediateBinding2() {
        return BindingBuilder.bind(immediateQueueTest2()).to(immediateExchange()).with("immediate_routing_key_test2");
    }


    // 声明延时Exchange
    @Bean("delayExchange")
    public DirectExchange delayExchange(){
        return new DirectExchange(DELAY_EXCHANGE_NAME);
    }
    // 声明死信队列
    @Bean("deadLetterExchange")
    public DirectExchange deadLetterExchange(){
        return new DirectExchange(DEAD_LETTER_EXCHANGE);
    }
    // 声明延时队列A 延时10s
    // 并绑定到对应的死信交换机
    @Bean("delayQueueA")
    public Queue delayQueueA(){
        Map<String, Object> args = new HashMap<>(2);
        // x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
        // x-dead-letter-routing-key  这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", DEAD_LETTER_QUEUEA_ROUTING_KEY);
        // x-message-ttl  声明队列的TTL
        args.put("x-message-ttl", 6000);
        return QueueBuilder.durable(DELAY_QUEUEA_NAME).withArguments(args).build();
    }






}
