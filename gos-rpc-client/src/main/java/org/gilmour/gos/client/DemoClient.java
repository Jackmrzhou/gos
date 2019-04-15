package org.gilmour.gos.client;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "org.gilmour.gos.client.consumer")
//@ComponentScan(value = {"org.gilmour.gos.client.consumer"})
public class DemoClient{

    public static void main(String[] args) {
        SpringApplication.run(DemoClient.class, args);
    }
}