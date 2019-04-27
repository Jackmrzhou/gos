package org.gilmour.gos.servicesImpl;

import org.gilmour.gos.enums.ImageFormat;
import org.gilmour.gos.models.DefaultGImageImpl;
import org.gilmour.gos.models.GImage;
import org.gilmour.gos.services.ImageService;
import org.springframework.boot.test.context.TestComponent;

import java.io.File;
import java.io.IOException;
import java.net.URI;

@TestComponent
public class MockImageServiceImpl implements ImageService {

    @Override
    public String PutImage(GImage image) throws IOException{
        return "testGosKey";
    }

    @Override
    public GImage GetImage(String GosKey) throws IOException {
        URI uri = null;
        try {
            uri = new File("/home/jack/projects/gos/gos-rpc-server/src/test/resources/test_images/favicon.jpg").toURI();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new DefaultGImageImpl(uri, ImageFormat.JPG);
    }
}
