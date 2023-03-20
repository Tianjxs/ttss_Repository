package org.tts.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tts.config.StrategyDesignContext;
import org.tts.domain.mysql.entity.DPlTmOrderH;
import org.tts.service.MessageNotifier;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description :设计模式测试类
 * @Auther : Tianjx
 * @CreateTime : 2022/11/18 11:43
 */
@RestController
@Slf4j
public class DesignModeController {

    @Resource
    private List<MessageNotifier> messageNotifier ;

    @Resource
    private StrategyDesignContext strategyDesignContext;

    @GetMapping("/designMode/{type}")
    public void  testDesignMode(@PathVariable("type") int type){
       /* for (MessageNotifier notifier : messageNotifier) {
            if(notifier.support(type)){
                DPlTmOrderH dPlTmOrderH = DPlTmOrderH.builder().id(Integer.valueOf(1).longValue()).tid(1442715891217544389L).status("TRADE_FINISHED").olshopid("1").build();
                notifier.notify(dPlTmOrderH);
            }
        }*/
//        MessageNotifier notifierService = strategyDesignContext.getNotifierService(type);
//        if(notifierService.support(type)){
//            DPlTmOrderH dPlTmOrderH = DPlTmOrderH.builder().id(Integer.valueOf(1).longValue()).tid(1442715891217544389L).status("TRADE_FINISHED").olshopid("1").build();
//            notifierService.notify(dPlTmOrderH);
//        }
    }
}
