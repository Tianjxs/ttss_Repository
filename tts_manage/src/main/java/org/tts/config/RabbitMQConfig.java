package org.tts.config;

import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :springboot 本地整合rabbit
 * @Auther : Tianjx
 * @CreateTime : 2022/10/19 13:48
 */
@Configuration
public class RabbitMQConfig {
    /**
     * 交换机 在生产者侧不需要声明队列
     */
    public static final String DIRECT_EXCHANGE="direct_exchange";
    public static final String FANOUT_EXCHANGE="fanout_exchange";
    public static final String TOPIC_EXCHANGE="topic_exchange";
    public static final String DEAD_EXCHANGE="dead_order_exchange" ;
    public static final String DELAY_EXCHANGE="delay_exchange";
    /**
     * 路由
     */
    public static final String DELAY_ROUTE_KEY="delay_route_key" ;
    public static final String NOMAL_ROUTE_KEY="order_route_key" ;
    public static final String TOPIC_ROUT_KEY="*.topic.*";

    /**
     * 声明交换器，几种不同类型的交换机对应的类如下
     * 1、DirectExchange：声明路由模式交换器
     * 2、FanoutExchange：声明订阅模式交换器
     * 3、TopicExchange：声明带有模式匹配的交换器
     * 4、x-delayed-message 延迟队列交换机
     * @return
     */

    /**
     * Direct类型（默认，匹配发送）
     * 它会把消息路由到那些binding key与routing key完全匹配的Queue中。
     * 它是一个一对一的模型，一条消息一定会被发到指定的一个队列（完全匹配）。
     * @return
     */
    @Bean("directExchange")
    public DirectExchange normalExchange(){
        Map<String,Object> args =new HashMap<>();
        return new DirectExchange(DIRECT_EXCHANGE,true,false) ;
    }

    @Bean("fanoutExchange")
    public FanoutExchange normalFanoutExchange(){
        //参数介绍
        //1.交换器名 2.是否持久化 3.自动删除 4.其他参数
        return new FanoutExchange(FANOUT_EXCHANGE,false,false) ;
    }

    @Bean("topicExchange")
    public TopicExchange normalTopicExchange(){
        //参数介绍
        //1.交换器名 2.是否持久化 3.自动删除 4.其他参数
        return new TopicExchange(TOPIC_EXCHANGE,false,false) ;
    }

    @Bean("delayExchange")
    public CustomExchange delayExchange(){
        //参数介绍
        //1.交换器名 2.是否持久化 3.自动删除 4.其他参数
        Map<String,Object> args =new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAY_EXCHANGE,"x-delayed-message",false,false,args) ;
    }
    @Bean("deadExchange")
    public DirectExchange deadExchange(){
        return new DirectExchange(DEAD_EXCHANGE,true,false) ;
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
