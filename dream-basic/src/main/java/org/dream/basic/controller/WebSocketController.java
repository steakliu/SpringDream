package org.dream.basic.controller;

import com.alibaba.fastjson.JSONObject;
import org.dream.basic.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘牌
 * @Date 2020/5/27 0027 11:50
 * @Version 1.0
 */
@RestController
public class WebSocketController {

    @Autowired
    private WebSocket webSocket;

    @GetMapping("/websocket")
    public void send(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("test","steak");
        webSocket.sendMessage(jsonObject);
    }
}
