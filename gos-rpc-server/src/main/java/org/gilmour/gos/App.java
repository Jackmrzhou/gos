package org.gilmour.gos;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.gilmour.gos.conf.dubbo_config;
import org.gilmour.gos.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
//@EnableDubbo(scanBasePackages = "org.gilmour.gos.servicesImpl")
public class App {

    public static void main(String[] args) {
        new SpringApplicationBuilder(dubbo_config.class)
                .child(App.class)
                .build()
                .run(args);
    }

}