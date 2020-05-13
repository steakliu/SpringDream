package org.dream.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @Author 刘牌
 * @Date 2020/4/22 0022 23:52
 * @Version 1.0
 */

/**
 * SpringBoot默认只会扫描本项目下的包，此处需要设置scanBasePackages
 */
@SpringBootApplication(scanBasePackages = "org.dream")
@EnableDiscoveryClient
public class BasicApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class,args);
    }
}
