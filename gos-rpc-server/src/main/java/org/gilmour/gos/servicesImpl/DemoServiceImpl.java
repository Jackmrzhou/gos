package org.gilmour.gos.servicesImpl;


import org.apache.dubbo.config.annotation.Service;
import org.gilmour.gos.services.DemoService;
import org.springframework.stereotype.Repository;

@Repository
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String Hello(String name) {
        return "Hello "+name +" #from RPC Server";
    }
}
