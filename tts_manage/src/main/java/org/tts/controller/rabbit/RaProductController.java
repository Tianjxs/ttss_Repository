package org.tts.controller.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tts.util.RabbitConnectUtils;
/**
 * @Description : RabbitMQ 本地测试
 * @Auther : Tianjx
 * @CreateTime : 2022/10/17 14:53
 */
@RestController
public class RaProductController {

    @Autowired
    private RabbitAdmin rabbitAdmin ;
//    private Connection connection ;
//
//    private Channel channel;
//
//    public RaProductController() throws Exception {
//        connection =RabbitConnectUtils.getConnection();
//        channel =connection.createChannel();
//    }

    /**
     * 测试 P2P 点对点模式
     * @param msg
     * @throws Exception
     */
//    @GetMapping("/rabbit/product")
//    public void rabbitProductMessage(String msg) throws Exception {
//        channel.queueDeclare("manageQueue",false,false,false,null) ;
//        channel.basicPublish("","manageQueue",null,msg.getBytes());
//        System.out.println("生产者P2P消息已发送成功");
//    }
//
//    @GetMapping("/rabbit/work/product/declare")
//    public void rabbitProductWorkForDeclare() throws Exception {
//        channel.queueDeclare("manage_work_queue",false,false,false,null);
//    }

    /**
     * 工作模式
     * 一个消费者来处理消息，如果生产者生产消息过快过多，而消费者的能力有限
     * 就会产生消息在队列中堆积（生活中的滞销）
     * 模拟场景
     */
//    @GetMapping("/rabbit/work/product")
//    public void rabbitProductWork() throws Exception {
//        for (int i=0; i<10; i++){
//            String msg ="羊肉串==>"+i ;
//            channel.basicPublish("","manage_work_queue",null,msg.getBytes());
//            System.out.println("新鲜出炉：" + msg);
//        }
//    }

    /**
     * 订阅模式
     * Fanout :广播，将消息交给所有绑定到交换机的队列
     * Fanout 模式下 : 生产者的代码中不在声明队列，直接把消息发送给交换机，交换机发送给所有绑定的队列
     * @throws Exception
     */
//    @GetMapping("/rabbit/fanout/product")
//    public void rabbitProductFanout() throws Exception {
//        String msg ="Rabbit采用fanout订阅模式发送消息" ;
//        String exchange="manage_exchange_fanout" ;
//        channel.exchangeDeclare(exchange,"fanout") ;
//        channel.basicPublish(exchange,"",null,msg.getBytes());
//        System.out.println("生产者成功发送消息");
//    }

    /**
     * 路由模式
     *  Direct模型：不同的消息被不同的队列消费
     *  Direct模型：队列与交换机的绑定，不能是任意绑定了，而是要指定一个RoutingKey（路由key）
     * 消息的发送方在向Exchange发送消息时，也必须指定消息的routing key。
     * @param direct 指定路由名称
     * @throws Exception
     */
//    @GetMapping("/rabbit/direct/product")
//    public void rabbitProductDirect(String direct) throws Exception {
//        String msg ="Rabbit采用Direct订阅模式发送"+direct+"路由消息" ;
//        String exchange="manage_exchange_direct" ;
//        channel.exchangeDeclare(exchange,"direct") ;
//        channel.basicPublish(exchange,direct,null,msg.getBytes());
//        System.out.println("生产者成功发送消息");
//    }

    /**
     * 通配符模式
     * *：只能匹配一个词（正好一个词，多一个不行，少一个也不行）
     * #：匹配0个或更多个词
     * # Q1绑定了路由键*.orange.*
     * # Q2绑定了路由键*.*.rabbit和lazy.#
     * # 下面生产者的消息会被发送给哪个队列：
     * quick.orange.rabbit # Q1 Q2
     * lazy.orange.elephant # Q1 Q2
     * quick.orange.fox # Q1
     * lazy.brown.fox # Q2
     * lazy.pink.rabbit # Q2
     * quick.brown.fox # 无
     * orange # 无
     * quick.orange.male.rabbit # 无

     * @throws Exception
     */
//    @GetMapping("/rabbit/topic/product")
//    public void rabbitProductTopic(String topic) throws Exception {
//        String msg ="Rabbit采用Topic订阅模式发送"+topic+"主题消息" ;
//        String exchange="manage_exchange_topic" ;
//        channel.exchangeDeclare(exchange,"topic",true) ;
//        channel.basicPublish(exchange,topic, MessageProperties.PERSISTENT_TEXT_PLAIN,msg.getBytes());
//        System.out.println("生产者成功发送消息");
//    }
    @GetMapping("test/rabbit/admin")
    public void testRabbitAdmin(){
        rabbitAdmin.declareQueue(new Queue("admin_fanout_queue",false)) ;
    }
}
