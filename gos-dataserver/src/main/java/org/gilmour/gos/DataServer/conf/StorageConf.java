package org.gilmour.gos.DataServer.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "Store")
public class StorageConf {
    @Value("${BasePath}")
    private String BasePath;

    public String getBasePath() {
        return BasePath;
    }

    public void setBasePath(String basePath) {
        BasePath = basePath;
    }
}
