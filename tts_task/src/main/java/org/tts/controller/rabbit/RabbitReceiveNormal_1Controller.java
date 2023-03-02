package org.tts.controller.rabbit;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RestController;
import org.tts.config.RabbitMQConfig;
import org.tts.domain.mysql.entity.DPlTmOrderH;
import org.tts.domain.mysql.entity.DWareBase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

/**
 * @Description : spingboot 整合rabbit
 * @Auther : Tianjx
 * @CreateTime : 2022/10/19 14:58
 */
@RestController
@Slf4j
//@RabbitListener(queues = {RabbitMQConfig.DIRECT_QUEUE_NAME})
public class RabbitReceiveNormal_1Controller {

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
    /**
     * 分别接收不同类型的消息
     * @param dPlTmOrderH
     */
    @RabbitHandler
    public void receive(Message message,Channel channel,DPlTmOrderH dPlTmOrderH) throws IOException {
        log.info("消费者order接收："+dPlTmOrderH);

        //消息头属性
        //获取消息的标签，在channel内是按顺序递增的
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        /**
         * 成功消费之后进行手动应答，RabbitMQ就可以将消费过的消息丢弃了
         * 参数1：消息的标记（tag）
         * 参数2：是否批量应答；false表示消费一个才应答一个，true表示消费一个之后将channel中小于tag标记的消息都应答了
         */
        channel.basicAck(deliveryTag,false);
    }
    @RabbitHandler
    public void receive(Message message,Channel channel,DWareBase dWareBase) throws IOException {
        log.info("消费者ware接收："+dWareBase);
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        channel.basicAck(deliveryTag,false);
    }

    /**
     * 1、spring-retry 消费端出现异常 配置重试机制 需要将其异常抛出才可生效 ,如果配置文件中配置手动确认需要调用 channel.basicAck/ channel.basicReject 消息才
     * 可进入到死信队列中
     * 2、如果整个消费端接口超时或者异常,消息会通过配置了过期时间,直接进入到死信队列中
     *
     * @param message
     * @param channel
     * @param msg
     * @throws IOException
     */
    @RabbitHandler
    public void receive(Message message,Channel channel,String msg) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        String messageId = message.getMessageProperties().getMessageId();
        //Thread.sleep(5000);
        log.info("消费者_1_接收:{},message为{},channel为{},当前时间点为{}",msg, JSON.toJSONString(message),JSON.toJSONString(channel),sdf.format(new Date()) );
        // 模拟异常情况
        channel.basicNack(deliveryTag,false,false);
//        try {
//            log.info("消费者_1_接收:{},当前时间点为{}",msg,sdf.format(new Date()) );
//            throw new Exception("业务逻辑发生异常");
//            //手动响应
//            //channel.basicAck(deliveryTag,false);
//        } catch (Exception e) {
//            channel.basicNack(deliveryTag,false,false);
//            throw new RuntimeException("抛出异常，模拟消费失败，触发spring-retry");
//        }
    }

}
