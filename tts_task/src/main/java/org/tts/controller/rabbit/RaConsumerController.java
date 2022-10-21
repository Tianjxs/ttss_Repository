package org.tts.controller.rabbit;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tts.util.RabbitConnectUtils;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description :
 * @Auther : Tianjx
 * @CreateTime : 2022/10/17 15:04
 */
@RestController
public class RaConsumerController {
    private static Logger logger = LoggerFactory.getLogger(RaConsumerController.class) ;
    private Connection connection ;

    private Channel channel;

    public RaConsumerController() throws Exception {
        connection =RabbitConnectUtils.getConnection();
        channel =connection.createChannel();
    }

    /**
     * 测试 P2P 点对点模式
     *
     * @param msg
     * @throws Exception
     */
    @GetMapping("/rabbit/consumer")
    public void rabbitConsumerMessage(String msg) throws Exception {
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties
                    properties, byte[] body) throws IOException {
                String s = new String(body);
                System.out.println("消费者获取消息:"+s); //Hello,RabbitMq
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume("manageQueue",false,defaultConsumer) ;
    }

    /**
     * 工作模式 一对多个消费者
     * @throws IOException
     */
    @GetMapping("/rabbit/work/consumer")
    public void rabbitConsumerWork() throws IOException {
        AtomicInteger atomicInteger =new AtomicInteger(0) ;
        //设置不公平分配因为有的消费者执行的快,有的消费者处理消息慢,所以遵循"能者多劳"效率高,往执行快的消费者发送更多的消息
        channel.basicQos(1);
        DefaultConsumer defaultConsumer =new DefaultConsumer(channel){

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties
                    properties, byte[] body) throws IOException {
                //System.out.println("consumerTag:"+consumerTag);
                //System.out.println("envelope:"+envelope.toString());
                String s = new String(body);
                //System.out.println("消费者获取消息:"+s); //Hello,RabbitMq
                atomicInteger.addAndGet(1);

              /*  try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }*/
                logger.info("【顾客1】吃掉" + s + "! 总共吃掉【" + atomicInteger +"】串！");
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };

        channel.basicConsume("manage_work_queue",false,defaultConsumer) ;
    }

    /**
     * 订阅模式 Fanout
     * @throws IOException
     */
    @GetMapping("/rabbit/fanout/consumer")
    public void rabbitConsumerFanout() throws Exception {
        String exchangeName ="manage_exchange_fanout" ;
        String queueName ="fanout_queue_1" ;
        channel.queueDeclare(queueName,false,false,false,null) ;
        //channel.exchangeDeclare(exchangeName,"fanout") ;
        channel.queueBind(queueName,exchangeName,"");
        channel.basicQos(1);

        DefaultConsumer defaultConsumer =new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,Envelope envelope,AMQP.BasicProperties properties,byte[] body) throws IOException {
                String msg =new String(body) ;
                System.out.println("Fanout消费者1:"+msg);
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(queueName,false,defaultConsumer) ;
    }

    /**
     * 路由订阅
     * 绑定 三种路由,对应一个队列
     * @throws Exception
     */
    @GetMapping("/rabbit/direct/consumer")
    public void rabbitConsumerDirect() throws Exception {
        String exchangName ="manage_exchange_direct" ;
        String queueName ="direct_queue_1" ;
        channel.queueDeclare(queueName,false,false,false,null) ;
        channel.queueBind(queueName,exchangName,"delete");
        channel.queueBind(queueName,exchangName,"update");
        channel.queueBind(queueName,exchangName,"insert");
        DefaultConsumer defaultConsumer =new DefaultConsumer(channel){

            @Override
            public void handleDelivery(String consumerTag,Envelope envelope,AMQP.BasicProperties properties,byte[] body) throws IOException {

                String msg =new String(body) ;
                System.out.println("Direct消费者1:"+msg);
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(queueName,false,defaultConsumer) ;
    }

    /**
     * 通配符模式
     * @throws Exception
     */
    @GetMapping("/rabbit/topic/consumer")
    public void rabbitConsumerTopic() throws Exception {
        String exchangeName ="manage_exchange_topic" ;
        String queueName ="topic_queue_1" ;
        channel.queueDeclare(queueName,false,false,false,null) ;
        channel.queueBind(queueName,exchangeName,"product.*");
        DefaultConsumer defaultConsumer =new DefaultConsumer(channel){

            @Override
            public void handleDelivery(String consumerTag,Envelope envelope,AMQP.BasicProperties properties,byte[] body) throws IOException {
                String msg =new String(body) ;
                System.out.println("消费者1："+msg);

                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(queueName,false,defaultConsumer);
    }


}
