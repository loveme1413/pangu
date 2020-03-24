package com.miaosuan.pangu.b2b.mall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 商城主程序入口
 *
 * @author spy
 * @version 1.0 2019-06-02
 * @since 1.0
 */
@Slf4j
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {
        "com.miaosuan.pangu.b2b.*.api.*.client" // cloud接口
})
@SpringCloudApplication
@ComponentScan("com.miaosuan")
public class MallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }
}
