package org.tts.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description :springboot 本地整合rabbit
 * @Auther : Tianjx
 * @CreateTime : 2022/10/19 13:48
 */
@Configuration
public class RabbitMQConfig {

    public static final String NOMAL_EXCHANGE="order_exchange";
    public static final String DEAD_EXCHANGE="dead_order_exchange" ;
    private static final String NOMAL_QUEUE_NAME="order_queue";
    private static final String DEAD_QUEUE_NAME="dead_order_queue" ;
    public static final String NOMAL_ROUTE_KEY="order_route_key" ;
    /**
     * 声明交换器，几种不同类型的交换机对应的类如下：
     * 1、DirectExchange：声明路由模式交换器
     * 2、FanoutExchange：声明订阅模式交换器
     * 3、TopicExchange：声明带有模式匹配的交换器
     * @return
     */
    @Bean("normalExchange")
    public DirectExchange normalExchange(){
        return new DirectExchange(NOMAL_EXCHANGE) ;
    }

    @Bean("deadExchange")
    public DirectExchange deadExchange(){
        return new DirectExchange(DEAD_EXCHANGE) ;
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    /**
     * autoStartUp必须要设置为true,否则Spring容器不会加载RabbitAdmin类
     * RabbitAdmin底层实现就是从Spring容器中获取Exchange、Bingding、RoutingKey以及Queue的@Bean声明
     * 使用RabbitTemplate的execute方法执行对应的什么、修改、删除等一系列RabbitMQ基础功能操作
     * 例如：添加一个交换机、删除一个绑定、清空一个队列里的消息等等
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        RabbitAdmin rabbitAdmin =new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }



}
