package org.tts.service.common;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description :
 * @Auther : Tianjx
 * @CreateTime : 2022/11/11 14:00
 */
@FeignClient("tts-task")
public interface FeignService {

    @GetMapping("/getHello")
    String getHello();
}
