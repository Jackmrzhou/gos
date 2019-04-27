package org.gilmour.gos.common;

public interface Resolver {
    DataServer GetDataServer();
    boolean CheckDataServer(DataServer dataServer);
}
