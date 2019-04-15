package org.gilmour.gos;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.gilmour.gos.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
@EnableDubbo(scanBasePackages = "org.gilmour.gos.servicesImpl")
public class App {

    @Autowired
    private DemoService demoServiceImpl;

    @RequestMapping("/")
    String home() {
        return demoServiceImpl.Hello("server");
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}