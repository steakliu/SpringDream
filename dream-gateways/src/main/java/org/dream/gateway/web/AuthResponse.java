package org.dream.gateway.web;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @Author 刘牌
 * @Date 2020/4/24 0024 23:16
 * @Version 1.0
 * 鉴权响应
 */

public class AuthResponse {
    /**
     *
     * @param response
     * @param msg
     * @return
     */
    public static Mono<Void> unAuth(ServerHttpResponse response,String msg){
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        DataBuffer buffer = response.bufferFactory().wrap(msg.getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Flux.just(buffer));
    }
}
