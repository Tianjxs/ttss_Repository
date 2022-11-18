package org.tts.controller.sentinel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description :sentinel 限流
 * @Auther : Tianjx
 * @CreateTime : 2022/11/04 17:00
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "--------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "---------testB";
    }

}
