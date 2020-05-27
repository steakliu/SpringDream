package org.dream.basic.websocket;

import com.alibaba.fastjson.JSONObject;
import org.dream.web.BusinessException;
import org.dream.web.CommonErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author 刘牌
 * @Date 2020/5/25 0025 0:36
 * @Version 1.0
 */
@Component
@ServerEndpoint("/webSocket")
public class WebSocket {
    private static final Logger log = LoggerFactory.getLogger(WebSocket.class);

    private static int connectNum = 0;
    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();
    private Session session;

    /**
     * webSocket连接建立成功调用的方法
     * @param session
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSockets.add(this);
    }

    @OnClose
    public void onClose(){
        webSockets.remove(this);
    }

    public void sendMessage(JSONObject jsonObject){
        try {
            this.session.getBasicRemote().sendObject(jsonObject);
        }catch (Exception e){
            log.error("【消息推送异常】 ",e);
            throw new BusinessException(CommonErrorEnum.PARAM_ERROR);
        }

    }
}
