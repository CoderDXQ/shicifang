package com.tensquare.friend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import util.IdWorker;
import util.JwtUtil;

/**
 * @Author ysl
 * @Date 2019/12/13 22:04
 * @Description:
 **/

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);

    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
