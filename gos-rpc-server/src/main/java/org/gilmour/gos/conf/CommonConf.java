package org.gilmour.gos.conf;

import org.gilmour.gos.aspects.LogTimeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class CommonConf {
    @Bean
    public LogTimeAspect getBean(){
        return new LogTimeAspect();
    }
}
