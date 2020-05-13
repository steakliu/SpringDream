package org.dream.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 刘牌
 * @Date 2020/5/4 0004 2:25
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "org.dream")
@EnableDiscoveryClient
public class SsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class,args);
    }
}
