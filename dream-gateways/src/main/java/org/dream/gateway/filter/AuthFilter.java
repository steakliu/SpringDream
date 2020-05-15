package org.dream.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.dream.commons.constants.global.GlobalConstant;
import org.dream.gateway.route.Route;
import org.dream.gateway.validate.JwtValidate;
import org.dream.gateway.web.AuthResponse;
import org.dream.web.result.R;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
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
    private JwtValidate jwtValidate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        /**
         * 无需鉴权的路由
         */
        if (Route.unAuthRoute().contains(exchange.getRequest().getURI().getPath())) {
            return chain.filter(exchange);
        }
        String token = exchange.getRequest().getHeaders().getFirst(GlobalConstant.TOKEN);
        /**
         * token is null
         */
        if (token == null) {
            return AuthResponse.unAuth(exchange,"令牌为空，不能进行鉴权");
        }
        /**
         * check the token
         */
        R r = jwtValidate.checkToken(token);
        if (r == null){
            return AuthResponse.unAuth(exchange,"令牌无效");
        }
        /**
         * 刷新token
         */
        if (r.getCode() == 201){
            return AuthResponse.auth(exchange,r.getData());
        }
        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return -200;
    }
}
