package org.tts.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.support.RetryTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Exchanger;

/**
 * @Description :springboot 本地整合rabbit
 * @Auther : Tianjx
 * @CreateTime : 2022/10/19 13:48
 */
@Configuration
public class RabbitMQConfig {

    @Resource
    private  CachingConnectionFactory connectionFactory;

    /**
     * 针对某个特定的消费配置,如果配置了这个,配置文件中的全局配置将失效
     * @return
     */
    @Bean(name = "mqConsumerlistenerContainer")
    public SimpleRabbitListenerContainerFactory mqConsumerlistenerContainer(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPrefetchCount(3);
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }

    public static final String DIRECT_EXCHANGE="direct_exchange";
    public static final String DEAD_EXCHANGE="dead_order_exchange" ;
    public static final String DELAY_EXCHANGE="delay_exchange";
    public static final String FANOUT_EXCHANGE="fanout_exchange";
    public static final String TOPIC_EXCHANGE="topic_exchange";

    public static final String DIRECT_QUEUE_NAME="order_queue";
    public static final String DEAD_QUEUE_NAME="dead_order_queue" ;
    public static final String DELAY_QUEUR_NAME="delay_queue" ;
    public static final String TOPIC_QUEUE_NAME="topic_queue" ;
    public static final String FANOUT_QUEUE_NAME="fanout_queue" ;

    private static final String DEAD_ROUTE_KEY ="dead_order_route_key" ;
    private static final String DIRECT_ROUTE_KEY="order_route_key" ;
    private static final String DELAY_ROUTE_KEY="delay_route_key" ;
    public static final String TOPIC_ROUT_KEY="*.topic.*";

    /**
     * 声明交换器，几种不同类型的交换机对应的类如下：
     * 1、DirectExchange：声明路由模式交换器
     * 2、FanoutExchange：声明订阅模式交换器
     * 3、TopicExchange：声明带有模式匹配的交换器
     * @return
     */
    @Bean("directExchange")
    public DirectExchange directExchange(){
        return new DirectExchange(DIRECT_EXCHANGE,true,false) ;
    }

    @Bean("topicExchange")
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE,false,false) ;
    }

    @Bean("fanoutExchange")
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGE,false,false) ;
    }

    @Bean("delayExchange")
    public CustomExchange delayExchange(){
        Map<String,Object> args =new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAY_EXCHANGE,"x-delayed-message",false,false,args) ;
    }

    @Bean("deadExchange")
    public DirectExchange deadExchange(){
        return new DirectExchange(DEAD_EXCHANGE,true,false) ;
    }

    /**
     * 声明队列有两种方式：
     * 1、使用QueueBuilder构建
     * 2、使用new Queue()
     * @return
     */
    @Bean("directlQueue")
    public Queue directlQueue() {
        //队列的一些属性
        Map<String, Object> arguments = new HashMap<>();
        //正常队列绑定死信队列
        //arguments.put("x-message-ttl", 10000);//消息过期时间，单位ms，可以不设置，可以由生产者设置消息过期时间
        arguments.put("x-dead-letter-exchange", DEAD_EXCHANGE);//设置消息过期后转发到哪个交换器
        arguments.put("x-dead-letter-routing-key", DEAD_ROUTE_KEY);//设置消息过期后由交换器路由到哪个队列的路由键
        //arguments.put("x-max-length", 6);//设置队列的长度，能存储消息的个数
        /**
         * 声明一个非持久的队列
         * durable：持久的
         * withArguments：添加队列的属性（批量方式）
         * withArgument：添加队列的属性（单个方式）
         */
        return QueueBuilder.durable(DIRECT_QUEUE_NAME).withArguments(arguments).build();
    }

    @Bean("delayQueue")
    public Queue delayQueue() {
        /**
         * 声明一个非持久的队列
         * durable：持久的
         * withArguments：添加队列的属性（批量方式）
         * withArgument：添加队列的属性（单个方式）
         */
        return QueueBuilder.nonDurable(DELAY_QUEUR_NAME).build();
    }

    @Bean("topicQueue")
    public Queue topicQueue() {
        /**
         * 声明一个非持久的队列
         * durable：持久的
         * withArguments：添加队列的属性（批量方式）
         * withArgument：添加队列的属性（单个方式）
         */
        return QueueBuilder.nonDurable(TOPIC_QUEUE_NAME).build();
    }
    @Bean("fanoutQueue")
    public Queue fanoutQueue() {
        /**
         * 声明一个非持久的队列
         * durable：持久的
         * withArguments：添加队列的属性（批量方式）
         * withArgument：添加队列的属性（单个方式）
         */
        return QueueBuilder.nonDurable(FANOUT_QUEUE_NAME).build();
    }

    @Bean("deadQueue")
    public Queue deadQueue() {
        //默认是一个持久队列
        Queue queue = new Queue(DEAD_QUEUE_NAME);
        return queue;
    }
    @Bean
    public Binding directBindingExchange(@Qualifier("directlQueue")Queue directlQueue,@Qualifier("directExchange")DirectExchange directExchange ){

        return BindingBuilder.bind(directlQueue) //绑定队列
                .to(directExchange)   //队列绑定到哪个交换器
                .with(DIRECT_ROUTE_KEY); //绑定路由key,必须指定
    }
    @Bean
    public Binding topicBindingExchange(@Qualifier("topicQueue")Queue topicQueue,@Qualifier("topicExchange")TopicExchange topicExchange ){

        return BindingBuilder.bind(topicQueue) //绑定队列
                .to(topicExchange)   //队列绑定到哪个交换器
                .with(TOPIC_ROUT_KEY); //绑定路由key,必须指定
    }
    @Bean
    public Binding fanoutBindingExchange(@Qualifier("fanoutQueue")Queue fanoutQueue,@Qualifier("fanoutExchange")FanoutExchange fanoutExchange ){

        return BindingBuilder.bind(fanoutQueue) //绑定队列
                .to(fanoutExchange);   //队列绑定到哪个交换器
    }
    @Bean
    public Binding delayBindingExchange(@Qualifier("delayQueue")Queue delayQueue,@Qualifier("delayExchange")CustomExchange delayExchange ){
        return BindingBuilder.bind(delayQueue).to(delayExchange).with(DELAY_ROUTE_KEY).noargs();
    }

    @Bean
    public Binding deadBindingExchange(@Qualifier("deadQueue")Queue deadQueue,@Qualifier("deadExchange")DirectExchange deadExchange ){
        return BindingBuilder.bind(deadQueue).to(deadExchange).with(DEAD_ROUTE_KEY);
    }
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }



}
