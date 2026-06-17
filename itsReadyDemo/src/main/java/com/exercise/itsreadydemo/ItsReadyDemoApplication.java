package com.exercise.itsreadydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients()
public class ItsReadyDemoApplication {

    public static void main(String[] args) {
       SpringApplication.run(ItsReadyDemoApplication.class, args);

//        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(
//                ItsReadyDemoApplication.class
//        ).web(WebApplicationType.NONE).run(args);
//
//        WebClient loadBalancedClient = ctx.getBean(WebClient.Builder.class).build();
//
//        for (int i = 0; i < 10; i++) {
//            String response = loadBalancedClient.get()
//                    .uri("http://StoreApplication/instance")
//                    .retrieve()
//                    .toEntity(String.class)
//                    .block().getBody();
//            System.out.println(response);
//        }
    }

}
