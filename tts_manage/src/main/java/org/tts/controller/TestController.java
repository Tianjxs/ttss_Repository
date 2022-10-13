package org.tts.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tts.domain.mysql.DPlTmOrderHMapper;
import org.tts.domain.mysql.entity.DPlTmOrderH;

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

    @GetMapping("/test")
    public String test(){
        Map<String,Object> resultMap =new HashMap<>() ;
        DPlTmOrderH dPlTmOrderH = dPlTmOrderHMapper.queryByPk(1520821812202854998L);
        resultMap.put("data",dPlTmOrderH);
        System.out.println("嘻嘻嘻");
        return JSON.toJSONString(resultMap) ;
    }
}
