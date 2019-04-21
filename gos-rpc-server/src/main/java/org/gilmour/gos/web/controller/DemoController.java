package org.gilmour.gos.web.controller;

import org.gilmour.gos.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoServiceImpl;

    @RequestMapping("/")
    String home() {
        return demoServiceImpl.Hello("server");
    }
}
