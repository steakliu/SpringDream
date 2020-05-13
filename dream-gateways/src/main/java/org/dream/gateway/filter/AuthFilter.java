package org.dream.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.dream.commons.constants.global.GlobalConstant;
import org.dream.gateway.route.Route;
import org.dream.gateway.utils.JwtUtil;
import org.dream.gateway.web.AuthResponse;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import javax.annotation.Resource;
/**
 * @Author 刘牌
 * @Date 2020/4/22 0022 22:45
 * @Version 1.0
 */
@Component
@Slf4j
public class AuthFilter implements GlobalFilter, Ordered {

    @Resource
    private JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        /**
         * 无需鉴权的路由
         */
        if (Route.unAuthRoute().contains(exchange.getRequest().getURI().getPath())) {
            return chain.filter(exchange);
        }
        String token = exchange.getRequest().getHeaders().getFirst(GlobalConstant.TOKEN);
        ServerHttpResponse response = exchange.getResponse();
        /**
         * token为空
         */
        if (token == null) {
            return AuthResponse.unAuth(response,"令牌为空，不能进行鉴权");
        }
        /**
         * 校验token
         */
        boolean b = jwtUtil.checkToken(token);
        /**
         *  token过期
         */
        if (!b){
            return AuthResponse.unAuth(response,"令牌已过期");
        }

        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
