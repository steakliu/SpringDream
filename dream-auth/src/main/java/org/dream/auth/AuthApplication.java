package org.dream.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 刘牌
 * @Date 2020/4/23 0023 19:22
 * @Version 1.0
 */

/**
 * SpringBoot默认只会扫描本项目下的包，此处需要设置scanBasePackages
 */
@SpringBootApplication(scanBasePackages = "org.dream")
@EnableDiscoveryClient
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class , args);
    }
}
