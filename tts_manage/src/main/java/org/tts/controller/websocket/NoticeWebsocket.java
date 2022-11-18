package org.tts.controller.websocket;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description :
 * @Auther : Tianjx
 * @CreateTime : 2022/11/07 15:09
 */

@ServerEndpoint("/notice/{userId}")
@Component
@Slf4j
public class NoticeWebsocket{

    //记录连接的客户端
    public static Map<String, Session> clients = new ConcurrentHashMap<>();

    /**
     * userId关联sid（解决同一用户id，在多个web端连接的问题）
     */
    public static Map<String, Set<String>> conns = new ConcurrentHashMap<>();

    private String sid = null;

    private String userId;


    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        String tempSid = session.getId();
        this.sid = tempSid;
        this.userId = userId;
        clients.put(tempSid, session);

        Set<String> clientSet = conns.get(userId);
        if (clientSet==null){
            clientSet = new HashSet<>();
            conns.put(userId,clientSet);
        }
        clientSet.add(tempSid);
        log.error("DeviceWebsocket---onOpen===>id:{}--{}--连接数：{}--在线数：{}--当前设备连接数：{}", userId, tempSid, clients.size(), conns.size(), conns.get(userId).size());
    }

    @OnClose
    public void onClose(Session session, @PathParam("userId") String userId) {
        String tempSid = session.getId();
        //log.info(this.sid + "连接断开！");
        closeSession(tempSid, userId);
    }

    public void closeSession(String sid, String userId){
        Session s  = clients.remove(sid);
        if (s!=null){
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Set<String> clientSet = conns.get(userId);
        if (clientSet!=null){
            clientSet.remove(sid);
        }
        int currentConnectCount = clientSet.size();
        if(clientSet!=null && clientSet.size()==0){
            conns.remove(userId);
            currentConnectCount = 0;
        }
        log.error("DeviceWebsocket---onClose===>id:--{}--{}--连接数：{}--在线数：{}--当前设备连接数：{}", userId, sid, clients.size(), conns.size(), currentConnectCount);
        //log.error("在线人数===="+clients.size());
    }

    public static void sendMessage(String noticeType){
        NoticeWebsocketResp noticeWebsocketResp = new NoticeWebsocketResp();
        noticeWebsocketResp.setNoticeType(noticeType);
        sendMessage(noticeWebsocketResp);
    }


    /**
     * 发送给所有用户
     * @param noticeWebsocketResp
     */
    public static void sendMessage(NoticeWebsocketResp noticeWebsocketResp){
        String message = JSONObject.toJSONString(noticeWebsocketResp);
        for (Session session1 : NoticeWebsocket.clients.values()) {
            try {
                session1.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据用户id发送给某一个用户
     * **/
    public static void sendMessageByUserId(String userId, NoticeWebsocketResp noticeWebsocketResp) {
        if (!StringUtils.isEmpty(userId)) {
            String message = JSONObject.toJSONString(noticeWebsocketResp);
            Set<String> clientSet = conns.get(userId);
            if (clientSet != null) {
                Iterator<String> iterator = clientSet.iterator();
                while (iterator.hasNext()) {
                    String sid = iterator.next();
                    Session session = clients.get(sid);
                    if (session != null) {
                        try {
                            session.getBasicRemote().sendText(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else {
                        iterator.remove();;
                    }
                }
            }
        }
    }

    @OnError
    public void onError(Throwable error) {
        error.printStackTrace();
    }

}
