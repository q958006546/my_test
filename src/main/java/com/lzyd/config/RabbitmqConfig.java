package com.lzyd.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/07/16]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */


@Configuration
public class RabbitmqConfig {

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




}
