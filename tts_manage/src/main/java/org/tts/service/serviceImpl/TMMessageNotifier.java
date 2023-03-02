package org.tts.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.tts.domain.mysql.entity.DPlTmOrderH;
import org.tts.service.MessageNotifier;

/**
 * @Description : 实现策略模式接口之一
 * @Auther : Tianjx
 * @CreateTime : 2022/11/18 11:37
 */
@Service
@Slf4j
public class TMMessageNotifier implements MessageNotifier<DPlTmOrderH> {


    @Override
    public boolean support(int norifyType) {
        return norifyType==0;
    }

    @Override
    public void notify(DPlTmOrderH dPlTmOrderH) {
     log.info("调用天猫接口进行查询订单信息{}", JSON.toJSON(dPlTmOrderH));
    }
}
