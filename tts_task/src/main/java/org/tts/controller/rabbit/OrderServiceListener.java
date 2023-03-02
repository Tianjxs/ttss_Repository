package org.tts.controller.rabbit;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.tts.config.RabbitMQConfig;
import org.tts.domain.mysql.entity.MessageRetryDTO;
import org.tts.service.CommonMessageRetryService;

import java.io.IOException;

/**
 * @Description :
 * @Auther : Tianjx
 * @CreateTime : 2023/03/01 14:58
 */
@Component
public class OrderServiceListener extends CommonMessageRetryService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceListener.class);
    private  Channel channel;
    /**
     * 监听订单系统下单成功消息
     * @param message
     */
    @RabbitListener(queues = {RabbitMQConfig.DIRECT_QUEUE_NAME})
    public void receive(Message message, Channel channel, String msg) throws IOException {
        this.channel =channel;
        log.info("收到订单下单成功消息: {}", message.toString());
        super.initMessage(message,channel);
    }


    @Override
    protected void execute(MessageRetryDTO messageRetryDto,Message message,Channel channel) throws IOException {
        //调用扣减库存服务，将业务异常抛出来
        int i=1/0;
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        channel.basicAck(deliveryTag,false);
    }

    @Override
    protected void successCallback(MessageRetryDTO messageRetryDto) {
        //业务处理成功，回调
    }

    @Override
    protected void failCallback(MessageRetryDTO messageRetryDto,Message message) throws IOException {
        //业务处理失败，回调
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        log.info("业务处理失败，回调方法{}",deliveryTag);
        channel.basicAck(deliveryTag,false);
    }
}
