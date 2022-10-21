package org.tts.controller.rabbit;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tts.config.RabbitMQConfig;
import org.tts.domain.mysql.entity.DPlTmOrderH;
import org.tts.domain.mysql.entity.DWareBase;

import java.util.UUID;

/**
 * @Description : spingboot 整合rabbit
 * @Auther : Tianjx
 * @CreateTime : 2022/10/19 14:05
 */
@RestController
@Slf4j
public class RabbitSendMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("message")
    public void sendRabbitMessage(){
        String message ="生产者发送订单消息" ;
        rabbitTemplate.convertAndSend(RabbitMQConfig.NOMAL_EXCHANGE,RabbitMQConfig.NOMAL_ROUTE_KEY,message);
        System.out.println("生产者发送成功:"+message);
    }

    @GetMapping("message/{message}/{ttlTime}")
    public void sendMessageTTL(@PathVariable String message, @PathVariable String ttlTime) {
        log.info("发送带有过期时间的消息到MQ - 消息内容 [{}] - 存活时间 [{}]", JSON.toJSONString(message), JSON.toJSONString(ttlTime));
        rabbitTemplate.convertAndSend(RabbitMQConfig.NOMAL_EXCHANGE, RabbitMQConfig.NOMAL_ROUTE_KEY, message.getBytes(), correlationData -> {
            //设置消息过期时间
            correlationData.getMessageProperties().setExpiration(ttlTime);
            return correlationData;
        });
        log.info("发送带有过期时间的消息到MQ - 完成");
    }

    @GetMapping("order/message")
    public void sendOrderMessage(){

        for (int i = 1; i < 5; i++) {
            if(i%2 == 0){
                DPlTmOrderH dPlTmOrderH = DPlTmOrderH.builder().id(Integer.valueOf(i).longValue()).tid(1442715891217544389L).status("TRADE_FINISHED").olshopid("1").build();
                CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
                rabbitTemplate.convertAndSend(RabbitMQConfig.NOMAL_EXCHANGE, RabbitMQConfig.NOMAL_ROUTE_KEY,dPlTmOrderH,correlationData);
            }else{
                DWareBase dWareBase = new DWareBase();
                dWareBase.setId(Integer.valueOf(i).longValue());
                CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
                rabbitTemplate.convertAndSend(RabbitMQConfig.NOMAL_EXCHANGE, RabbitMQConfig.NOMAL_ROUTE_KEY,dWareBase,correlationData);
            }
        }

    }

}
