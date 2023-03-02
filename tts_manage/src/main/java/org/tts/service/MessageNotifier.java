package org.tts.service;

/**
 * @Description : 策略模式接口
 * @Auther : Tianjx
 * @CreateTime : 2022/11/18 11:34
 */
public interface MessageNotifier<T> {
    /**
     * 是否支持该类型通知方式
     * @param norifyType
     * @return
     */
    boolean support(int norifyType);

    void notify(T t) ;
}
