package org.gilmour.gos.client.consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.gilmour.gos.services.DemoService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class DemoServiceConsumer {
    @Reference
    private DemoService demoService;

    @RequestMapping("/")
    String home() {
        return demoService.Hello("client");
    }

}
