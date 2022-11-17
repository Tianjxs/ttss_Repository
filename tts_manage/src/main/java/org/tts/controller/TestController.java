package org.tts.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tts.domain.mysql.DPlTmOrderHMapper;
import org.tts.domain.mysql.entity.DPlTmOrderH;
import org.tts.service.common.FeignService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Auther : Tianjx
 * @CreateTime : 2022/10/12 14:50
 */
@RestController
public class TestController {

    @Resource
    private DPlTmOrderHMapper dPlTmOrderHMapper ;

    @Autowired
    private FeignService feignService;

    @GetMapping("/test")
    public String test(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String hello = feignService.getHello();
        return hello ;
    }

    @GetMapping("/fallback")
    public String fallback(){

        return "调用上级方法异常,调用此方法进行熔断" ;
    }

    @GetMapping("/test1")
    public String test1(){

        return "hello" ;
    }
    @GetMapping("/test2")
    public String test2(String baz){

        return "hello_Baz:"+baz ;
    }
}
