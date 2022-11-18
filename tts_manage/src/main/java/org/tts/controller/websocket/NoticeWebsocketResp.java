package org.tts.controller.websocket;

import lombok.Data;

/**
 * @Description :
 * @Auther : Tianjx
 * @CreateTime : 2022/11/07 15:12
 */
@Data
public class NoticeWebsocketResp<T> {


    private String noticeType;


    private T noticeInfo;

}
