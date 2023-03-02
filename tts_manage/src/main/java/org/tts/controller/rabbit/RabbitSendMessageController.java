package org.tts.controller.rabbit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tts.config.RabbitMQConfig;
import org.tts.domain.mysql.DHemsInOrderStatus17HMapper;
import org.tts.domain.mysql.DPlRabbitMessageMapper;
import org.tts.domain.mysql.entity.DHemsInOrderStatus17H;
import org.tts.domain.mysql.entity.DPlRabbitMessage;
import org.tts.domain.mysql.entity.DPlTmOrderH;
import org.tts.domain.mysql.entity.DWareBase;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description : spingboot 测试Rabbit发送消息
 * @Auther : Tianjx
 * @CreateTime : 2022/10/19 14:05
 */
@RestController
@Slf4j
public class RabbitSendMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Resource
    private DHemsInOrderStatus17HMapper dHemsInOrderStatus17HMapper;
    @Resource
    private DPlRabbitMessageMapper dPlRabbitMessageMapper;

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式

    /**
     * DirectExchange
     */
    @GetMapping("message")
    public void sendRabbitMessage(){
        for (int i = 0; i < 1; i++) {
            String sendMsg ="生产者"+i+"发送订单消息" ;
            CorrelationData correlationData =new CorrelationData();
            //correlationData.setId(i+"");

            //MessageProperties messageProperties =new MessageProperties();
            //messageProperties.setDelay(10000);
            //messageProperties.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
            //Message message =new Message(null,messageProperties);
            //correlationData.setReturnedMessage(message);
            //int finalI = i;
            rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE,RabbitMQConfig.NOMAL_ROUTE_KEY,sendMsg, message1 -> {
                //message1.getMessageProperties().setDeliveryTag(finalI);
                //message1.getMessageProperties().setExpiration("10000");
                //message1.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message1;
            },correlationData);
        }



        log.info("生产者发送成功,时间为{}",sdf.format(new Date()));
    }

    /**
     * 延迟消息  延迟交换机:x-delayed-message
     * 非持久化
     */
    @GetMapping("message/delay")
    public void sendDelayRabbitMessage(){
        String sendMsg ="生产者发送订单消息" ;
        rabbitTemplate.convertAndSend(RabbitMQConfig.DELAY_EXCHANGE
                , RabbitMQConfig.DELAY_ROUTE_KEY, sendMsg, message -> {
                    //设置发送消息的延迟时间
                    message.getMessageProperties().setMessageId("1111");
                    message.getMessageProperties().setDelay(10000);
                    //message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    message.getMessageProperties().setDeliveryTag(1100241151652610065L);
                    return message;
                });

        log.info("生产者发送成功:{},时间为{}",sendMsg,sdf.format(new Date()));
    }

    @GetMapping("message/{message}/{ttlTime}")
    public void sendMessageTTL(@PathVariable String message, @PathVariable String ttlTime) {
        log.info("发送带有过期时间的消息到MQ - 消息内容 [{}] - 存活时间 [{}]", JSON.toJSONString(message), JSON.toJSONString(ttlTime));
        log.info("发送消息当前时间：{}", new Date());
        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, RabbitMQConfig.NOMAL_ROUTE_KEY, message, correlationData -> {
            //设置消息过期时间
            correlationData.getMessageProperties().setCorrelationId("1");
            correlationData.getMessageProperties().setDelay(5);
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
                rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, RabbitMQConfig.NOMAL_ROUTE_KEY,dPlTmOrderH,correlationData);
            }else{
                DWareBase dWareBase = new DWareBase();
                dWareBase.setId(Integer.valueOf(i).longValue());
                CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
                rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, RabbitMQConfig.NOMAL_ROUTE_KEY,dWareBase,correlationData);
            }
        }
    }


    /**
     *  发送订单信息
     */
    @GetMapping("message/order")
    public void sendOrderStatusMessage(){
        Date now  =new Date();
        DHemsInOrderStatus17H dHemsInOrderStatus17HQuery =new DHemsInOrderStatus17H();
        dHemsInOrderStatus17HQuery.setStatus(0);
        List<DHemsInOrderStatus17H> dHemsInOrderStatus17HList = dHemsInOrderStatus17HMapper.queryAll(dHemsInOrderStatus17HQuery);
        for (DHemsInOrderStatus17H dHemsInOrderStatus17H : dHemsInOrderStatus17HList) {

            String orderId = dHemsInOrderStatus17H.getOrderId();
            Integer stautsOflineHems = dHemsInOrderStatus17H.getStautsOflineHems();
            JSONObject jsonObject =new JSONObject();
            jsonObject.put("orderId",orderId);
            jsonObject.put("stautsOflineHems",stautsOflineHems);

            String sendMsg =jsonObject.toJSONString() ;
            DPlRabbitMessage dPlRabbitMessage =null;
            DPlRabbitMessage dPlRabbitMessageQuery = dPlRabbitMessageMapper.queryByPk(orderId,1);
            if(dPlRabbitMessageQuery==null){
                dPlRabbitMessage =new DPlRabbitMessage();
            }else{
                dPlRabbitMessage=dPlRabbitMessageQuery;
            }

            dPlRabbitMessage.setOrderId(orderId);
            dPlRabbitMessage.setType(1);
            dPlRabbitMessage.setMessage(sendMsg);
            dPlRabbitMessage.setStatus(0);
            dPlRabbitMessage.setMaxtrycount(3);
            dPlRabbitMessage.setCurrentretrycount(0);
            dPlRabbitMessage.setExchangename(RabbitMQConfig.DIRECT_EXCHANGE);
            dPlRabbitMessage.setRoutingkey(RabbitMQConfig.NOMAL_ROUTE_KEY);
            dPlRabbitMessage.setUpdateTime(now);
            if(dPlRabbitMessageQuery==null){
                dPlRabbitMessage.setCreateTime(now);
                dPlRabbitMessageMapper.insert(dPlRabbitMessage);
            }else{
                dPlRabbitMessageMapper.updateByPk(dPlRabbitMessage);
            }

            CorrelationData correlationData =new CorrelationData();
            correlationData.setId(orderId);

            rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE,RabbitMQConfig.NOMAL_ROUTE_KEY,sendMsg, message1 -> {
                message1.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                message1.getMessageProperties().setMessageId(orderId);
                return message1;
            },correlationData);
        }
        log.info("生产者发送成功,时间为{}",sdf.format(new Date()));
    }

    /**
     * 模拟定时任务查找 生产方发送消息失败重试发送
     */
    @GetMapping("/scheduledQuery/order")
    public void scheduledQuery(){
        Date now =new Date();
        DPlRabbitMessage dPlRabbitMessageQuery =new DPlRabbitMessage();
        dPlRabbitMessageQuery.setStatus(2);
        List<DPlRabbitMessage> dPlRabbitMessages = dPlRabbitMessageMapper.queryAll(dPlRabbitMessageQuery);
        for (DPlRabbitMessage dPlRabbitMessage : dPlRabbitMessages) {
            String message = dPlRabbitMessage.getMessage();
            String exchangename = dPlRabbitMessage.getExchangename();
            String routingkey = dPlRabbitMessage.getRoutingkey();
            String orderId = dPlRabbitMessage.getOrderId();
            int currentretrycount = dPlRabbitMessage.getCurrentretrycount();
            int maxtrycount = dPlRabbitMessage.getMaxtrycount();

            if(currentretrycount <= maxtrycount){
                CorrelationData correlationData =new CorrelationData();
                correlationData.setId(orderId);

                rabbitTemplate.convertAndSend(exchangename,routingkey,message, message1 -> {
                    message1.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    message1.getMessageProperties().setMessageId(orderId);
                    return message1;
                },correlationData);
                //修改重试次数
                int cuRetryCount=currentretrycount+1;
                dPlRabbitMessage.setCurrentretrycount(cuRetryCount);

            }else{
                //大于最大的重试次数,修改其状态停止重试发送消息
                dPlRabbitMessage.setStatus(4);
            }
            dPlRabbitMessage.setUpdateTime(now);
            dPlRabbitMessageMapper.updateByPk(dPlRabbitMessage);
        }
    }
}
