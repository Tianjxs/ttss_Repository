package org.tts.controller.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Description :  消息确认机制
 * @Auther : Tianjx
 * @CreateTime : 2022/10/20 13:15
 */
@Configuration
@Slf4j
public class RabbitSendCallBackController {

    @Autowired
    private RabbitTemplate rabbitTemplate ;

    /**
     *  @PostConstruct：RabbitTemplateConfig对象创建完成之后，执行这个注解标识的方法
     * 消息抵达MQ服务回调confirmCallBack
     */
    @PostConstruct
    public void rabbitConfirmInit(){

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             * 用于监听消息确认结果（消息是否发送到交换机），只要成功抵达（即ack=ture）
             * @param correlationData：当前消息的唯一关联数据（里面包含消息id，correlationData.getId()获取），可以在发送消息的时候进行设置new CorrelationData("消息id");
             * @param ack：消息是否成功抵达
             * @param cause：失败的原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                Message returnedMessage = correlationData.getReturnedMessage();
                log.info("confirm消息回调,id为{},msg为{},ack为{},cause为{},correlationData为{}",null,returnedMessage,ack,cause,correlationData);
            }
        });
    }

    /**
     * 设置消息抵达队列的确认回调，消息正确抵达队列不会回调此方法，如果没有抵达，则会触发此回调
     */
    @PostConstruct
    public void rabbitReturnInit(){
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /**
             * 只要消息没有正确投递到队列，就触发这个失败的回调
             * @param message：投递失败的消息详细信息
             * @param replyCode：回复的状态码
             * @param replyText：回复的文本内容
             * @param exchange：这个消息发送到哪个交换器
             * @param routingKey：这个消息用哪个路由键
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.info("return消息抵达队列失败,当前消息的内容{},回复的状态码{},回复的文本内容{},交换机{},路由键{}",
                        message,replyCode,replyText,exchange,routingKey);
            }
        });
    }
}
