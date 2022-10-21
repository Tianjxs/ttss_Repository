package org.tts.controller.rabbit;

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

/**
 * @Description : spingboot 整合rabbit
 * @Auther : Tianjx
 * @CreateTime : 2022/10/19 14:58
 */
@RestController
@Slf4j
public class RabbitReceiveMessageController {

   /* @RabbitListener(queues = {RabbitMQConfig.NOMAL_QUEUE_NAME})
    public void receiveRabbitMessage(String msg){
        log.info("消费者1接收："+msg);
    }*/

    @RabbitListener(queues = {RabbitMQConfig.DEAD_QUEUE_NAME})
    public void receiveRabbitMessage(Message message, Channel channel) throws IOException {
        log.info("消费者1接收dead_queue队列的消息：[{}]", new String(message.getBody()));
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        channel.basicAck(deliveryTag,false);
    }
}
