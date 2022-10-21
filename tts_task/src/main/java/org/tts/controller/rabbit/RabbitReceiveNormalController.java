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
@RabbitListener(queues = {RabbitMQConfig.NOMAL_QUEUE_NAME})
public class RabbitReceiveNormalController {
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
    @RabbitHandler
    public void receive(Message message,Channel channel,String msg) throws IOException {
        log.info("消费者msg接收："+msg);
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        channel.basicAck(deliveryTag,false);
    }

}
