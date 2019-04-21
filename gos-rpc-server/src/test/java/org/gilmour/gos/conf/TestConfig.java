package org.gilmour.gos.conf;

import org.gilmour.gos.services.ImageService;
import org.gilmour.gos.servicesImpl.MockImageServiceImpl;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {
    @Bean
    public ImageService getBean(){
        return new MockImageServiceImpl();
    }
}
