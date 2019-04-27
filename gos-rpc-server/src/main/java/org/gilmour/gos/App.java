package org.gilmour.gos;

import org.gilmour.gos.conf.dubbo_config;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        new SpringApplicationBuilder(dubbo_config.class)
                .child(App.class)
                .build()
                .run(args);
    }

}