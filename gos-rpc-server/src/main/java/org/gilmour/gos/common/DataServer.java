package org.gilmour.gos.common;

import java.io.Serializable;

public final class DataServer implements Serializable {
    private String NodeID;
    private String host;
    private int port;

    public DataServer(String NodeID, String host, int port){
        this.NodeID = NodeID;
        this.host = host;
        this.port = port;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getNodeID() {
        return NodeID;
    }

    public void setNodeID(String nodeID) {
        NodeID = nodeID;
    }
}
