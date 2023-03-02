package org.tts.config;

import org.springframework.stereotype.Component;
import org.tts.service.MessageNotifier;
import org.tts.service.serviceImpl.TMMessageNotifier;
import org.tts.service.serviceImpl.WareMessageNotifier;

import javax.annotation.Resource;

/**
 * @Description : 策略模式上下文
 * @Auther : Tianjx
 * @CreateTime : 2022/11/18 13:11
 * 为了是找到实现MessageNotifier接口的类
 */
@Component
public class StrategyDesignContext {

    @Resource
    private TMMessageNotifier tmMessageNotifier;

    @Resource
    private WareMessageNotifier wareMessageNotifier;

    public MessageNotifier getNotifierService(int type){
        switch (type){
            case 1:
                return wareMessageNotifier;
            case 0:
                return tmMessageNotifier;
        }
        return null;
    }

}
