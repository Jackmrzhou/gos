package org.gilmour.gos.common.impl;

import org.gilmour.gos.common.DataServer;
import org.gilmour.gos.common.Resolver;
import org.springframework.stereotype.Component;

@Component
public class ZooKeeperResolver implements Resolver {

    @Override
    public DataServer GetDataServer() {
        return new DataServer("1","10.214.213.43", 9001);
    }

    @Override
    public boolean CheckDataServer(DataServer dataServer) {
        return true;
    }
}
