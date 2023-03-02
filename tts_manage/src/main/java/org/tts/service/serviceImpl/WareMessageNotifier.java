package org.tts.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.tts.domain.mysql.entity.DWareBase;
import org.tts.service.MessageNotifier;

/**
 * @Description : 实现策略模式接口之一
 * @Auther : Tianjx
 * @CreateTime : 2022/11/18 11:40
 */
@Service
@Slf4j
public class WareMessageNotifier implements MessageNotifier<DWareBase> {

    @Override
    public boolean support(int norifyType) {
        return norifyType==1;
    }

    @Override
    public void notify(DWareBase dWareBase) {
        log.info("调用商品接口进行查询订单信息。。。。。。。。");
    }
}
